import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Order {
    private int orderID;
    private LocalDate date;
    private String supplier;

    ArrayList<Order> orderlist = new ArrayList<Order>();
    

    /**
     * Create Order ID, 5-digit ID
     * Find LocalDate
     * 
     * @param toolArray
     */
    public void placeOrder(ArrayList<Tool> toolArray, int index, int ordered) {
        orderID = createID(); 
        date = LocalDate.now();
        
        
        
        
    }

    public int createID(){
        Random rand = new Random();
        return 10000 + rand.nextInt(100000);
    }

}
