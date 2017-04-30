package se.kth.iv1350.inspectcar.startup;

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
import se.kth.iv1350.inspectcar.controller.Controller;
import se.kth.iv1350.inspectcar.view.View;

/**
 *
 * @author Adrian
 */
public class Main 
{
    public static void main(String[] args)
    {
       CarRegistry carRegistry = new CarRegistry();
       Garage garage = new Garage();
       PaymentAuthorization paymentAuthorization = new PaymentAuthorization();
       Printer printer = new Printer();
       Controller controller = new Controller(printer, paymentAuthorization, garage, carRegistry);
       View view = new View(controller);
       
       view.startInspection();
    }
}
