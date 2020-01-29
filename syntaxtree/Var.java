package syntaxtree;

public class Var extends AST {

    public final String id;

    public Var(String aid) {
        id = aid;
    }
    
    /**
     * Assigned in a preliminary pass by a compiler or interpreter.
     * For a field, this is an offset into the object containing the field.
     * For a local/parameter, this is the stack frame offset.
     */
    public int offset;
    
    /**
     * Assigned in a preliminary pass by a compiler or interpreter.
     * Set to false for fields, true for locals/parameters.
     */
    public boolean isStackAllocated;
}
