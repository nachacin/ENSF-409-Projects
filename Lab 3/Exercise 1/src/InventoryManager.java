import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {
    private static ArrayList<Tool> inventory;
    private static ArrayList<Supplier> suppliers;

    public static void main(String[] args) throws Exception {
        inventoryInit();
        suppliersInit();
        
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

    public static void inventoryInit() {
        inventory = new ArrayList<Tool>();
        inventory = StartUp.getInventory();
    }

    public static void suppliersInit() {
        suppliers = new ArrayList<Supplier>();
        suppliers = StartUp.getSuppliers();
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
        Integer indexFound;

        System.out.println("Provide item name:");
        Scanner kb = new Scanner(System.in);
        itemName = kb.nextLine();
        System.out.println("Provide how many items sold:");
        amountSold = Integer.parseInt(kb.nextLine());

        indexFound = searchName(itemName);

        inventory.get(indexFound).decreaseItem(amountSold);
        if (inventory.get(indexFound).getToolStock() < 40) {
            //Order.placeOrder(inventory, indexFound, amountSold);
        }
    }
    
    public static Integer searchName(String itemName) {
        Integer index = null;
        
        for (int i = 0; i < inventory.size(); i++) {
            if (itemName.equalsIgnoreCase(inventory.get(i).getToolName())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static Integer searchID(String itemName) {
        Integer index = null;

        for (int i = 0; i < inventory.size(); i++){
            if(Integer.parseInt(itemName) == (inventory.get(i).getID())){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void printSearchToolName(int index) {
        System.out.println("We found " + inventory.get(index).getToolName() + " in our inventory!");
        System.out.println("Here are its details:\n" + "Tool ID: " + inventory.get(index).getID() + "\nStock: " + inventory.get(index).getToolStock()
                             + "\nPrice: " + inventory.get(index).getPrice());
    }

    public static void printSearchToolID(int index) {
        System.out.println("We found " + inventory.get(index).getID() + " in our inventory!");
        System.out.println("Here are its details:\n" + "Tool Name: " + inventory.get(index).getToolName() + "\nStock: " + inventory.get(index).getToolStock()
                             + "\nPrice: " + inventory.get(index).getPrice());
    }

    public static void printItemQuantity(int index) {
        System.out.println("We have " + inventory.get(index).getToolStock() + " units of " + inventory.get(index).getToolName());
    }

    public static void printAllTools() {
        System.out.println("+----------------------------------------------------------------+\n");
        System.out.println(String.format("%-10s %-20s %-8s %-8s %-15s", "Tool ID", "Tool Name", "Stock", "Price", "SupplierID"));
        System.out.println("+----------------------------------------------------------------+\n");

        for(Tool str : inventory){
            System.out.format("%-10d %-20s %-8d %-8.2f %-15s", str.getID(), str.getToolName(), str.getToolStock(), str.getPrice(), str.getSupplierID());
            System.out.println();

        }

    }
}
