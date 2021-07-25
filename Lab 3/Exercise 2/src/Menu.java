import java.util.Scanner;


public class Menu {
    // Exit is a boolean used to exit the program.
    private static boolean exit;
    // Declares the catalogue of courses in the database.
    private static CourseCatalogue catalogue;
    // Kb is used to take in user input Strings.
    private static Scanner kb;
    // Stores the student name of the user.
    private static String studentname;
    //Stores the student ID of the user.
    private static int studentid;
    //Declared to gain access of the Student class using searchDBStudent.
    private static DBManager dbmanager;
    // Initalized privately to register and remove registrations of a student in a course (In cases 2 and 3).
    private static Registration regStudent = new Registration();

    public static void setDBManager(DBManager dbManager){
        dbmanager = dbManager;
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
        System.out.println("6 - View all students taking a course");
        System.out.println("0 - Quit\n");
    }

    private static int getInput() {
        int choice = -1;

        while(choice < 0 || choice > 6) {
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
                if(dbmanager.searchDBstudent(studentname, studentid).getScheduleSize() < 6){
                    System.out.println("What is name of the course you wish to enroll into?");
                    name = kb.nextLine();
                    System.out.println("What is the number of the course you wish to enroll into?");
                    num = Integer.parseInt(kb.nextLine());
                    var cOffering = catalogue.searchCat(name,num).getCourseOfferingAt(0);
                    regStudent.completeRegistration(dbmanager.searchDBstudent(studentname,studentid), cOffering);
                    dbmanager.searchDBstudent(studentname, studentid).addToSchedule(regStudent);
                    cOffering.addToStudentEnrollment(regStudent);
                } else {
                    System.out.println("You have reached the maximum amount of courses you can enroll in.");
                }
                
                break;

            case 3:
                //Remove course from student courses
                System.out.println("What is the name of the course you wish drop?");
                name = kb.nextLine();
                System.out.println("What is the number of the course you wish to drop?");
                num = Integer.parseInt(kb.nextLine());
                var courseOffering = catalogue.searchCat(name,num).getCourseOfferingAt(0);
                dbmanager.searchDBstudent(studentname, studentid).getStuOffering(catalogue.searchCat(name, num), regStudent);
                courseOffering.removeReg(dbmanager.searchDBstudent(studentname, studentid), regStudent);
                break;

            case 4:
                //View all courses in catalogue
                System.out.println(catalogue + "\n\n");
                break;


            case 5:
                //View all courses taken by student
                dbmanager.searchDBstudent(studentname, studentid).getSchedule();
                break;

            case 6:
                System.out.println("Which course name would you like to creep?");
                name = kb.nextLine();
                System.out.println("Which course number would you like to creep?");
                num = Integer.parseInt(kb.nextLine());
                System.out.println("Which course section do you want to look at?");
                int sec = Integer.parseInt(kb.nextLine());
                System.out.println(catalogue.searchCat(name,num).getCourseOfferingAt(sec - 1));
                break;

            default:
                break;
        }
    }
}
