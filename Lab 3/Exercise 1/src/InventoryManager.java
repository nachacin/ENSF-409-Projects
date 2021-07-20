import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class InventoryManager {

    // fields

        public static void main(String[] args) throws Exception {
        String selection;
        String query;
        File toolsFile = new File("H:\\Github\\NasihNazeem\\ENSF409\\Lab 3\\Exercise 1\\database\\items.txt");
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

        System.out.println(inventory);

        File supplierFile = new File("H:\\Github\\NasihNazeem\\ENSF409\\Lab 3\\Exercise 1\\database\\suppliers.txt");
        BufferedReader br = new BufferedReader(new FileReader(supplierFile));

        
        /**
        //mini menu

        System.out.println("Press the corresponding number to select a service:\n"
                         + "1 - Search inventory item by name");
        var scanner = new Scanner(System.in);
        selection = scanner.nextLine();
        
        // insert code to call appropriate procedure base on selection
        
        
         // insert code to get value for query
        System.out.println("Please enter a name: ");
        query = scanner.nextLine();
        Inventory.searchName(query, scanner);
        scanner.close();
        */
    }
}
