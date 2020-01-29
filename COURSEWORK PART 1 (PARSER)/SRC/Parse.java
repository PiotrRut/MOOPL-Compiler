/**
 * A harness to test the Moopl parser.
 */
public class Parse {

    public static void main(String[] args) throws Throwable {
        MooplParser parser;
        try {
            if (args.length == 0) {
                // Read program to be parsed from standard input
                parser = new MooplParser(System.in);
            } else {
                // Read program to be parsed from file
                try {
                    parser = new MooplParser(new java.io.FileInputStream(args[0]));
                } catch (java.io.FileNotFoundException e) {
                    System.err.println("Unable to read file " + args[0]);
                    return;
                }
            }
            System.out.println("parsing...");
            parser.nt_Program();
            System.out.println("...parse completed.");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
