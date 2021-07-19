public class Supplier {
    private int id;
    private String address;
    private String companyname;
    private String salescontact;
    private Order [] orders;

    Supplier(int ID, String address, String companyname, String salescontact)
    {
        this.ID = ID; this.address = address; this.companyname = companyname; this.salescontact = salescontact;
    }

    public int getID(){
        return id;
    }

    public String getaddress(){
        return address;
    }

    public String getcompanyname(){
        return companyname;
    }

    public String salescontact(){
        return salescontact;
    }

    public void newOrders(Order order, int ID)
    {
        
    }
}
