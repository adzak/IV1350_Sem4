package se.kth.iv1350.inspectcar.integration;

/**
 * This class represents the CarDTO which is used for inspection moments and its results.
 */
public class CarDTO 
{
    private String regNo;
    private String[] standardInspectionMoments = {"Power steering", "Tires", "Suspension", "Headlights"};
    private String[] previouslyFailedInspectionMoments; 
    
    /**
     * Create a new instance that include information about CarDTO.
     * @param regNo Registration number for specificed car.
     */           
    public CarDTO(String regNo)
    {
        this.regNo = regNo;
    }
    
    /**
     * The method getInspectionMoments is in charge of getting inspection moments.
     * @return Standard inspection moments that each car will have to go through is returned.
     */
    public String[] getStandardInspectionMoments()
    {
        return standardInspectionMoments;
    }

    /**
     * Method getRegNo is in charge of getting registration number of 
     * the inspected car.
     * 
     * @return Registration number of the inspected car.
     */ 
    public String getRegNo()
    {
    	return regNo;
    }
 
    /**
     * Method getPreviouslyFailedInspectionMoments is in charge of getting
     * previously failed inspection moments.
     *
     * @return Previously failed inspection moments is returned.
     */
    public String[] getPreviouslyFailedInspectionMoments()
    {
     	return previouslyFailedInspectionMoments;
    }
  	
    /**
     * The method updateInspectionMoments updates the list containing previously failed inspection moments, which 
     * will be reexamined on the next inspection.
     *
     * @param finalResult contains failed inspection moments.
     */
    public void updateInspectionMoments(String[] finalResult)
    {
     	previouslyFailedInspectionMoments = finalResult;
    }
}    

