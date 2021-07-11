public class Zip extends ServiceCommunicator{
    /*
         Zip - contacts Zipcode server and returns zipcode information.
    */
    public Zip (String zipcode) {
        super("http://api.zippopotam.us/us/" + zipcode);
    }

    /*
        Main method - just tests this class in isolation.  Normally you would have another class call iTunesTool
    */
        public static void main(String[] argv) {
            System.out.println(new Zip("10011").get());
            System.out.println(new Zip("92024").get());
        }
}
