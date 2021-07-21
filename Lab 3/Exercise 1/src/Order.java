import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Order {
    private static int orderID;
    private static LocalDate date;
    private String supplier;

    ArrayList<Order> orderlist = new ArrayList<Order>();
    

    /**
     * Create Order ID, 5-digit ID
     * Find LocalDate
     * 
     * @param toolArray
     */
    public static void placeOrder(ArrayList<Tool> toolArray, int index, int ordered) {
        orderID = createID(); 
        date = LocalDate.now();
        
        
        
        
    }

    public static int createID(){
        Random rand = new Random();
        return 10000 + rand.nextInt(100000);
    }

}
