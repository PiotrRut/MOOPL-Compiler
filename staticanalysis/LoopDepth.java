package staticanalysis;

import syntaxtree.*;
import visitor.VisitorAdapter;

/**
 * Visitors for calculating the depth of loop nesting in Moopl programs.
 * Note that this does not need to define visit methods for Exp nodes because
 * the Moopl grammar does not provide any way to nest a loop inside an Exp.
 */
public class LoopDepth extends VisitorAdapter<Integer> {

    public LoopDepth() {}
    
    // List<ProcDecl> pds;
    // List<ClassDecl> cds;
    public Integer visit(Program n) {
        int depth = 0;
        for (ProcDecl pd : n.pds) {
            depth = Math.max(depth, pd.accept(this));
        }
        for (ClassDecl cd : n.cds) {
            depth = Math.max(depth, cd.accept(this));
        }
        return depth;
    }

    // String id;
    // List<FieldDecl> fds;
    // List<MethodDecl> mds;
    public Integer visit(ClassDecl n) {
        int depth = 0;
        for (MethodDecl md : n.mds) {
            depth = Math.max(depth, md.accept(this));
        }
        return depth;
    }

    // String id;
    // String parentId;
    // List<FieldDecl> fds;
    // List<MethodDecl> mds;
    public Integer visit(ClassDeclExtends n) {
        int depth = 0;
        for (MethodDecl md : n.mds) {
            depth = Math.max(depth, md.accept(this));
        }
        return depth;
    }

    // Integer t;
    // String id;
    // List<Formal> fs;
    // List<Stm> ss;
    // Exp e;
    public Integer visit(FunDecl n) {
        int depth = 0;
        for (Stm s : n.ss) {
            depth = Math.max(depth, s.accept(this));
        }
        return depth;
    }

    // String id;
    // List<Formal> fs;
    // List<Stm> ss;
    public Integer visit(ProcDecl n) {
        int depth = 0;
        for (Stm s : n.ss) {
            depth = Math.max(depth, s.accept(this));
        }
        return depth;
    }

    // List<Stm> ss;
    public Integer visit(StmBlock n) {
        int depth = 0;
        for (Stm s : n.ss) {
            depth = Math.max(depth, s.accept(this));
        }
        return depth;
    }
    
    // Exp e;
    // Stm st, sf;
    public Integer visit(StmIf n) {
        return Math.max(n.st.accept(this), n.sf.accept(this));
    }

    // Exp e;
    // Stm s;
    public Integer visit(StmWhile n) {
        return 1 + n.s.accept(this);
    }
    
    // Integer t
    // String id
    public Integer visit(StmVarDecl n) {
        return 0;
    }
    
    // Exp e;
    // String id;
    // List<Exp> es;
    public Integer visit(StmCall n) {
        return 0;
    }

    // Exp e;
    public Integer visit(StmOutput n) {
        return 0;
    }

    // Var v;
    // Exp e;
    public Integer visit(StmAssign n) {
        return 0;
    }

    // Exp e1,e2,e3;
    public Integer visit(StmArrayAssign n) {
        return 0;
    }
}
