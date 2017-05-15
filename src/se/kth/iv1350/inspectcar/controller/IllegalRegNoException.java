package se.kth.iv1350.inspectcar.controller;

import se.kth.iv1350.inspectcar.util.logger.Logger;
import java.io.FileNotFoundException;
/**
 * Thrown when an illegial registration number is given. 
 */
public class IllegalRegNoException extends Exception
{
    private String invalidRegNo;
    
    /**
     * Creates a new instance with a message specyfing that there were no
     * inspections to be found.
     * 
     * @param regNo the registration number that with no inspections.
     */
    public IllegalRegNoException(String regNo)
    {
        super("There are no inspections for the entered license number: " + regNo);
    }
    
    /**
     * @return The registration number with no inspections.
     */
    public String getInvalidRegNo()
    {
        return invalidRegNo;
    }
}
