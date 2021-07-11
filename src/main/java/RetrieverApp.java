import java.util.Scanner;

/*
    RetrieverApp - simple app to retrieve web information based on user input from the console
 */
public class RetrieverApp {

    public static void main(String[] args) {
        RetrieverApp rp = new RetrieverApp();
        ServiceCommunicator mysc;

        while (true) {
            mysc = rp.processInput(rp);

            if (mysc == (ServiceCommunicator) null)             // If any problems with processInput(), just skip for now
                continue;

            String results = mysc.get();
            System.out.println( Utility.showJSON(results) );    // or System.out.println(Utility.showJSON(sc.get()));
        }
    }

    /*
      processInput() - handles all the user input and returns a ServiceCommunicator.
                        Potentially can return a null ServiceCommunicator, so be careful
     */
    public ServiceCommunicator processInput(RetrieverApp rapp) {
        String command;         // "music", "zipcode", "television"
        String subcommand;      // specific request to a particular ServiceCommunicator

        ServiceCommunicator sc = (ServiceCommunicator) null;

        System.out.print("Cmd> ");
        command = rapp.getUserInput();

        if (rapp.validateInput(command)) {
            System.out.print("Argument> ");
            switch (command) {
                case "zipcode":
                    subcommand = rapp.getUserInput();
                    sc = new Zip(subcommand);
                    break;
                case "music":
                    subcommand = rapp.getUserInput();
                    sc = new iTunes(subcommand);
                    break;
                case "television":
                    subcommand = rapp.getUserInput();
                    sc = new Tv(subcommand);
                    break;
            }

        } else {
            System.out.println("I'm sorry.  [" + command + "] is an invalid service.");
            return (ServiceCommunicator) null;
        }
        return sc;
    }

    /*
      getUserInput() - get a String token from the user
     */
    public String getUserInput() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    /*
      validateInput() - make sure only valid commands are used
     */
    public boolean validateInput(String input) {
        String[] services = {"zipcode", "music", "television"};

        for (int i = 0; i < services.length; i++) {
            if (services[i].equals(input))
                return true;
        }
        return false;
    }
}
