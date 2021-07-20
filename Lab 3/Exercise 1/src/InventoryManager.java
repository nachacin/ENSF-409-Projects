import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class InventoryManager {

    // fields

        public static void main(String[] args) throws Exception {
        String selection;
        String query;
        File toolsFile = new File("C:\\Users\\nesto\\Desktop\\ENSF409\\Lab 3\\Exercise 1\\database\\items.txt");
        BufferedReader br = new BufferedReader(new FileReader(toolsFile));

        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
        
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
