package se.kth.iv1350.inspectcar.view;
        
import se.kth.iv1350.inspectcar.controller.Controller;
import se.kth.iv1350.inspectcar.model.Amount;
import se.kth.iv1350.inspectcar.controller.IllegalRegNoException;
import java.util.*;
import se.kth.iv1350.inspectcar.util.logger.Logger;
import java.io.*; 

/**
  * This class is a placeholder for the view.
  */
public class View 
{
    private Controller controller;
    private Logger fileLogger;
    
    /**
     * Creates a new instance that will use the specified controller for all system operations.
     * 
     * @param controller The controller to use for system operations.
     */  
    public View(Controller controller)
    {
        this.controller = controller;
        
        try
        {
           fileLogger = new Logger(); 
        }
        
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        
        controller.addInspectionObserver(new InspectionStatsView());
        
    }
    
    /**
     * Inspection displays inspection related operations.
     *
     * @param regNo defines a registration number of a given car.
     */    
    private void inspection(String regNo)
    {
        boolean pass = true;
        boolean fail = false;
       
        String[] inspectionParts = controller.fetchNextInspection(regNo);
        Scanner enterResult = new Scanner(System.in);
        System.out.println("Enter inspection result P/F, Pass/Fail: ");
       
        for(int i = 0; i < inspectionParts.length; i++)
        {
           System.out.println(inspectionParts[i]);
           String n = enterResult.nextLine();
           
           if (n.equals("P") || n.equals("Pass") || n.equals("F") || n.equals("Fail"))
           {
               if (n.equals("P") || n.equals("Pass"))
                    controller.enterInspectionResult(pass, i);
               
               else
                   controller.enterInspectionResult(fail, i);
           }
           
           else
               i--;
        }

        String[] finalResult = controller.finalizeInspection();
      
        if(finalResult.length == 0)
            System.out.println("No failed inspections.");
      
        else
        {
            for(int i = 0; i < finalResult.length; i++)
            {
                if(finalResult.length == 1)
                    System.out.println("This inspection failed: " + finalResult[0]);
                
                else
                {
                    if(i < 1)             
                        System.out.println("These inspections failed: ");
							
                    if(i < finalResult.length - 1)
                        System.out.print(finalResult[i] + ", ");
                    
                    else
                        System.out.println(finalResult[i]);
                }
            }
        } 
        
    } 

    /**
     * This method establishes an inspection to be performed.
     */
    public void startInspection()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("* * * Vehicle inspection system * * *");
        System.out.println("Do you want to begin a new inspection? Y/N");
        String currentInput = input.nextLine();
        String regNo;
        boolean authorization = false;
        boolean open  = true;
        boolean close = false;
        boolean invalid = true;
        
      	if(currentInput.equals("Y") || currentInput.equals("Yes") || currentInput.equals("yes"))
        {   
            controller.garageDoorHandler(open); 
            System.out.println("Please close the garage door by pressing C.");
  	    currentInput = input.nextLine();
            if(currentInput.equals("C"))
            {
                controller.garageDoorHandler(false);            
                System.out.println("Please enter the registration number of the vehicle to be inspected:");
                regNo = input.nextLine();
                
                while(invalid)
                {
                    try
                    {
                        System.out.println(controller.fetchCost(regNo));
                        invalid = false;
                    }
                
                    catch(IllegalRegNoException e)
                    {
                        fileLogger.caughtException("ControllerException, caused by the entered data: " + regNo);
                        System.out.println(e.getMessage());
                        System.out.println("Please enter the registration number of the vehicle to be inspected:");
                        regNo = input.nextLine();
                    }
                }
                
                System.out.println("Has the customer entered the creditcard? Y/N");
            
                currentInput = input.nextLine();
            
                if(currentInput.equals("Y"))
                {
                    authorization  = true;
            
                    if(authorization)
                    {
                        System.out.println("Transaction went trough!\n");
                        this.inspection(regNo); 
                    }
                }
            }         
        }
    }
}
