package se.kth.iv1350.inspectcar.integration;

/**
 * 
 * Thrown when an illegal registration number is given. 
 */
public class CarRegistryException extends Exception
{
    /**
     * Creates a new instance with a message specyfing that there were no
     * inspections to be found.
     * 
     * @param errorMessage a message that describe what went wrong.
     */
    public CarRegistryException(String errorMessage)
    {
        super(errorMessage);
    }
}
