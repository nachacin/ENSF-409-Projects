import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManager {

    // fields

        public static void main(String[] args) throws Exception {
        String selection;
        String query;

        
        
        // Creation of ArrayList of Tools and Suppliers
        File toolsFile = new File("C:\\Users\\nesto\\Desktop\\ENSF409\\Lab 3\\Exercise 1\\database\\items.txt");
        BufferedReader br = new BufferedReader(new FileReader(toolsFile));

        String line;
        String[] fields;
        var inventory = new ArrayList<Tool>();
        while ((line = br.readLine()) != null) {
            fields = line.split(";");
            var aTool = new Tool(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]),
                                 Double.parseDouble(fields[3]), fields[4]);
            inventory.add(aTool);
        }
        
        System.out.println(inventory.get(2));

        //System.out.println(inventory);

        File supplierFile = new File("C:\\Users\\nesto\\Desktop\\ENSF409\\Lab 3\\Exercise 1\\database\\suppliers.txt");
        BufferedReader sr = new BufferedReader(new FileReader(supplierFile));

        String supline;
        String[] supfields;
        var suppliers = new ArrayList<Supplier>();
        while ((supline = sr.readLine()) != null) {
            supfields = supline.split(";");
            var aSupplier = new Supplier(Integer.parseInt(supfields[0]), supfields[1], supfields[2], 
                                         supfields[3]);
            suppliers.add(aSupplier);
        }

        System.out.println("\n");

        Menu.runMenu();

        System.out.println(suppliers.get(2));
        //System.out.println(suppliers);

        
        
        //mini menu
        /**
        System.out.println("Press the corresponding number to select a service:\n"
                         + "1 - Search inventory item by name\n"
                         + "2 - Search inventory item by id\n"
                         + "3 - Add/Remove a tool from the inventory\n");
        var scanner = new Scanner(System.in);
        selection = scanner.nextLine();
        
        // insert code to call appropriate procedure base on selection
        
        
         // insert code to get value for query
        System.out.println("Please enter a name: ");
        query = scanner.nextLine();
        Tool.searchName(query, scanner);
        scanner.close();
         */
    }

    public static int menu() {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from the following choices:");
        System.out.println("1 - List all tools");
        System.out.println("2 - Inventory search by item name");
        System.out.println("3 - Inventory search by item ID");
        System.out.println("4 - Check item quantity");
        System.out.println("5 - Decrease item quantity");
        System.out.println("0 - Quit");

        selection = input.nextInt();
        return selection;
    }
}
