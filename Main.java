import java.util.Scanner;
import java.util.ArrayList;

/*
 * Main class, contains the main method which is executed by running the program
 */
public class Main {
    //Class variables:
    ArrayList<String> commands = new ArrayList<String>();
    ArrayList<Stuhl> a1sArrayList = new ArrayList<Stuhl>();
    ArrayList<Tisch> a1tArrayList = new ArrayList<Tisch>();


    /*
     * The main method
     */
    public static void main(String[] args) {

        Main main = new Main();

        main.commands.add("help");
        main.commands.add("quit");
        main.commands.add("aufgabe1");
        //TODO: add new commands to the commands arraylist.

        main.clui();
    }
    
    /*
     * the command line user interface executes commands based on the user input.
     */
    public void clui(){

        String command = "";
        Scanner input = new Scanner(System.in);
        help();

        while (!command.equals("q")) {

            System.out.print(">> ");
            command = input.nextLine(); 

            switch (command) {
                case "?":
                case "help":
                case "h":
                    help();
                    break;

                case "q":
                case "exit":
                case "quit":
                    command = "q";
                    break;
                
                case "a1":
                case "aufgabe1":
                    a1();
                    break;
            
                case"command":
                    //TODO: implement commands
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
    /*
     * method for task 1, creates all needed furniture and puts it into the right place
     */
    public void a1(){

        // for loop that creates the Tisch objects and writes these into the a1t Arraylist and makes them visible
        for(int i = 0; i < 2; i++){

            a1tArrayList.add(new Tisch());
            a1tArrayList.get(i).zeige();
            System.out.println("Log: Tisch " + i + " erstellt.");
        }

        System.out.println("");

        // for loop that creates the Stuhl objects and writes these into the a1s Arraylist and makes them visible
        for(int i = 0; i < 8; i++){

            a1sArrayList.add(new Stuhl());
            a1sArrayList.get(i).zeige();
            System.out.println("Log: Stuhl " + i + " erstellt");
        }

        //TODO: position tables and chairs in right place and roatation

        //Platzierung der Tische und Stühle
        a1tArrayList.get(0).set_xPosition(120);
        a1tArrayList.get(0).set_yPosition(42);

        a1tArrayList.get(1).set_xPosition(200);
        a1tArrayList.get(1).set_yPosition(220);

        a1sArrayList.get(0).bewegeHorizontal(100);
    }


}


