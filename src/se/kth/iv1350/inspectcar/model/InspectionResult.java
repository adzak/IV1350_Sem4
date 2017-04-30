package se.kth.iv1350.inspectcar.model;

/**
 * This class represent the printout of the inspection result. 
 */
public class InspectionResult 
{
    private Inspection inspectionResult;
    
   /**
    * Creates an instance of InspectionResult to be printed. 
    * 
    * @param inspectionResult contains the necessary information to create a printout of.
    */
    public InspectionResult(Inspection inspectionResult)
    {
    	this.inspectionResult = inspectionResult;
    }
  
    /**
     * Method getInspectionResult is in charge of getting the inspection result.
     *
     * @return the inspection results needed for the printout. 
     */
    public Inspection getInspectionResult()
    {
      return inspectionResult;
    }
}
