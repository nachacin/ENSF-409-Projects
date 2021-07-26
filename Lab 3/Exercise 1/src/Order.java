import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Random;

/**
 * Generates an order and prints it to a file named "orders.txt". 
 * Successive orders are appended to the file until the Application is closed.
 * <p>
 * ALERT - the file "orders.txt" will be created with a pathname "database\\orders.txt".
 * This uses windows based filepath format. We apologize if this creates difficulty
 * for non-windows users. Please edit the format of the String assigned to the 
 * constant {@code SET_PATHNAME} to match your system requirements.
 * <p>
 * {@code Order} is a utility class and cannot be instantiated.
 * <p>
 * Much of this code, particularly the methods related to file opening and writing, 
 * is based on snippets from W3Schools, namely:
 * <p>
 * https://www.w3schools.com/java/java_files_create.asp
 * 
 * @author Nestor Chacin
 * @author Nasih Nazeem
 * @version 1.0
 * @since 2021 - 07 - 25
 */
public class Order {
    /**
     * Counter variable for orders made in an application session.
     */
    private static int ordersMade = 0;
    /**
     * {@code File} object subsequently used for file writing purposes.
     */
    private static File ordersFile;
    /**
     * Constant for pathname
     */
    private static final String SET_PATHNAME = "database\\orders.txt";

    //Suppresses default constructor, ensuring non-instantiability.
    private Order() {
    }
    /**
     * Writes order to "orders.txt". If this is the first order made, "orders.txt" is
     * first created and then written to. Otherwise, an order is appended to "orders.txt"
     * @param aToolName Name of a tool being ordered
     * @param aSupplierName Name of a supplier being ordered from
     * @param anAmaunt The amount of tools being ordered
     */
    public static void placeOrder(String aToolName, String aSupplierName, int anAmaunt) {
        if (ordersMade == 0) {
            ordersFile = createOrdersFile();
            addHeader();
            addOrder(aToolName, aSupplierName, anAmaunt);
        } else {
            addOrder(aToolName, aSupplierName, anAmaunt);
        } 
    }
    /**
     * Creates a random 5 digit number
     * @return A random 5 - digit number
     */
    public static String createID(){
        Random rand = new Random();
        return Integer.toString(10000 + rand.nextInt(100000));
    }
    /**
     * Creates "orders.txt" file in directory specified in SET_PATHNAME.
     * If this method has already created an "orders.txt" in previous application 
     * sessions, it will be deleted prior to creating a new "orders.txt"
     * @return A {@code File} object constructed with pathname for "orders.txt"
     */
    private static File createOrdersFile() {
        File pastFile = new File(SET_PATHNAME);
        boolean fileDeleted;
        try {
            fileDeleted = Files.deleteIfExists(pastFile.toPath());
            if (fileDeleted) {
                System.out.println("\nALERT: an existing orders.txt was deleted");
            }
        } catch (IOException e) {
            System.err.println("Error! deleteIfExists() failed to delete a file");
            e.printStackTrace();
        }

        File newOrdersFile;
        try {
            newOrdersFile = new File(SET_PATHNAME);
            if (newOrdersFile.createNewFile()) {
                System.out.println("File created: " + newOrdersFile.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred. File orders.txt could not be created");
            e.printStackTrace();
            return null;
        }
        return newOrdersFile;
    }
    /**
     * Prints a header to "orders.txt"
     */
    private static void addHeader() {
        try {
            FileWriter writer = new FileWriter(ordersFile);
            writer.write("**********************************************************************\n");
            writer.write("*                         Orders - " + LocalDate.now() + "                        *\n");
            writer.write("**********************************************************************\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error! unable to write to orders.txt");
            e.printStackTrace();
        }
    }
    /**
     * Appends order to "orders.txt" in client-specified format.
     * @param toolName Name of tool being ordered
     * @param supplierName Name of supplier being ordered from
     * @param amaunt Amount of tools being ordered
     */
    private static void addOrder(String toolName, String supplierName, int amaunt) {
        try {
            FileWriter writer = new FileWriter(ordersFile, true);
            writer.write(String.format("%-25s %-55s\n", "ORDER ID:", createID()));
            writer.write(String.format("%-25s %-55s\n", "Date Ordered:", LocalDate.now()));
            writer.write("\n");
            writer.write(String.format("%-25s %-55s\n", "Item Description:", toolName));
            writer.write(String.format("%-25s %-55s\n", "Amount Ordered:", amaunt));
            writer.write(String.format("%-25s %-55s\n", "Supplier:", supplierName));
            writer.write("**********************************************************************\n");
            writer.close();
            System.out.println("Appended an order for " + toolName + " to order.txt");
            ordersMade++;
        } catch (IOException e) {
            System.out.println("Error! unable to write to orders.txt");
            e.printStackTrace();
        }
    }
}