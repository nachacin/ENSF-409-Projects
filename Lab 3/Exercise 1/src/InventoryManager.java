import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class InventoryManager {
    private static ArrayList<Tool> inventory;
    private static ArrayList<Supplier> supplier;
    // fields

    public static void main(String[] args) throws Exception {
        var inventory = new ArrayList<Tool>();
        inventory = StartUp.getInventory();
        var suppliers = new ArrayList<Supplier>();

        System.out.println(inventory.get(2));
        inventory.get(2).decreaseItem(2);
        System.out.println(inventory.get(2));

        //System.out.println(inventory);

        File supplierFile = new File("C:\\Users\\nesto\\Desktop\\ENSF409\\Lab 3\\Exercise 1\\database\\suppliers.txt");
        BufferedReader sr = new BufferedReader(new FileReader(supplierFile));

        String supline;
        String[] supfields;
        while ((supline = sr.readLine()) != null) {
            supfields = supline.split(";");
            var aSupplier = new Supplier(Integer.parseInt(supfields[0]), supfields[1], supfields[2], 
                                            supfields[3]);
            suppliers.add(aSupplier);
        }

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
        System.out.println("Provide item name:");
    } 
}
