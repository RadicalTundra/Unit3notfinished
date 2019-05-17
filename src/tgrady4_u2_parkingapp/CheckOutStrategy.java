package tgrady4_u2_parkingapp;

import java.util.List;

public interface CheckOutStrategy {
    public void checkOut(List<ParkingSpot> parkingSpots, List<Ticket> tickets);
    
    public double getTotal();
    
    public int getTotalCheckIns();
    
    public void displayTotals();
}
