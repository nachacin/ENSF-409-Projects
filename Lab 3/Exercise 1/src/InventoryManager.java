import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {
    private static ArrayList<Tool> inventory;
    private static ArrayList<Supplier> suppliers;
    private static final int RESTOCK_AMOUNT = 50;

    public static void main(String[] args) throws Exception {
        inventoryInit();
        suppliersInit();
        Menu.runMenu();   
    }

    public static void inventoryInit() {
        inventory = new ArrayList<Tool>();
        inventory = StartUp.getInventory();
    }

    public static void suppliersInit() {
        suppliers = new ArrayList<Supplier>();
        suppliers = StartUp.getSuppliers();
    }

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

    public static int supplierIdSearch(int Id) {
        Integer index = null;
        for (int i = 0; i < suppliers.size(); i++){
            if(Id == (suppliers.get(i).getID())) {
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
