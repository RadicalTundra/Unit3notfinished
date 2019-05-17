/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgrady4_u2_parkingapp;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author tgrady4
 */
public class CheckOutStrategyFactorySingletonTest {
    
    CheckOutStrategyFactorySingleton factory;
    
    @Before
    public void setup()
    {
        factory = CheckOutStrategyFactorySingleton.INSTANCE;
    }
    
    @Test
    public void getStrategy()
    {
        assertTrue(factory.getStrategy("WithTicket") instanceof CheckOutWithTicket);
    }
}
