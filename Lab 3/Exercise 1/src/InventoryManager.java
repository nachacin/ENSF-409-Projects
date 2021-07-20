public class InventoryManager {

    // fields

    public InventoryManager() {
        // constructor items
    }
    public static void main(String[] args) {
        String selection;
        String query;
        //mini menu

        System.out.println("Press the corresponding number to select a service:\n"
                         + "1 - Search inventory item by name");
        var scanner = new Scanner(System.in);
        selection = scanner.nextLine();
        /**
         * insert code to call appropriate procedure base on selection
         */
        /**
         * insert code to get value for query
         */
        System.out.println("Please enter a name: ");
        query = scanner.nextLine();
        Inventory.searchName(query, scanner);
        scanner.close();
    }
}
