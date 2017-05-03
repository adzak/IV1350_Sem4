package se.kth.iv1350.inspectcar.integration;

 /**
  * This class is an interface to the control system opening the door
  * and also to the queue number display.
  */
public class Garage        
{
  private static final int MAX_DISPLAY_DIGITS = 1000;  
  private boolean garageDoorOpened;
  private int displayNumber; 
 
  /**
   * Creates a new instance of Garage.
   */
  public Garage()
  {
    garageDoorOpened = false;
    displayNumber = 0;
  }
  /**
   * nextCustomer displays next customer's queue number on display outside garage
   * and opens garage door. 
   */
  public void nextCustomer()
  {
     garageDoorOpened = true;
     
     if(displayNumber == MAX_DISPLAY_DIGITS)
         displayNumber = 0;  
     
     System.out.println("Garage door opening...standby");
     System.out.println("Next customer is: " + displayNumber);
     
     displayNumber++;
  }
  
  /**
   * getDisplayNumber 
   * 
   * @return the current displaynumber.
   */
  public int getDisplayNumber()
  {
    if(displayNumber == MAX_DISPLAY_DIGITS)
        displayNumber = 0;  
      
    return displayNumber;
  }
  
  /**
   * closeDoor closes the garage door. 
   */
  public void closeDoor()
  {
    garageDoorOpened = false;
    System.out.println("Garage door is closing...");
  } 
}
