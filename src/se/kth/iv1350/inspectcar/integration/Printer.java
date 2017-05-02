package se.kth.iv1350.inspectcar.integration;

import se.kth.iv1350.inspectcar.model.CardReceipt;
import se.kth.iv1350.inspectcar.model.InspectionResult;

/**
 * This class is used to print different types of documents.
 */
public class Printer 
{
    private boolean printerReady;

    /**
     * Creates new instance representing a printer.
     */
    public Printer()
    {
        printerReady = true;
    }

     /**
      * The method printCardReceipt is used for showing that the printer is printing the receipt.
      * @param receipt The receipt to be printed.
      */
     public void printCardReceipt(CardReceipt receipt)
     {
        System.out.println("Printing receipt...");
     }

     /**
      * The method printInspectionResult is used for showing that the printer is printing the final result of car inspection.
      * @param inspResult The final result of inspection that is going to be printed.
      */
     public void printInspectionResult(InspectionResult inspResult)
     {
        System.out.println("Printing inspection result...");
     }     
}
