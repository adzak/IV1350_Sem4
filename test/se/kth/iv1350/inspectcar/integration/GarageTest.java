package se.kth.iv1350.inspectcar.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GarageTest 
{
    private int result;
    private Garage instance;
    @Before
    public void setUp() 
    {
        result = 0;
        instance = new Garage();
    }
    
    @After
    public void tearDown() 
    {
        instance = null;
    }

    /**
     * Test of nextCustomer method, of class Garage.
     */
    @Test
    public void testNextCustomer() {
        System.out.println("nextCustomer - display number");
       
        for(int i = 0; i < 1001; i++)
        {
          result = instance.getDisplayNumber();
          instance.nextCustomer();
        }
        
        int expResult = 0;
        assertEquals(expResult,result,0);
    }   
}
