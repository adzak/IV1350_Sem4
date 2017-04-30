package se.kth.iv1350.inspectcar.model;

import se.kth.iv1350.inspectcar.integration.CarDTO;

/**
 * This class calculates the cost of a car inspection. 
 */
public class CalculateCost 
{
  private boolean fetchedExchangeRate;
  
  /**
   * Creates an instance of CalculateCost.
   */
  public CalculateCost()
  {
      fetchedExchangeRate = true;
  }
  
  /**
   * This method calculates the cost for a specific car's inspection. 
   *
   * @param car contains necessary methods for calculating the cost.
   * @return cost of the inspection. 
   */
  public double calcCost(CarDTO car)
  {
      double cost = 0;
      String regNo = car.getRegNo();
    
      for(int i = 0; i < regNo.length(); i++)
      cost += (double)regNo.charAt(i);
    
      return cost;
  }
  
}
