public class Bicycle implements Vehicle {

    private String vehicleType;

    Bicycle(String vType) {
        vehicleType = vType;
    }

    @Override
    public String getVehicleType() {
        // TODO Auto-generated method stub
        return vehicleType;
    }
    
}
