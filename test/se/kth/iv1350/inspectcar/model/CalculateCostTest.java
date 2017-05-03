package se.kth.iv1350.inspectcar.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.inspectcar.integration.CarDTO;

public class CalculateCostTest 
{
    private CalculateCost instance;
    private CarDTO car;
      
    @Before
    public void setUp() 
    {
        instance = new CalculateCost();
        car = new CarDTO("ABC123");     
    }
    
    @After
    public void tearDown() 
    {
        instance = null;
        car = null;
    }

    /**
     * Test of calcCost method, of class CalculateCost.
     */
    @Test
    public void testCalcCost() 
    {
        System.out.println("Testing calcCost...");
        double expResult = 348.0;
        double result = instance.calcCost(car);
        assertEquals(expResult, result,0);
    }   
    
    @Test
    public void testNegativeCost()
    {
      System.out.println("Testing calcCost - negative cost...");
      double result = 0;
      String regNo;
      
      for(int i = 0; i < 999; i++)
      {
          regNo = randomPlates();
          car = new CarDTO(regNo);
          result = instance.calcCost(car);
          assertFalse("The result was not negative!", result < 0);
      }
    }
    
    public static String randomPlates()
    {
    
        StringBuilder regNo = new StringBuilder();
	for(int i = 0; i < 3; i++) 
	{
	    char C = (char)(Math.random() * 26 + 'A');
	    regNo.append(C);
	}
	    
	for(int i = 0; i < 3; i++)
	{
            char number = (char)(Math.random() * 10 + '0');
	    regNo.append(number);
	}
    
        return regNo.toString();
    }
}
