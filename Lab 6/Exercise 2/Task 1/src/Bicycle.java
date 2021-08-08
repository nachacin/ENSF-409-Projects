/**
 * Changed all identifiers names to be more expressive
 * <p>
 * Constructor uses an explicit "this." to the instance their creating
 * <p>
 * Now that the abstract Vehicle class does not require us to define
 * getEngineType(), Byicycle only needs to define getModel().
 */
public class Bicycle extends Vehicle {

    private String model;

    Bicycle(String aModel) {
        this.model = aModel;
    }

    @Override
    public String getModel() {
        return model;
    }
    
}
