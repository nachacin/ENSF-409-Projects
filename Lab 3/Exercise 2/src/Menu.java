import java.util.Scanner;


public class Menu {
    private static boolean exit;
    private static CourseCatalogue catalogue;
    private static Scanner kb;
    private static String studentname;
    private static int studentid;
    private static DBManager dbmanager;
    private static CourseOffering courseoffering;
    private static Registration regStudent = new Registration();

    public static void setDBManager(DBManager dbManager){
        dbmanager = dbManager;
    }

    public static void setCourseOffering(CourseOffering theOffering){
        courseoffering = theOffering;
    }

    public static void runMenu(CourseCatalogue aCatalogue) {
        printHeader();
        catalogue = aCatalogue;
        kb = new Scanner(System.in);
        System.out.println("What is your full name?");
        studentname = kb.nextLine();
        System.out.println("What is your student number?");
        studentid = Integer.parseInt(kb.nextLine());
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
        String name;
        int num;

        switch(choice) {
            case 0:
                //Quit
                exit = true;
                System.out.println("Registration Application Terminated.");
                break;

            case 1:
                //Search catalogue courses
                System.out.println("What is the name of the course you are looking for?");
                name = kb.nextLine();
                System.out.println("What is the number of the course you are looking for?");
                num = Integer.parseInt(kb.nextLine());
                System.out.println(catalogue.searchCat(name, num));
                break;
                
            case 2:
                //Add course to student courses
                System.out.println("What is name of the course you wish to enroll into?");
                name = kb.nextLine();
                System.out.println("What is the number of the course you wish to enroll into?");
                num = Integer.parseInt(kb.nextLine());
                regStudent.completeRegistration(dbmanager.searchDBstudent(studentname,studentid), catalogue.searchCat(name,num).getCourseOfferingAt(0));
                //System.out.println(regStudent);
                dbmanager.searchDBstudent(studentname, studentid).addToSchedule(regStudent);
                courseoffering.addToStudentEnrollment(regStudent);
                break;

            case 3:
                //Remove course from student courses
                System.out.println("What is the name of the course you wish drop?");
                name = kb.nextLine();
                System.out.println("What is the number of the course you wish to drop?");
                num = Integer.parseInt(kb.nextLine());
                dbmanager.searchDBstudent(studentname, studentid).getStuOffering(catalogue.searchCat(name, num), regStudent);
                courseoffering.removeReg(dbmanager.searchDBstudent(studentname, studentid));
                break;

            case 4:
                //View all courses in catalogue


            case 5:
                //View all courses taken by student

            default:
                break;
        }
    }
}
