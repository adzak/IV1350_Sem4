package se.kth.iv1350.inspectcar.controller;

import se.kth.iv1350.inspectcar.integration.Garage;
import se.kth.iv1350.inspectcar.integration.PaymentAuthorization;
import se.kth.iv1350.inspectcar.integration.Printer;
import se.kth.iv1350.inspectcar.integration.CarRegistry;
import se.kth.iv1350.inspectcar.model.Inspection;
import se.kth.iv1350.inspectcar.model.CalculateCost;
import se.kth.iv1350.inspectcar.integration.CarDTO;
import se.kth.iv1350.inspectcar.model.Amount;
import se.kth.iv1350.inspectcar.model.CreditCard;
import se.kth.iv1350.inspectcar.model.CardReceipt;
import se.kth.iv1350.inspectcar.model.InspectionResult;
import java.util.Date;

/**
 * This is the application's single controller. All calls to the model pass through here.
 */
public class Controller 
{
    private Printer printer;
    private PaymentAuthorization paymentAuthorization;
    private Garage garage;
    private CarRegistry carRegistry; 
    private CalculateCost calculateCost;
    private CarDTO currentInspectedCar;
    private Inspection currentInspection;    

    /**
     * Create a new instance representing the controller.
     * 
     * @param printer The printer is necessary for the controller to print documents.
     * @param paymentAuthorization The payment authorization checks if a card transaction is valid or not.
     * @param garage The garage is needed for the controller to grant access to the garage.
     * @param carRegistry The car registry fetches information about a specific vehicle.
     */
    public Controller(Printer printer, PaymentAuthorization paymentAuthorization, Garage garage, CarRegistry carRegistry)
    {
        this.printer = printer;
        this.paymentAuthorization = paymentAuthorization;
        this.garage = garage;
        this.carRegistry = carRegistry;
        this.calculateCost = new CalculateCost();
    }
    
     /**
     * garageDoorHandler handles the different states of the garage door.
     *
     * @param openOrClose specifies the state of the garage door.
     */
    public void garageDoorHandler(boolean openOrClose)
    {
    	if(openOrClose == true)
        garage.nextCustomer();
      
        else
        garage.closeDoor();
    }
  	
    /**
     * This method fetches the cost for the inspection.
     *
     * @param regNo specifies the registration number of a car.
     * @return the cost of inspection for a given car.
     */
    public Amount fetchCost(String regNo)
    {
        CarDTO car = carRegistry.findInspection(regNo);
      	this.saveCar(car);
      	double amount = calculateCost.calcCost(car);
        Amount cost = new Amount(amount);
      
        return cost;
    }
  
    /**
     * PayWithCard checks for authorization of payment and creates a receipt to be printed.
     *
     * @param amount specifies the amount to be paid.
     * @return returns the transaction status.
     */
    public boolean payWithCard(Amount amount)
    {
        Date date = new Date();
        CreditCard card = new CreditCard(1234, "1234", "Test Testsson", date, 123);
        boolean resultOfAuthorization = paymentAuthorization.authorizePayment(card, amount);
        
        CardReceipt receipt = new CardReceipt(amount);
        
        printer.printCardReceipt(receipt);
        
        return resultOfAuthorization;
      
    }
  
    /**
     * FethNextInspection fetches the inspection moments for a given car.
     *
     * @param regNo defines the given register number of a car.
     * @return the inspection moments for a given car. 
     */
    public String[] fetchNextInspection(String regNo)
    {
      	Inspection insp = new Inspection(currentInspectedCar);
      
      	saveInspection(insp);
      	
        String[] inspectionMoments = currentInspectedCar.getStandardInspectionMoments();
          
        return inspectionMoments;
    }
  
    /**
     * enterInspectionResult documents the evaluation of an inspection moment.
     *
     * @param result defines the final evaluation.
     * @param indexToUpdate determines what slot to update.
     */
    public void enterInspectionResult(boolean result, int indexToUpdate)
    {
      	currentInspection.storeInspectionResult(result, indexToUpdate);
    }
  
    /**
     * Contains specific methods for wrapping up the car inspection.
     *
     * @return returns the final result of the vehicle inspection.
     */
    public String[] finalizeInspection()
    {
      	String[] finalResult = currentInspection.compileInspectionResult();
      	currentInspectedCar.updateInspectionMoments(finalResult);
    	InspectionResult inspResult = new InspectionResult(currentInspection);
      	printer.printInspectionResult(inspResult);
        
        return finalResult;
    }

    /**
     * Saves the current car to be inspected. 
     *
     * @param car is the car object to be inspected.
     */
    private void saveCar(CarDTO car)
    {
        currentInspectedCar = car;
    }

    /**
     * Saves the current inspection.
     *
     * @param currentInspection is the ongoing inspection object.
     */
    private void saveInspection(Inspection currentInspection)
    {
        this.currentInspection = currentInspection;
    }    
}
