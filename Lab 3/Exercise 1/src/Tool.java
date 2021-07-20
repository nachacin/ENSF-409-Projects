public class Tool {
    private int id;
    private String toolname;
    private int stock;
    private double price;
    private String supplierID;

    public Tool(int anId, String aToolName, int aStock, double aPrice, String aSupplierID) {
        this.id = anId;
        this.toolname = aToolName;
        this.stock = aStock;
        this.price = aPrice;
        this.supplierID = aSupplierID;
    }

    /**
    public searchName(String name, List array) {
        for (Tools e : array){
            if(e.toolname == name) {
                return e.toString();
            }
            break;
        }
    }
    */

    public String toString() {
        String str = String.valueOf(this.id) + " " + this.toolname;
        return str;
    }

    /**
    public toString(ArrayList toolArray) {
        // insert here
        element.toString()
    }
    */

}
