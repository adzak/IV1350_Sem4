package se.kth.iv1350.inspectcar.model;

import se.kth.iv1350.inspectcar.integration.CarDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Inspection represents an inspection of a vehicle. 
 */
public class Inspection 
{
    private CarDTO car;
    private boolean[] partResult;
    private String[] standardInspectionMoments;
    private String[] previouslyFailedInspectionMoments;
    private List<InspectionObserver> observers = new ArrayList<>();

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
        int failedInspectionMoments = 0;
      
        for(int i = 0; i < partResult.length; i++)
        {
            if(partResult[i] == false)
                failedInspectionMoments++;
        }
        
        notifyObservers(failedInspectionMoments);
        
        String[] finalResult = new String[failedInspectionMoments];
        int indexToUpdate = 0; 
        
        for(int i = 0; i < standardInspectionMoments.length; i++)
        {
            if(partResult[i] == false)
                finalResult[indexToUpdate++] = standardInspectionMoments[i];
        }
    	
        return finalResult;
    }

    /**
     * The specified observers will be notified when the number of failed inspection moments has been updated.
     *
     * @param observers the observers to notify.
     */
    public void addObserver(List<InspectionObserver> observer)
    {
        observers.addAll(observer);
    }
    
    private void notifyObservers(int failedInspectionMoments)
    {
        for(InspectionObserver obs : observers)
        {
            obs.updateDisplay(failedInspectionMoments);
        }
    }
  }
