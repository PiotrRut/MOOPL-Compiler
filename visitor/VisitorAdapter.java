package visitor;

import syntaxtree.*;

/** Implements Visitor with trivial methods (all throw an error). */
public class VisitorAdapter<T> implements Visitor<T>  {

    // List<ProcDecl> pds;
    // List<ClassDecl> cds;
    public T visit(Program n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // String id;
    // List<FieldDecl> fds;
    // List<MethodDecl> mds;
    public T visit(ClassDecl n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // String id;
    // String parentId;
    // List<FieldDecl> fds;
    // List<MethodDecl> mds;
    public T visit(ClassDeclExtends n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Type t;
    // String id;
    public T visit(FieldDecl n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Type t;
    // String id;
    // List<Formal> fs;
    // List<Stm> ss;
    // Exp e;
    public T visit(FunDecl n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // String id;
    // List<Formal> fs;
    // List<Stm> ss;
    public T visit(ProcDecl n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Type t;
    // String id;
    public T visit(Formal n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    public T visit(TypeArray n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    public T visit(TypeBoolean n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    public T visit(TypeInt n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // String id;
    public T visit(TypeClassType n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // List<Stm> ss;
    public T visit(StmBlock n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Type t;
    // String id;
    public T visit(StmVarDecl n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Exp e;
    // Stm st, sf;
    public T visit(StmIf n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Exp e;
    // Stm s;
    public T visit(StmWhile n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Exp e;
    public T visit(StmOutput n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Var v;
    // Exp e;
    public T visit(StmAssign n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Exp e1,e2,e3;
    public T visit(StmArrayAssign n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Exp e;
    // String id;
    // List<Exp> es;
    public T visit(StmCall n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Exp e1,e2;
    public T visit(ExpArrayLookup n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Exp e;
    public T visit(ExpArrayLength n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Exp e;
    // String id;
    // List<Exp> es;
    public T visit(ExpCall n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // int i;
    public T visit(ExpInteger n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    public T visit(ExpTrue n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    public T visit(ExpFalse n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Var v;
    public T visit(ExpVar n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    public T visit(ExpSelf n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Type t;
    // Exp e;
    public T visit(ExpNewArray n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // String id;
    // List<Exp> es;
    public T visit(ExpNewObject n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Exp e;
    public T visit(ExpNot n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }

    // Exp e;
    public T visit(ExpIsnull n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }
    
    // Exp e1, e2;
    // ExpOp.Op op;
    public T visit(ExpOp n) {
        throw new Error("visitor called on unexpected AST node type: " + n);
    }
}

