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
public class CheckInMechineTest {
    
    Vehicle car1;
    CheckInMechine mechine;
    List<Vehicle> vehicles;
    List<ParkingSpot> parkingSpots;
    List<Ticket> tickets;
    
    @Before
    public void setup(){
        vehicles = new ArrayList();
        parkingSpots = new ArrayList();
        tickets = new ArrayList();
        Ticket ticket = new Ticket(100);
        tickets.add(ticket);
        car1 = new Vehicle(101);
        vehicles.add(car1);
        mechine = new CheckInMechine(vehicles, parkingSpots, tickets);
    }
    
    @Test
    public void newCarCheckIn()
    {
        int sizeOfVehicles = vehicles.size();
        mechine.newCarCheckIn();
        assertEquals(sizeOfVehicles + 1, vehicles.size());
    }
    
    @Test
    public void getTickets()
    {
        List<Ticket> testTickets = mechine.getTicket();
        assertEquals(testTickets.get(0).getId(), tickets.get(0).getId());
    }
    
    @Test
    public void grabSpot()
    {
        LocalTime hour = LocalTime.of(1, 0);
        ParkingSpot testSpot = new ParkingSpot(car1, hour);
        
        assertEquals(CheckInMechine.grabSpot(car1, hour).getCar(), testSpot.getCar());
    }
}
