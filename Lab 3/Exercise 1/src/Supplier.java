import java.util.ArrayList;

public class Supplier {
    private int id;
    private String address;
    private String companyname;
    private String salescontact;


    public Supplier(int aId, String aCompanyName,String  anAddress,String aSalesContact){
        this.id = aId;
        this.address = anAddress;
        this.companyname = aCompanyName;
        this.salescontact = aSalesContact;
    }

    public String getName() {
        return this.companyname;
    }

    public int getID() {
        return this.id;
    }

    public String toString(){
        String str = String.valueOf(this.id) + " " + this.address + " " + this.companyname + " " + this.salescontact;
        return str;
    }

    public String toString(ArrayList<Supplier> supplierArray){
        String list = supplierArray.toString();
        return list;
    }

    



}
