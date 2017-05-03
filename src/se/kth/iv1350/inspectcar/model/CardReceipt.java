package se.kth.iv1350.inspectcar.model;

/**
 * This class gives information about a card receipt.
 * 
 */
public class CardReceipt 
{
    private Amount amount;
  	  
    /**
     * Create a new instance that contains information about card receipt.
     *
     * @param amount of cost that is needed to be paid for inspections.
     */
    public CardReceipt(Amount amount)
    {
        this.amount = amount;
    }
  
    /**
     * Method getAmount is in charge of getting amount of inspection's cost.
     * @return amount of cost that is needed to be paid for inspection.
     */
    public Amount getAmount()
    {
    	return amount;
    }
}
