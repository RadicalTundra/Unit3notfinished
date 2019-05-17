/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgrady4_u2_parkingapp;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author tgrady4
 */
public class CheckOutWithTicketTest {
    List<ParkingSpot> parkingSpots;
    ParkingSpot spot;
    List<Ticket> tickets;
    Vehicle car1;
    Ticket ticket;
    LocalTime hour;
    CheckOutStrategy checkout;
    @Before
    public void setup()
    {
        hour = LocalTime.of(1, 0);
        car1 = new Vehicle(100);
        ticket = new Ticket(100);
        parkingSpots = new ArrayList();
        tickets = new ArrayList();
        spot = new ParkingSpot(car1, hour);
        parkingSpots.add(spot);
        tickets.add(ticket);
        checkout = new CheckOutWithTicket();
    }

    @Test
    public void CheckOut()
    {
        checkout.checkOut(parkingSpots, tickets);
        assertEquals(checkout.getTotalCheckIns(), 1);
    }
    
    @Test
    public void getTotal()
    {
        checkout.checkOut(parkingSpots, tickets);
        assertEquals(checkout.getTotal(), tickets.get(0).getCost(), 0);
    }
    
    @Test
    public void getTotalCheckIns()
    {
        checkout.checkOut(parkingSpots, tickets);
        assertEquals(checkout.getTotalCheckIns(), 1);
    }
}
