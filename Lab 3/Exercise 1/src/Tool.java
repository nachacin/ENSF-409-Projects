import java.util.ArrayList;

public class Tool {
    private int id;
    private String toolName;
    private int stock;
    private double price;
    private String supplierID;

    public Tool(int anId, String aToolName, int aStock, double aPrice, String aSupplierID) {
        this.id = anId;
        this.toolName = aToolName;
        this.stock = aStock;
        this.price = aPrice;
        this.supplierID = aSupplierID;
    }

    public boolean lowStock(int quantity)
    {
        if(quantity < 40){

            System.out.println("This item is low in stock.");
            return true;
        }
        
        System.out.println("This item is in stock.");
        return false;
    }

    public String toString() {
        String str = String.valueOf(this.id) + " " + this.toolName + " " + this.stock + " " + this.price + " " + this.supplierID;
        return str;
    }

    
    public String toString(ArrayList<Tool> toolArray) {
        // insert here
        String list = toolArray.toString();
        return list;
    }

    public void decreaseItem(int itemsSold) {
        this.stock -= itemsSold;
    }

    public String getToolName() {
        return this.toolName;
    }
}
