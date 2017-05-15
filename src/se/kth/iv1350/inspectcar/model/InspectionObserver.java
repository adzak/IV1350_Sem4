package se.kth.iv1350.inspectcar.model;

/**
 * A listener interface for receiving notifications about vehicle inspection results. '
 */
public interface InspectionObserver 
{
    
  /**
   * Invoked when the total amount of inspection failures has been compiled.
   *
   * @param failedInspectionMoments total amount of failed inspection moments for a vehicle.
   */ 
  public void updateDisplay(int failedInspectionMoments);

}
