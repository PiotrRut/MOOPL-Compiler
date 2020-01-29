package syntaxtree;

import visitor.Visitor;

public class StmWhile extends Stm {

    public final Exp e;
    public final Stm s;

    public StmWhile(Exp e, Stm s) {
        this.e = e;
        this.s = s;
    }

    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
