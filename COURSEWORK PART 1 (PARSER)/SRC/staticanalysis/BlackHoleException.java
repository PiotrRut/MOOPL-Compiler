package staticanalysis;

/**
 * Exception thrown to report a while-loop black hole during use-def checking.
 */
public class BlackHoleException extends StaticAnalysisException {

    /**
     * Creates a new instance of <code>BlackHoleException</code> without detail message.
     */
    public BlackHoleException() {
    }

    /**
     * Constructs an instance of <code>BlackHoleException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public BlackHoleException(String msg) {
        super(msg);
    }
    
}
