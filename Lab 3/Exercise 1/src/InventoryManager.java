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

        System.out.println(inventory.get(2));
        inventory.get(2).decreaseItem(2);
        System.out.println(inventory.get(2));

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
        String itemname;
        Integer itemsold;
        Integer indexOf;


        System.out.println("Provide item name:");
        Scanner in = new Scanner(System.in);
        itemname = in.nextLine();
        System.out.println("Provide how many items sold:");
        itemsold = Integer.parseInt(in.nextLine());
        

        indexOf = searchName(itemname);

        inventory.get(indexOf).decreaseItem(itemsold);


        Order.placeOrder(inventory, indexOf, itemsold);
        
    }

}
