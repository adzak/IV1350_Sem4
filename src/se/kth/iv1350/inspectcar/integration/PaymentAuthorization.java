
package se.kth.iv1350.inspectcar.integration;

import se.kth.iv1350.inspectcar.model.Amount;
import se.kth.iv1350.inspectcar.model.CreditCard;

/**
 * This class is used to authorize payments made by creditcard. 
 * PaymentAuthorization handles all calls to the payment authorization system. 
 */
public class PaymentAuthorization 
{
    
    private boolean paymentAuthorizationSystemOnline;
    
    /**
     * Creates new instance representing an external online payment authorization system.
     */
    public PaymentAuthorization()
    {
        paymentAuthorizationSystemOnline = true;
    }
    
    /**
     * The method authorizePayment returns true if the payment is authorized and false if it is not. 
     * @param card The card used for the payment transaction.
     * @param amount The amount to withdraw from customer's bank account. 
     * @return Result of an authorize payment request. This dummy implementation always returns true, 
     * which indicates an approved transaction. 
     */
    public boolean authorizePayment(CreditCard card, Amount amount )
    {
        boolean resultOfAuthorization = true;
        
        return resultOfAuthorization;
    }     
}
