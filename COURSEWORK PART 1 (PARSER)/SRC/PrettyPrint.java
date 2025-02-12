import pretty.PrettyPrinter;

/**
 * A harness to test that the abstract syntax tree is being built correctly.
 * The main method pretty-prints the AST to standard out.
 */
public class PrettyPrint {

    public static void main(String[] args) {
        MooplParser parser;
        try {
            if (args.length < 1) {
                throw new Error("The pretty-printer needs the name of the file to be pretty printed!");
            } else {
                // Read source code to be parsed from file
                try {
                    parser = new MooplParser(new java.io.FileInputStream(args[0]));
                } catch (java.io.FileNotFoundException e) {
                    System.err.println("Unable to read file " + args[0]);
                    return;
                }
            }
            parser.nt_Program().accept(new PrettyPrinter());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
