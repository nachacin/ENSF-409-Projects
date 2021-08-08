package src3;
public class Car implements Engine {
    private String vehicleType;
    private String engineType;

    Car(String vType, String eType) {
        vehicleType = vType;
        engineType = eType;
    }

    /**
     * I moved this into Car.java and removed it from the abstract class Vehicle.java due to it being more focused on the Car class, rather than both Car and Bicycle.
     * @return Returns a String that contains the engineType requested.
     */
    @Override
    public String getEngineType() {
        return engineType;
    }

    @Override
    public String getVehicleType() {
        // TODO Auto-generated method stub
        return vehicleType;
    }

}
