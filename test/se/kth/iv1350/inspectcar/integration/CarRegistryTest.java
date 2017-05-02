package se.kth.iv1350.inspectcar.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian
 */
public class CarRegistryTest {
    
    private CarRegistry instance;
    
    @Before
    public void setUp() 
    {
        instance = new CarRegistry();
    }
    
    @After
    public void tearDown() 
    {
        instance = null;
    }
    /**
     * Test of findInspection method, of class CarRegistry.
     */
    @Test
    public void testFindInspection() 
    {
        System.out.println("Testing findInspection...");
        String regNo = "PBN472";
        CarDTO car = instance.findInspection(regNo);
        String result = car.getRegNo();
        
        String expResult = "PBN472";
        assertEquals(expResult, result);
    }
    
}
