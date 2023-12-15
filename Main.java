import java.util.Scanner;
import java.util.ArrayList;

/*
 * Main class, contains the main method which is executed by running the program
 */
public class Main {
    //Class variables:
    ArrayList<String> commands = new ArrayList<String>();

    /*
     * The main method
     */
    public static void main(String[] args) {
        
        Main main = new Main();

        main.commands.add("help");
        main.commands.add("quit");
        main.commands.add("Tischgruppe");
        main.clui();
    }
    
    /*
     * the command line user interface executes commands based on the user input.
     */
    public void clui(){

        String[] command = {"h", "none"};
        Scanner input = new Scanner(System.in);
        help();

        while (!command[0].equals("q")) {

            System.out.print(">> ");
            String[] optionStringstmp = input.nextLine().toLowerCase().split(" ");
            if(optionStringstmp.length < 2){
                String[] x = {optionStringstmp[0], "none"}; // used help variable x, because curly brackets are only allowed on array initialisations.
                command = x;
            }
            else{
                command = optionStringstmp;
            }



            switch (command[0]) {
                case "?":
                case "help":
                case "h":
                    help();
                    break;

                case "exit":
                case "quit":
                    command[0] = "q";
                    break;
                
                case "tg":
                case "tischgruppe":
                    try {
                        new Tischgruppe(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    } catch (Exception e) {
                       System.out.println("Please type in 'tg', followed by the xPoition and the yPosition, seperated by a ' '.");
                    }
                    
                    break;
        
                case "":
                    break;

                default:
                    System.out.println("The input could not be processed.");
            }
        }

        input.close();
    }

    /*
     * help method, out prints all available commands
     */
    public void help(){

        System.out.println("List of available commands:");
        for (String command : commands) {
            System.out.println(command);
            
        }
    }
}


