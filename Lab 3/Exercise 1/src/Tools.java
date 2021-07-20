public class Tools {
    private int id;
    private String toolname;
    private int stock;
    private double price;
    private String supplierID;

    public Tools(int anId, String aToolName, int aStock, double aPrice, String aSupplierID) {
        this.id = anId;
        this.toolname = aToolName;
        this.stock = aStock;
        this.price = aPrice;
        this.supplierID = aSupplierID;
    }

    public searchName(String name, List array) {
        for (Tools e : array){
            if(e.toolname == name) {
                return e.toString();
            }
            break;
        }
    }

    public toString() {
        // insert here
    }
}
