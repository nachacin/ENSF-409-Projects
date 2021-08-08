/**
 * Changed all variable names to be more expressive
 * <p>
 * Constructor uses an explicit "this." to the instance their creating
 * <p>
 * getEngineModel is included here instead of in the abstract Vehicle class
 * since not all vehicles have engines. But cars do.
 */
public class Car extends Vehicle{
    private String model;
    private String engineModel;

    Car(String aModel, String anEngineModel) {
        this.model = aModel;
        this.engineModel = anEngineModel;
    }

    @Override
    public String getModel(){
        return model;
    }
    public String getEngineModel() {
        return engineModel;
    }


}
