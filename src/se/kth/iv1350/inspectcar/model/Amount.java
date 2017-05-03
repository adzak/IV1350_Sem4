package se.kth.iv1350.inspectcar.model;

/**
 * The class Amount represents an amount to be paid in a specified currency.
 */
public class Amount 
{
    private String currency;
    private double amount;   
    
    /*
     * Amount creates a new instance which contains information about the amount that is needed to be paid.
     * 
     * @param amount specifies the amount to be paid. 
     */
    public Amount(double amount)
    {
        this.currency = "SEK";
        this.amount = amount;
    }    
    /**
     * Method getCurrency is in charge of getting currency.
     * 
     * @return type of currency is returned.
     */
    public String getCurrency()
    {
     	return currency;
    }

    /**
     * Method getAmount is in charge of getting amount.
     * 
     * @return amount of inspecitons is returned.
     */
    public double getAmount()
    {
        return amount;
    }
    
    /**
     * toString is responsible for creating a string representation of an Amount.
     * 
     * @return the string representation of an Amount. 
     */
    public String toString()
    {
        StringBuilder costLayout = new StringBuilder();
        costLayout.append(amount + " " + currency);  
        
        return costLayout.toString();
    }
}
