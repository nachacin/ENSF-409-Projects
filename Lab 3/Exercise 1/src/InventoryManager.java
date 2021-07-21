import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {
    private static ArrayList<Tool> inventory;
    private static ArrayList<Supplier> supplier;

    // fields

    public static void main(String[] args) throws Exception {
        var inventory = new ArrayList<Tool>();
        inventory = StartUp.getInventory();
        var suppliers = new ArrayList<Supplier>();
        suppliers = StartUp.getSuppliers();

        // Testing ArrayList<Tool> object
        System.out.println("\n|-- Testing ArrayList<Tool> object --|");
        System.out.println(inventory.get(2));
        // Testing decreaseItem() on ArrayList<Tool> object
        System.out.println("\n|-- Testing decreaseItem() on ArrayList<Tool> object --|");
        inventory.get(2).decreaseItem(2);
        System.out.println(inventory.get(2));
        // Testing ArrayList<Supplier> object
        System.out.println("\n|-- Testing ArrayList<Supplier> object --|");
        System.out.println(suppliers.get(2));

        

        Menu.runMenu();
        //System.out.println(suppliers);       
    }

    /**
     * Ask the user for item name
     * Ask the user how many sold
     * perform search to get an index
     * call inventory.get(index).decreaseItem(itemsSold)
     * if new stock is < 40, call Order to make order.
     */
    public static void itemSale() {
        String itemName;
        Integer amountSold;
        Integer indexOf;

        System.out.println("Provide item name:");
        Scanner in = new Scanner(System.in);
        itemName = in.nextLine();
        System.out.println("Provide how many items sold:");
        amountSold = Integer.parseInt(in.nextLine());

        indexOf = searchName(itemName);

        inventory.get(indexOf).decreaseItem(amountSold);

        Order.placeOrder(inventory, indexOf, amountSold);
    }
    
    public static Integer searchName(String itemName) {
        Integer index = null;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getToolName() == itemName) {
                index = i;
            }
        }
        return index;
    }
}
