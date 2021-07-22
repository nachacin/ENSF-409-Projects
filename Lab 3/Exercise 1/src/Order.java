import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Random;

/**
 * This class serves to generate orders and print them to a file. Much of this code,
 * particularly the methods related to file opening and writing, is based on snippets
 * from W3Schools (Specifically: https://www.w3schools.com/java/java_files_create.asp)
 */
public class Order {
    private static int ordersMade = 0;
    private static File ordersFile;
    
    public static void placeOrder(String aToolName, String aSupplierName, int anAmaunt) {
        if (ordersMade == 0) {
          ordersFile = createOrdersFile();
          addHeader();
          addOrder(aToolName, aSupplierName, anAmaunt);
        } else {
          addOrder(aToolName, aSupplierName, anAmaunt);
        } 
    }

    public static String createID(){
        Random rand = new Random();
        return Integer.toString(10000 + rand.nextInt(100000));
    }
    
    private static File createOrdersFile() {
        File pastFile = new File("database\\orders.txt");
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
          newOrdersFile = new File("database\\orders.txt");
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
        ordersMade++;
      } catch (IOException e) {
        System.out.println("Error! unable to write to orders.txt");
        e.printStackTrace();
      }
    }
  }