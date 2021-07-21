import java.util.Scanner;

public class Menu {
    private static boolean exit;
    public static void main(String [] args) {
        Menu.runMenu();
    }

    public static void runMenu() {
        printHeader();
        while(!exit)
        {
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }

    private static void printHeader() {
        System.out.println("");
        System.out.println("+----------------------------------------------------------+");
        System.out.println("|                   Course Registration                    |");
        System.out.println("+----------------------------------------------------------+");
    }

    private static void printMenu(){
        System.out.println("\nChoose from the following choices:");
        System.out.println("1 - Search catalogue courses");
        System.out.println("2 - Add course to student courses");
        System.out.println("3 - Remove course from student courses");
        System.out.println("4 - View All courses in catalogue");
        System.out.println("5 - View all courses taken by student");
        System.out.println("0 - Quit\n");
    }

    private static int getInput() {
        int choice = -1;

        Scanner kb = new Scanner(System.in);
        while(choice < 0 || choice > 5) {
            try {
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(kb.nextLine());
            }   catch(NumberFormatException e) {
                System.out.println("Invalid Selection. Please try again.");
            }
        }
        return choice;
    }

    private static void performAction(int choice) {
        switch(choice) {
            case 0:

            case 1:

            case 2:

            case 3:

            case 4:

            case 5:

            default:
                break;
        }
    }
}
