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
  
    //SUT//
    private CarDTO currentInspectedCar;
    private Inspection currentInspection;    
    
    public Controller(Printer printer, PaymentAuthorization paymentAuthorization, Garage garage, CarRegistry carRegistry)
    {
        this.printer = printer;
        this.paymentAuthorization = paymentAuthorization;
        this.garage = garage;
        this.carRegistry = carRegistry;
        this.calculateCost = new CalculateCost();
    }
    
     /**
     * garageDoorHandler handles the different states of the garagedoor.
     *
     * @param openOrClose specifies the state of the garagedoor.
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
     * @param card contains multiple data necessary for method PayWithCard.
     * @param amount specifies the amount to be paid.
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
     * 
     *
     * @param regNo defines the given register number of a car.
     * @return 
     */
    public String[] fetchNextInspection(String regNo)
    {
      	Inspection insp = new Inspection(currentInspectedCar);
      
      	saveInspection(insp);
      	
        String[] inspectionMoments = currentInspectedCar.getStandardInspectionMoments();
          
        return inspectionMoments;
    }
  
    /**
     * enterInspectionResult 
     *
     * @param result 
     * @param indexToUpdate 
     */
    public void enterInspectionResult(boolean result, int indexToUpdate)
    {
      	currentInspection.storeInspectionResult(result, indexToUpdate);
    }
  
    /**
     * 
     */
    public String[] finalizeInspection()
    {
      	String[] finalResult = currentInspection.compileInspectionResult();
      	currentInspectedCar.updateInspectionMoments(finalResult);
    	InspectionResult inspResult = new InspectionResult(currentInspection);
      	printer.printInspectionResult(inspResult);
        
        return finalResult;
    }
  
    private void saveCar(CarDTO car)
    {
        currentInspectedCar = car;
    }
  
    private void saveInspection(Inspection currentInspection)
    {
        this.currentInspection = currentInspection;
    }    
}
