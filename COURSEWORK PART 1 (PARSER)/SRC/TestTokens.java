
/**
 * A harness to test the Moopl token definitions.
 */
public class TestTokens {

    public static void main(String[] args) throws ParseException {
        MooplParser parser;
        try {
            parser = new MooplParser(new java.io.FileInputStream(args[0]));
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Unable to read file " + args[0]);
            return;
        }
        System.out.println("testing token definitions...");
        parser.testTokens();
        System.out.println("...test completed.");
    }
}
