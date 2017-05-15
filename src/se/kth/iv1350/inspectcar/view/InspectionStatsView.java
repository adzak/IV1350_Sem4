package se.kth.iv1350.inspectcar.view;

import se.kth.iv1350.inspectcar.model.InspectionObserver;

/**
 * Shows a running total of failed and passed inspection results. 
 */
public class InspectionStatsView implements InspectionObserver
{   
    private int totalFailed;
    private int totalPassed;

    /**
     * Creates an new instance of all counters of passed and failed inspections set to zero.
     */
    public InspectionStatsView()
    {
        totalFailed = 0;
        totalPassed = 0;
    }
    
    /**
     * Updates the display showing the total amount of passed and failed inspections.
     *
     * @param failedInspectionMoments total amount of failed inspection moments for a vehicle.
     */
    @Override
    public void updateDisplay(int failedInspectionMoments)
    {
        totalFailed += failedInspectionMoments;
        totalPassed += (4 - failedInspectionMoments);
        printCurrentState();
    }

    
    private void printCurrentState()
    {
      	System.out.println("");
        System.out.println("--------------------------------------------");
        System.out.println("Total amount of failed inspections: " + totalFailed);
        System.out.println("Total amount of passed inspections: " + totalPassed);
        System.out.println("--------------------------------------------");
        System.out.println("");
    }
    
}
  
