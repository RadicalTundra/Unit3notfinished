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
public class TicketTest {
    
    Ticket ticket;
    
    @Before
    public void setup()
    {
        ticket = new Ticket(100, 25.00);
    }
    
    @Test
    public void setAndGetCost()
    {
        ticket.setCost(10.00);
        assertEquals(ticket.getCost(), 10.00, 0);
    }
    
    @Test
    public void getId()
    {
        assertEquals(ticket.getId(), 100);
    }
}
