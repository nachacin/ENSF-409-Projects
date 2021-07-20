/**  
public class Inventory {
    private static File itemFile;

    public Inventory(File aItemFile) {
        itemFile = aItemFile;
        // insert constructor here
    }

    public static searchName(String name, Scanner scanner) {
        while (scanner.hasNextLine()) {
            final String lineFromFile = scanner.nextLine();
            if(lineFromFile.contains(name)) { 
                // a match!
                System.out.println("I found " +name+ " in file " +file.getName());
                break;
            }
         }
    }

}
*/