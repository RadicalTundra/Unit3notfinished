package tgrady4_u2_parkingapp;

import java.text.NumberFormat;
import java.util.List;

public class CheckOutSpecialEvent implements CheckOutStrategy{
    private double totalSpecialEvent = 0.00;
    private final double specialEvent = 20.00;
    private int totalCheckInsSpecialEvent = 0;
    NumberFormat n = NumberFormat.getCurrencyInstance();

    @Override
    public void checkOut(List<ParkingSpot> parkingSpots, List<Ticket> tickets) {
        if(parkingSpots.size() > 0)
        {
            totalSpecialEvent += specialEvent;
            System.out.println("\nReceipt for vehicle " + parkingSpots.get(0).getCar().getId() + "\n");
            System.out.println("Heyyy! I hope your event was a good one! just $20.00 and you'll be on your way.");
            System.out.println("You paid: $20.00\n");
            for(int i = 0; i < tickets.size(); i++)
            {
                if(parkingSpots.get(0).getCar().getId() == tickets.get(i).getId())
                {
                    tickets.get(i).setCost(20.00);
                }
            }
            parkingSpots.remove(0);
            totalCheckInsSpecialEvent++;    
        }
        else
        {
                System.out.println("\n==============================\n");
                System.out.println("No cars left in the garage.");
                System.out.println("\n==============================\n");
        }
    }
    
    @Override
    public double getTotal(){
        return totalSpecialEvent;
    }
    
    @Override
    public int getTotalCheckIns(){
        return totalCheckInsSpecialEvent;
    }
 
    @Override
    public void displayTotals()
    {
        System.out.println("From " + totalCheckInsSpecialEvent + " Special Event tickets, a total of " + n.format(totalSpecialEvent) + " was acquired.\n");
    }
    
}
