package staticanalysis;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import staticanalysis.ClassSignature;
import staticanalysis.MethodSignature;
import staticanalysis.SymbolTable;
import syntaxtree.*;
import visitor.VisitorAdapter;

/**
 *
 */
public class VarAllocator extends VisitorAdapter<Void> {
    
    int count, maxCount;
    
    Deque<Map<String, Integer>> blockStack;
    
    SymbolTable symTab;
    
    String currentClassName;
    
    public VarAllocator(SymbolTable symTab) {
        this.symTab = symTab;
        count = 0;
        maxCount = 0;
        blockStack = new java.util.LinkedList<>();
        currentClassName = null;
    }
    
    private void assignOffset(Var v) {
        for (Map<String, Integer> block : blockStack) {
            Integer offset = block.get(v.id);
            if (offset != null) {
                v.offset = offset;
                v.isStackAllocated = true;
                return;
            }
        }
        v.offset = getAllFieldNames(currentClassName).lastIndexOf(v.id);
        v.isStackAllocated = false;
    }
    
    private void pushBlock() {
        blockStack.push(new HashMap<>());
    }
    
    private void popBlock() {
        Map<String, Integer> block = blockStack.pop();
        count = count - block.size();
    }
    
    private void allocLocal(String id, int offset) {
        Map<String, Integer> block = blockStack.peek();
        block.put(id, offset);
    }

    /**
     * The complete list of fields for a named class, starting with all inherited
     * fields and ending with the fields declared in the named class.
     * 
     * @param className the name of the class
     * @return the list of all fields for this class (including inherited
     * fields)
     * @see ClassSignature.getImmediateFieldNames()
     */
    public List<String> getAllFieldNames(String className) {
        ClassSignature sig = symTab.getClassSignature(className);
        List<String> fields;
        String parentName = sig.getParentName();
        if (parentName == null) {
            fields = new LinkedList<>();
        } else {
            fields = getAllFieldNames(parentName);
        }
        fields.addAll(sig.getImmediateFieldNames());
        return fields;
    }
    
    

    // List<ProcDecl> pds;
    // List<ClassDecl> cds;
    public Void visit(Program n) {
        currentClassName = null; // null is the "name" of the dummy top-level class
        for (ProcDecl pd : n.pds) {
            pd.accept(this);
        }
        currentClassName = null;
        for (ClassDecl cd : n.cds) {
            cd.accept(this);
        }
        return null;
    }

    // String id;
    // List<FieldDecl> fds;
    // List<MethodDecl> mds;
    public Void visit(ClassDecl n) {
        currentClassName = n.id;
        for (MethodDecl md : n.mds) {
            md.accept(this);
        }
        return null;
    }

    // String id;
    // String parentId;
    // List<FieldDecl> fds;
    // List<MethodDecl> mds;
    public Void visit(ClassDeclExtends n) {
        currentClassName = n.id;
        for (MethodDecl md : n.mds) {
            md.accept(this);
        }
        return null;
    }

    // Type t;
    // String id;
    public Void visit(FieldDecl n) {
        return null;
    }
    
    /**
     * Allocate variables for a method declared in the current class.
     * 
     * @param id the method name
     * @param fds the formal parameters of the method declaration
     * @param ss the statements in the body of the declaration
     * @return the number of slots which need to be allocated on the stack for
     * local variables (NOT parameters) when executing a call to this method
     */
    private int allocMethod(String id, List<Formal> fds, List<Stm> ss) {
        count = 0;
        maxCount = 0;
        // allocate parameters
        int arity = fds.size();
        for (int i = 0; i < arity; ++i) {
            Formal f = fds.get(i);
            allocLocal(f.id, -(i + 3));
        }
        // process method body
        for (Stm s : ss) {
            s.accept(this);
        }
        return maxCount;
    }
    
    // String id;
    // List<Formal> fs;
    // List<Stm> ss;
    // int stackAllocation;
    // Type t;
    // Exp e;
    public Void visit(FunDecl n) {
        pushBlock();
        n.stackAllocation = allocMethod(n.id, n.fs, n.ss);
        n.e.accept(this);
        popBlock(); // leaving method scope
        return null;
    }

    // String id;
    // List<Formal> fs;
    // List<Stm> ss;
    // int stackAllocation;
    public Void visit(ProcDecl n) {
        pushBlock();
        n.stackAllocation = allocMethod(n.id, n.fs, n.ss);
        popBlock(); // leaving method scope
        return null;
    }

    // List<Stm> ss;
    public Void visit(StmBlock n) {
        pushBlock();
        for (Stm s : n.ss) {
            s.accept(this);
        }
        popBlock();
        return null;
    }

    // Type t;
    // String id;
    public Void visit(StmVarDecl n) {
        ++count;
        allocLocal(n.id, count);
        maxCount = Math.max(count, maxCount);
        return null;
    }

    // Exp e;
    // Stm st, sf;
    public Void visit(StmIf n) {
        n.e.accept(this);
        n.st.accept(this);
        n.sf.accept(this);
        return null;
    }

    // Exp e;
    // Stm s;
    public Void visit(StmWhile n) {
        n.e.accept(this);
        n.s.accept(this);
        return null;
    }

    // Exp e;
    public Void visit(StmOutput n) {
        n.e.accept(this);
        return null;
    }

    // Var v;
    // Exp e;
    public Void visit(StmAssign n) {
        assignOffset(n.v);
        n.e.accept(this);
        return null;
    }

    // Exp e1,e2,e3;
    public Void visit(StmArrayAssign n) {
        n.e1.accept(this);
        n.e2.accept(this);
        n.e3.accept(this);
        return null;
    }

    // Exp e;
    // String id;
    // List<Exp> es;
    public Void visit(StmCall n) {
        n.e.accept(this);
        for (Exp e : n.es) {
            e.accept(this);
        }
        return null;
    }

    // Exp e1,e2;
    public Void visit(ExpArrayLookup n) {
        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

    // Exp e;
    public Void visit(ExpArrayLength n) {
        n.e.accept(this);
        return null;
    }

    // Exp e;
    // String id;
    // List<Exp> es;
    public Void visit(ExpCall n) {
        n.e.accept(this);
        for (Exp e : n.es) {
            e.accept(this);
        }
        return null;
    }

    // int i;
    public Void visit(ExpInteger n) {
        return null;
    }

    public Void visit(ExpTrue n) {
        return null;
    }

    public Void visit(ExpFalse n) {
        return null;
    }

    // Var v;
    public Void visit(ExpVar n) {
        assignOffset(n.v);
        return null;
    }

    public Void visit(ExpSelf n) {
        return null;
    }

    // Type t;
    // Exp e;
    public Void visit(ExpNewArray n) {
        n.e.accept(this);
        return null;
    }

    // String id;
    // List<Exp> es;
    public Void visit(ExpNewObject n) {
        for (Exp e : n.es) {
            e.accept(this);
        }
        return null;
    }

    // Exp e;
    public Void visit(ExpNot n) {
        n.e.accept(this);
        return null;
    }

    // Exp e;
    public Void visit(ExpIsnull n) {
        n.e.accept(this);
        return null;
    }
    
    // Exp e1, e2;
    // ExpOp.Op op;
    public Void visit(ExpOp n) {
        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

}
