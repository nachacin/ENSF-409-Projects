import java.util.Scanner;

/**
 * The front end implementation for the application. Provides menu, selection, 
 * and basic user input functionality. Calls necessary functions to execute
 * user chosen tasks.
 * 
 * The definition of this class is heavily inspired by the "Menu" class written in
 * the "Basic Menu System in Java" YouTube video (https://youtu.be/25kUc_ammbw) by
 * channel "Intro to Computer Science"
 * 
 * @author Nestor Chacin
 * @author Nasih Nazeem
 * @version 1.0
 * @since 2021 - 07 -25
 */
public class Menu {
    /**
     * A state variable used to terminate the program upon being 
     * assigned {@code true}
     */
    private static boolean exit;
    /**
     * A variable allocated to hold arbitrary numbers that are often
     * retrieved through function calls
     */
    private static Integer indexOf;

    //Suppresses default constructor, ensuring non-instantiability.
    private Menu(){
    }

    /**
     * The only public method in {@code Menu}. Initializes menu
     * routine: Print menu, get input, do task, print menu, and so on.
     */
    public static void runMenu(){
        printHeader();
        while(!exit) {
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }
    
    /**
     * Prints a header to the terminal to mark the start of 
     * an session in the application.
     */
    private static void printHeader() {
        System.out.println("");
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                    Inventory Manager                     |");
        System.out.println("+----------------------------------------------------------+");
    }

    /**
     * Prints out all requests available to the user to the terminal.
     */
    private static void printMenu(){
        System.out.println("\nChoose from the following choices:");
        System.out.println("1 - List all tools");
        System.out.println("2 - Inventory search by item name");
        System.out.println("3 - Inventory search by item ID");
        System.out.println("4 - Check item quantity");
        System.out.println("5 - Decrease item quantity");
        System.out.println("0 - Quit\n");
    }
    /**
     * Obtains user selection from terminal input
     * @return the user's selection.
     */
    private static int getInput() {
        int selection = -1;
        Scanner kb = new Scanner(System.in);
        while(selection < 0 || selection > 5) {
            try {
                System.out.print("Enter your choice: ");
                selection = Integer.parseInt(kb.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Selection. Please try again.");
            }
        }
        return selection;
    }
    /**
     * Executes the a routine that corresponds with the user menu selection
     * @param choice holds the user selection.
     */
    private static void performAction(int choice) {
        switch (choice) {
            case 0:
                exit = true;
                System.out.println("Inventory Manager Terminated");
                break;

            case 1:
                InventoryManager.printAllTools();
                break;

            case 2:
                System.out.println("Please type the name of the tool you would like to search:");
                Scanner tn = new Scanner(System.in);
                indexOf = InventoryManager.searchName(tn.nextLine());
                if (indexOf != null) {
                    InventoryManager.printSearchToolName(indexOf);
                } else {
                    System.out.println("Could not find a tool with that name!");
                }
                break;

            case 3:
                System.out.println("Please type the ID of the tool you would like to search:");
                Scanner ti = new Scanner(System.in);
                indexOf = InventoryManager.searchID(ti.nextLine());
                if (indexOf != null) {
                    InventoryManager.printSearchToolID(indexOf);
                } else {
                    System.out.println("Could not find a tool with that ID!");
                }
                break;

            case 4: 
                System.out.println("Please provide the name of the tool to view it's quantity");
                Scanner iq = new Scanner(System.in);
                indexOf = InventoryManager.searchName(iq.nextLine());
                if (indexOf != null) {
                    InventoryManager.printItemQuantity(indexOf);
                } else {
                    System.out.println("Could not find a tool with that name!");
                }
                break;
                
            case 5:
                InventoryManager.itemSale();
                break;
                
            default:
                break;
        }
    }
}
