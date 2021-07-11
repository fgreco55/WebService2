public class iTunes extends ServiceCommunicator{
    /*
         iTunes - contacts iTunes server and returns artist information.
    */
    public iTunes (String artist) {
        super("https://itunes.apple.com/search?term=" + artist + "\\&limit=1");
    }

    /*
        Main method - just tests this class in isolation.  Normally you would have another class call iTunesTool
    */
        public static void main(String[] argv) {
            System.out.println(new iTunes("beyonce").get());
            System.out.println(new iTunes("ladygaga").get());
        }
}
