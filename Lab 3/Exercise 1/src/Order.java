import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Order {
    private static int ordersMade = 0;
    private static File ordersFile;
    
    /**
     * Create Order ID, 5-digit ID
     * Find LocalDate
     * 
     * @param toolArray
<<<<<<< HEAD
     */

=======
     
>>>>>>> refs/remotes/remrepo/main
    public static void placeOrder(ArrayList<Tool> toolArray, int index, int ordered) {
        if (ordersMade == 0) {
          ordersFile = createOrdersFile();
          addHeader();
        } else {
          addOrder();
        }
        
    }

    public static int createID(){
        Random rand = new Random();
        return 10000 + rand.nextInt(100000);
    }
<<<<<<< HEAD
    
    private static File createOrdersFile() {
        File pastFile = new File("database\\orders.txt");
        boolean fileDeleted;
=======
    /**
    private static void createOrdersFile() {
        File pastFile;
>>>>>>> refs/remotes/remrepo/main
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
    */

    private static void addHeader() {
      try {
        FileWriter writer = new FileWriter("database\\orders.txt");
        writer.write("**********************************************************************\n");
        writer.write("*                       Orders - " + LocalDate.now() + "             *\n");
        writer.write("**********************************************************************\n");
        writer.close();
        System.out.println("Header has been added to orders.txt");
      } catch (IOException e) {
        System.out.println("Error! unable to write to orders.txt");
        e.printStackTrace();
      }
    }
}
