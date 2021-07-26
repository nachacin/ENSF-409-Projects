/**
 * Instances of this class store several fields of information relevant
 * to a particular item in present in the {@code inventory} within the
 * {@code InventoryManager} class.
 * @author Nasih Nazeem
 * @version 1.0
 * @since 2020 - 07 - 25
 */
public class Tool {
    private int id;
    private String toolName;
    private int stock;
    private double price;
    private String supplierID;

    /**
     * Constructs an instance of {@code Tool}.
     * @param anId Tool's ID
     * @param aToolName Tool's name
     * @param aStock Tool's stock level
     * @param aPrice Tool's price
     * @param aSupplierID Tool's corresponding supplier ID
     */
    public Tool(int anId, String aToolName, int aStock, double aPrice, String aSupplierID) {
        this.id = anId;
        this.toolName = aToolName;
        this.stock = aStock;
        this.price = aPrice;
        this.supplierID = aSupplierID;
    }
    /**
     * Overrides default {@code toString()} method.
     * @return a String containing the state of each field for a given instance
     */
    public String toString() {
        String str = String.valueOf(this.id) + " " + this.toolName + " " + this.stock + " " + this.price + " " + this.supplierID;
        return str;
    }
    /**
     * Records a sale by decreasing the stock field for a given instance by a
     * specified amount of units sold.
     * @param itemsSold specified amount of units sold.
     */
    public void decreaseItem(int itemsSold) {
        this.stock -= itemsSold;
    }
    /**
     * Retrieves the toolName field for a given instance.
     * @return The tool's name.
     */
    public String getToolName() {
        return this.toolName;
    }
    /**
     * Retrieves the stock level for a given instance
     * @return Stock level
     */
    public int getToolStock() {
        return this.stock;
    }
    /**
     * Retrieves the ID for a given instance.
     * @return The tool's ID
     */
    public int getID() {
        return this.id;
    }
    /**
     * Retrieves the price for a given instance.
     * @return Price
     */
    public double getPrice() {
        return this.price;
    }
    /**
     * Retrives corresponding supplier ID for a given instance.
     * @return Supplier ID
     */
    public String getSupplierID() {
        return this.supplierID;
    }
}
