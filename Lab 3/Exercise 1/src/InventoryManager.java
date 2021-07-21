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
            Order.placeOrder(inventory, indexFound, amountSold);
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
}
