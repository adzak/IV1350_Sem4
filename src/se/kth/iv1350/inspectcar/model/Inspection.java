package se.kth.iv1350.inspectcar.model;

import se.kth.iv1350.inspectcar.integration.CarDTO;

/**
 * Class Inspection represents an inspection of a vehicle. 
 */
public class Inspection 
{
    private CarDTO car;
    private boolean[] partResult;
    private String[] standardInspectionMoments;
    private String[] previouslyFailedInspectionMoments;

    /**
     * Create a new instance, representing an inspection of the specified vehicle.
     *
     * @param car The current vehicle that is inspected.
     */
    public Inspection(CarDTO car)
    {
        this.car = car;
        this.standardInspectionMoments = car.getStandardInspectionMoments();
        this.partResult = new boolean[standardInspectionMoments.length];
    }
  
    /**
     * GetStandardInspectionMoments is in charge of fetching inspection moments.
     *
     * @return Inspection moments for the vehicle.
     */
    public String[] getStandardInspectionMoments()
    {
  	return standardInspectionMoments;
    }
  	
     /**
     * This method updates an array, on a given position, with a specified result. 
     * 
     * @param partResultElement specified inspection result of a car part. 
     * @param currentInspectionPart specifies the position to be updated.
     */
    public void storeInspectionResult(boolean partResultElement, int currentInspectionPart)
    {
        partResult[currentInspectionPart] = partResultElement;
    }
  
    /**
     * CompileInspectionResult assembles the failed inspection moments for a specific car. 
     *
     * @return the failed inspection moments to be stored in the CarDTO.
     */
    public String[] compileInspectionResult()
    {	
        int FailedInspectionMoments = 0;
      
        for(int i = 0; i < partResult.length; i++)
        {
            if(partResult[i] == false)
                FailedInspectionMoments++;
        }
      
        String[] finalResult = new String[FailedInspectionMoments];
        int indexToUpdate = 0; 
        for(int i = 0; i < standardInspectionMoments.length; i++)
        {
            if(partResult[i] == false)
                finalResult[indexToUpdate++] = standardInspectionMoments[i];
        }
    	
        return finalResult;
    }
  }
