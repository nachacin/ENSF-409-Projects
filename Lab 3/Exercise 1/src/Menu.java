import java.util.Scanner;

public class Menu {
    static boolean exit;
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runMenu();
    }

    public static void runMenu(){
        printHeader();
        while(!exit) {
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }
    
    private static void printHeader() {
        System.out.println("+-------------------------------------------+");
        System.out.println("|            Inventory Manager              |");
        System.out.println("+-------------------------------------------+");
    }

    private static void printMenu(){
        System.out.println("\nChoose from the following choices:");
        System.out.println("1 - List all tools");
        System.out.println("2 - Inventory search by item name");
        System.out.println("3 - Inventory search by item ID");
        System.out.println("4 - Check item quantity");
        System.out.println("5 - Decrease item quantity");
        System.out.println("0 - Quit\n");
    }

    private static int getInput() {
        int choice = -1;
        Scanner kb = new Scanner(System.in);
        while(choice < 0 || choice > 5) {
            try {
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(kb.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Selection. Please try again.");
            }
        }
        return choice;
    }
    private static void performAction(int choice) {
        switch (choice) {
            case 0:
                exit = true;
                System.out.println("Inventory Manager Terminated");
                break;
            case 1:

            case 5:
                InventoryManager.itemSale();
                
        
            default:
                break;
        }
    }
}
