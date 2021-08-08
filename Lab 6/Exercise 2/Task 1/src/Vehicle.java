/**
 * We remove abstract method getEngineType() since not all vehicles have engines
 * <p>
 * We also change method name getVehicleType to getVehicleType to getModel since
 * including "Vehicle" in the name is redundant (it is already a Vehicle method).
 * Type is switched to Model to avoid confusing concepts Object Type and Data
 * Type
 */
abstract public class Vehicle {
    abstract public String getModel();    
}
