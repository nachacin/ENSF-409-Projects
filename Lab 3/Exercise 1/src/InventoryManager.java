import java.util.ArrayList;
import java.util.Scanner;

/**
 * Entry point of the application for the user.
 * In essence a utility class of with no instances. The {@code InventoryManager} 
 * class coordinates calls between the front end and back end elements of 
 * entire application. It includes methods for both inventory searches 
 * and execution of sales.
 * 
 * @author Nestor Chacin
 * @version 1.0
 * @since 2021 - 07 - 25
 */
public class InventoryManager {
    /**
     * An {@code ArrayList<Tool>} object that will contain every
     * {@code Tool} that is currently in the user's inventory 
     */
    private static ArrayList<Tool> inventory;
    /**
     * An {@code ArrayList<Supplier>} object that will contain every
     * {@code Supplier} with whom the user maintains correspondance
     * for purchasing purposes.
     */
    private static ArrayList<Supplier> suppliers;
    /**
     * A constant set to the desired target amount for item restocking.
     * When automatic orders to restock are generated, {@code RESTOCK_AMOUNT
     * - (current item stock)} is ordered.
     */
    private static final int RESTOCK_AMOUNT = 50;

    //Suppresses default constructor, ensuring non-instantiability.
    private InventoryManager() {
    }

    /**
     * The starting point of the entire application.
     * @param args are not used.
     */
    public static void main(String[] args) {
        inventoryInit();
        suppliersInit();
        Menu.runMenu();   
    }
    /**
     * Initializes static field {@code inventory} and assigns a 
     * valid {@code ArrayList<Tool>} with elements that correspond to 
     * the present state of the inventory.
     */
    public static void inventoryInit() {
        inventory = new ArrayList<Tool>();
        inventory = StartUp.getInventory();
    }
    /**
     * Initializes static field {@code suppliers} and assigns a 
     * valid {@code ArrayList<Supplier>} with elements that correspond to 
     * the present state of the inventory.
     */
    public static void suppliersInit() {
        suppliers = new ArrayList<Supplier>();
        suppliers = StartUp.getSuppliers();
    }

    /**
     * Executes an item sale through user provided input. User input is used
     * to retrieve the item from {@code inventory} and to specify the amount
     * of items being sold.
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
            int indexSupplier = supplierIdSearch(Integer.parseInt(inventory.get(indexFound).getSupplierID()));
            Order.placeOrder(inventory.get(indexFound).getToolName(),
                             suppliers.get(indexSupplier).getName(),
                             RESTOCK_AMOUNT - inventory.get(indexFound).getToolStock());
        }
    }
    
    /**
     * Searches {@code inventory} for a {@code Tool} item by name. The 
     * item name must be a perfect characater-by-character match but does
     * not need to match letter casing.
     * @param itemName the name used to search {@code inventory}
     * @return index of the {@code Tool} element within {@code inventory} with a
     * matching item name. Returns null if no matches are found.
     */
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

    /**
     * Searches {@code inventory} for a {@code Tool} item by tool ID. 
     * @param itemID number used to search for a matching tool ID
     * @return index of the {@code Tool} element within {@code inventory} with a
     * matching tool ID. Returns null if no matches are found.
     */
    public static Integer searchID(String itemID) {
        Integer index = null;
        int id = Integer.parseInt(itemID);

        for (int i = 0; i < inventory.size(); i++){
            if(id == (inventory.get(i).getID())) {
                index = i;
                break;
            }
        }
        return index;
    }
    /**
     * Searches {@code suppliers} for a {@code supplier} with a matching
     * supplier id.
     * @param supplierID number used to search for a matching supplier ID
     * @return index of the {@code supplier} element within {@code suppliers} 
     * with a matching supplier ID. Returns null if no matches are found.
     */
    public static int supplierIdSearch(int supplierID) {
        Integer index = null;
        for (int i = 0; i < suppliers.size(); i++){
            if(supplierID == (suppliers.get(i).getID())) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    /**
     * Prints out information belonging to a {@code Tool} element in
     * the {@code inventory} field. Assumes index parameter is a valid
     * index within the {@code inventory} ArrayList. Information provided
     * is contextually matched to name-known/id-unknown use case.
     * @param index the location of a desired {@code Tool} element within
     * {@code inventory}
     */
    public static void printSearchToolName(int index) {
        System.out.println("\nWe found " + inventory.get(index).getToolName() + " in our inventory!");
        System.out.println("Here are its details:\n" + "Tool ID: " + inventory.get(index).getID() + "\nStock: " + inventory.get(index).getToolStock()
                             + "\nPrice: " + inventory.get(index).getPrice());
    }
    /**
     * Prints out information belonging to a {@code Tool} element in
     * the {@code inventory} field. Assumes index parameter is a valid
     * index within the {@code inventory} ArrayList. Information provided
     * is contextually matched to name-unknown/id-known use case.
     * @param index the location of a desired {@code Tool} element within
     * {@code inventory}
     */
    public static void printSearchToolID(int index) {
        System.out.println("\nWe found " + inventory.get(index).getID() + " in our inventory!");
        System.out.println("Here are its details:\n" + "Tool Name: " + inventory.get(index).getToolName() + "\nStock: " + inventory.get(index).getToolStock()
                             + "\nPrice: " + inventory.get(index).getPrice());
    }

    /**
     * Prints out item quantity for a {@code Tool} element in the 
     * {@code inventory} field. Assumes index parameter is a valid
     * index within the {@code inventory} ArrayList.
     * @param index the location of a desired {@code Tool} element within
     * {@code inventory}
     */
    public static void printItemQuantity(int index) {
        System.out.println("We have " + inventory.get(index).getToolStock() + " units of " + inventory.get(index).getToolName());
    }

    /**
     * Prints out a table listing every {@code Tool} item in {@code inventory}
     * along with all relevant information carried by each instance of {@Tool}.
     * This includes ID, name, storck, price and corresponding supplier ID. 
     */
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
