import java.util.ArrayList;
/**
 * Instances of this class store several fields of information relevant
 * to a particular supplier in present in {@code suppliers} within the
 * {@code InventoryManager} class.
 * @author Nestor Chacin
 * @version 1.0
 * @since 2020 - 07 - 25
 */
public class Supplier {
    private int id;
    private String address;
    private String companyname;
    private String salescontact;
    /**
     * Constructs an instance of {@code Supplier}
     * @param aId Supplier ID
     * @param aCompanyName Company name
     * @param anAddress Company's address
     * @param aSalesContact User's Sales Contact
     */
    public Supplier(int aId, String aCompanyName,String  anAddress,String aSalesContact){
        this.id = aId;
        this.address = anAddress;
        this.companyname = aCompanyName;
        this.salescontact = aSalesContact;
    }
    /**
     * Retrieves the name of the company associated to a {@code Supplier}
     * @return a String "company name"
     */
    public String getName() {
        return this.companyname;
    }
    /**
     * Retrieves the ID of the company associated to a {@code Supplier}
     * @return Supplier ID
     */
    public int getID() {
        return this.id;
    }
    /**
     * Overrides default {@code toString()} method.
     * @return a String containing the state of each field for a given instance
     */
    public String toString(){
        String str = String.valueOf(this.id) + " " + this.address + " " + this.companyname + " " + this.salescontact;
        return str;
    }
    /**
     * Outter call in nested {@code toString()} calls. If given a valid
     * {@code ArrayList<Supplier>} object, it will call the {@code toString()} 
     * method for each {@code Supplier} element in the array.
     * @param supplierArray Contains {@code Supplier} instances
     * @return A list of Strings, each string corresponds to a returned
     * {@code toString()} of a {@code Supplier} instance.
     */
    public String toString(ArrayList<Supplier> supplierArray){
        String list = supplierArray.toString();
        return list;
    }

    



}
