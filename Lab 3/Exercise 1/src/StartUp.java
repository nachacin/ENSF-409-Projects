import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads from text files in user-specified locations. Uses file contents to build
 * {@code ArrayList<Tool>} and {@code ArrayList<Supplier>} collections that are 
 * eventually returned to calling class.
 * 
 * {@code StartUp} is functions as a utility class and cannot be instantiated
 * 
 * @author Nasih Nazeem
 * @author Nestor Chacin
 * @version 1.0
 * @since 2021 - 07 - 25
 */
public class StartUp {
    private static BufferedReader br;

    //Suppresses default constructor, ensuring non-instantiability.
    private StartUp() {
    }
    /**
     * Builds an {@code ArrayList<Tool>} collection. One of two public methods in {@code StartUp}
     * 
     * @return {@code ArrayList<Tool>} collection
     */
    public static ArrayList<Tool> getInventory(){
        getToolsPathName();
        return fillTools();
    }
    /**
     * Gets user to input a pathname for a text file listing all tools in current inventory.
     * The text file must list tools in the format specified by client (Each line should read: 
     * Tool ID, Tool Name, Tool Quantity, Tool Price, Tool Supplier ID)
     */
    private static void getToolsPathName() {
        boolean fileFound = false;
        String pathName;
        Scanner kb = new Scanner(System.in);
        while(!fileFound) {
            try {
                System.out.println("Please enter the pathname of a .txt file containing the current itemized inventory.");
                System.out.print("\n");
                System.out.println("Example: .\\database\\items.txt (windows file path format)");
                System.out.println("Example: ./database/items.txt (unix-based file path format)");
                System.out.print("\n");
                pathName = kb.nextLine();
                File itemsFile = new File(pathName);
                br = new BufferedReader(new FileReader(itemsFile));
                fileFound = true;
            } catch (FileNotFoundException e) {
                System.out.println("That filename does not exist. Try Again!");
            } catch (Exception e) {
                System.err.println("Unknown error. Try Again?");
            }
        }
    }
    /**
     * Builds an {@code ArrayList<Tool>} collection by reading a text file through
     * a pre-initialized BufferedReader.
     * @return {@code ArrayList<Tool>} contaning all tools in text file as {@code Tool}
     * instances
     */
    private static ArrayList<Tool> fillTools() {
        ArrayList<Tool> toolList = new ArrayList<Tool>();
        String line;
        String[] fields;
        
        try {
            while ((line = br.readLine()) != null) {
                fields = line.split(";");
                var aTool = new Tool(Integer.parseInt(fields[0]), fields[1], Integer.parseInt(fields[2]),
                                        Double.parseDouble(fields[3]), fields[4]);
                toolList.add(aTool);
            }
        } catch (NumberFormatException e) {
            System.out.println("Number formats in file are invalid");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("readLine() failed to read the file");
            e.printStackTrace();
        }
        return toolList;
    }
    /**
     * Builds an {@code ArrayList<Supplier>} collection. One of two public methods in {@code StartUp}
     * 
     * @return {@code ArrayList<Supplier>} collection
     */
    public static ArrayList<Supplier> getSuppliers(){
        getSuppliersFileName();
        return fillSuppliers();
    }
    /**
     * Gets user to input a pathname for a text file listing all current suppliers of stock.
     * The text file must list suppliers in the format specified by client (Each line should read: 
     * Supplier ID, Company Name, Address, Sales Contact Name)
     */
    private static void getSuppliersFileName() {
        boolean fileFound = false;
        String pathName;
        Scanner kb = new Scanner(System.in);
        while(!fileFound) {
            try {
                System.out.println("Please enter the pathname of a .txt file listing your current suppliers.");
                System.out.print("\n");
                System.out.println("Example: .\\database\\suppliers.txt (windows file path format)");
                System.out.println("Example: ./database/suppliers.txt (unix-based file path format)");
                System.out.print("\n");
                pathName = kb.nextLine();
                File suppliersFile = new File(pathName);
                br = new BufferedReader(new FileReader(suppliersFile));
                fileFound = true;
            } catch (FileNotFoundException e) {
                System.out.println("That filename does not exist. Try Again!");
            } catch (Exception e) {
                System.err.println("Unknown error. Try Again?");
            }
        }
    }
    /**
     * Builds an {@code ArrayList<Supplier>} collection by reading a text file through
     * a pre-initialized BufferedReader.
     * @return {@code ArrayList<Supplier>} contaning all suppliers in text file as {@code Supplier}
     * instances
     */
    private static ArrayList<Supplier> fillSuppliers() {
        ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
        String supLine;
        String[] supFields;
        
        try {
            while ((supLine = br.readLine()) != null) {
                supFields = supLine.split(";");
                var aSupplier = new Supplier(Integer.parseInt(supFields[0]), supFields[1], supFields[2], 
                                                supFields[3]);
                supplierList.add(aSupplier);
            }
        } catch (NumberFormatException e) {
            System.out.println("Number formats in file are invalid");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("readLine() failed to read the file");
            e.printStackTrace();
        }
        return supplierList;
    }
}
