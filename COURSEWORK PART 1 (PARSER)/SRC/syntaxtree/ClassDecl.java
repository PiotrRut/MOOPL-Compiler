package syntaxtree;

import java.util.List;
import visitor.Visitor;

public class ClassDecl extends AST {

    public final String id;
    public final List<FieldDecl> fds;
    public final List<MethodDecl> mds;

    public ClassDecl(String id, List<FieldDecl> fds, List<MethodDecl> mds) {
        this.id = id;
        this.fds = fds;
        this.mds = mds;
    }

    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
    
}
