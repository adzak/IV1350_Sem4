package se.kth.iv1350.inspectcar.integration;

import se.kth.iv1350.inspectcar.util.logger.Logger;
import java.io.*; 

/**
 * This class is used for fetching an inspection of a specific car.
 */
public class CarRegistry 
{
    private boolean carRegistryOnline;
    private static final String[] validRegNoList = {"ABC123","DEF456", "GHI789", "PALMIS"};
    private Logger fileLogger;
    
    /**
     * Creates a new instance representing a car registry system.
     * 
     */
    public CarRegistry()
    {
        carRegistryOnline = true;
        try
        {
            fileLogger = new Logger();
        }
        
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * The method findInspection is used to get information about the inspection. 
     * 
     * @param regNo Registration number of the car to be inspected
     * @return car contains the necessary information to make cost calculations for the inspection and tells what inspections to be made.
     * @throws CarRegistryException if there are no inspection for the entered registration number.
     */
    public CarDTO findInspection(String regNo) throws CarRegistryException
    {
        int foundLicenseNumber = 0;
        for(int i = 0; i < validRegNoList.length; i++)
        {
            if(regNo.equals(validRegNoList[i]))
                foundLicenseNumber++;
        }
        
        if(foundLicenseNumber == 0)
            throw new CarRegistryException("Invalid license number.");
        
        CarDTO car = new CarDTO(regNo);
      
        return car;
    }
}
