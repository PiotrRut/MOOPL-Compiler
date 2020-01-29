package syntaxtree;

import java.util.List;
import visitor.Visitor;

public class ClassDeclExtends extends ClassDecl {

    public final String parentId;

    public ClassDeclExtends(String id, String parentId, List<FieldDecl> fds, List<MethodDecl> mds)
    {
        super(id, fds, mds);
        this.parentId = parentId;
    }

    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
