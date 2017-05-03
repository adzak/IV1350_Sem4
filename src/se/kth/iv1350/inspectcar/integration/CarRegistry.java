package se.kth.iv1350.inspectcar.integration;

/**
 * This class is used for fetching an inspection of a specific car.
 */
public class CarRegistry 
{
    private boolean carRegistryOnline;
 
    /**
     * Creates a new instance representing a car registry system.
     * 
     */
    public CarRegistry()
    {
        carRegistryOnline = true;
    }

    /**
     * The method findInspection is used to get information about the inspection. 
     * @param regNo Registration number of the car to be inspected
     * @return car contains the necessary information to make cost calculations for the inspection and tells what inspections to be made.
     */
    public CarDTO findInspection(String regNo)
    {
        CarDTO car = new CarDTO(regNo);
      
        return car;
    }
}
