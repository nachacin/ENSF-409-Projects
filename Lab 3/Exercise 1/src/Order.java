import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Order {
    private static int ordersMade = 0;

    ArrayList<Order> orderlist = new ArrayList<Order>();
    

    /**
     * Create Order ID, 5-digit ID
     * Find LocalDate
     * 
     * @param toolArray
     */
    public static void placeOrder(ArrayList<Tool> toolArray, int index, int ordered) {
        if (ordersMade == 0) {
            createOrdersFile();
        }
        orderID = createID(); 
        date = LocalDate.now();
    }

    public static int createID(){
        Random rand = new Random();
        return 10000 + rand.nextInt(100000);
    }
    
    private static void createOrdersFile() {
        File pastFile 
        try {
            File ordersFile = new File("orders.txt");
            if (ordersFile.createNewFile()) {
              System.out.println("File created: " + ordersFile.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred. File orders.txt could not be created");
            e.printStackTrace();
          }
    }

}
