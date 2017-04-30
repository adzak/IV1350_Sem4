package se.kth.iv1350.inspectcar.model;

import java.util.Date;

/**
 * This class represents a creditcard.
 */
public class CreditCard 
{
    private int pin;
    private String number;
    private String holder;
    private Date expiryDate;
    private int CVC;
    
    /**
     * Create a new instance that include all information for credit card.
     *
     * @param pin pin code of credit card.
     * @param number credit card number.
     * @param holder credit card owner's name
     * @param expiryDate credit card's expiration date
     * @param CVC credit card's CVC number
     */
    public CreditCard(int pin, String number, String holder, Date expiryDate, int CVC)
    {
        this.pin = pin;
        this.number = number;
        this.holder = holder;
        this.expiryDate = expiryDate;
        this.CVC = CVC;
    }
    
 /*
    * Method getPin is in charge of getting the pin code.
    * @return number of the pin code.
    */
    public int getPin ()
    {
        return pin;
    }
  
   /*
    * Method getNumber is in charge of getting the card number.
    * @return number of the credit card.
    */
    public String getNumber()
    {
        return number;
    }
  
   /*
    * Method getHolder is in charge of getting the card owner's name.
    * @return name of the card owner.
    */
    public String getHolder()
    {
        return holder;
    }
  
   /*
    * Method getExpiryDate is in charge of getting the date of expiration.
    * @return number of the date of expiration.
    */
    public Date getExpiryDate()
    {
        return expiryDate;
    }
  
   /*
    * Method getCVC is in charge of getting the CVC number.
    * @return the number of the CVC.
    */
    public int getCVC()
    {
        return CVC;
    }
}
