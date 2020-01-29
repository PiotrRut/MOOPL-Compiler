package syntaxtree;

import java.util.List;
import visitor.Visitor;

public abstract class MethodDecl extends AST {

    public final String id;
    public final List<Formal> fs;
    public final List<Stm> ss;
    
    /**
     * Assigned in a preliminary pass by a compiler or interpreter.
     * The number of local variable slots (NOT parameters) which need to be
     * allocated on the stack when executing a call to this method.
     */
    public int stackAllocation;

    protected MethodDecl(String aid, List<Formal> afs, List<Stm> ass) {
        id = aid;
        fs = afs;
        ss = ass;
    }

    public abstract <T> T accept(Visitor<T> v);
}
