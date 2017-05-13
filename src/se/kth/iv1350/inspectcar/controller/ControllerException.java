package se.kth.iv1350.inspectcar.controller;

import se.kth.iv1350.inspectcar.util.logger.Logger;
import java.io.FileNotFoundException;
/**
 * 
 * 
 */
public class ControllerException extends Exception
{
    private String invalidRegNo;
    
    public ControllerException(String regNo)
    {
        super("There are no inspections for the entered license number: " + regNo);
    }
    
    public String getInvalidRegNo()
    {
        return invalidRegNo;
    }
}
