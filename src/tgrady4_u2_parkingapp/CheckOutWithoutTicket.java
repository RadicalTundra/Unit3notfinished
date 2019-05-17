package tgrady4_u2_parkingapp;

import java.text.NumberFormat;
import java.util.List;

public class CheckOutWithoutTicket implements CheckOutStrategy{
    private double totalWithoutTicket = 0.00;
    private final double lostTicket = 25.00;
    private int totalCheckInsWithoutTicket = 0;
    NumberFormat n = NumberFormat.getCurrencyInstance();

    @Override
    public void checkOut(List<ParkingSpot> parkingSpots, List<Ticket> tickets) {
        if(parkingSpots.size() > 0)
        {
            totalWithoutTicket += lostTicket;
            System.out.println("\nReceipt for vehicle " + parkingSpots.get(0).getCar().getId() + "\n");
            System.out.println("Oh no! Did you lose your ticket?!");
            System.out.println("Well, there's an extra one here that says \"A Candy Company: Damp Bobby\". I'm not sure what it means, but It'll cost ya $25.");
            System.out.println("You paid: $25.00\n");
            for(int i = 0; i < tickets.size(); i++)
            {
                if(parkingSpots.get(0).getCar().getId() == tickets.get(i).getId())
                {
                    tickets.get(i).setCost(25.00);
                }
            }
            parkingSpots.remove(0);
            totalCheckInsWithoutTicket++;    
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
        return totalWithoutTicket;
    }
    
    @Override
    public int getTotalCheckIns(){
        return totalCheckInsWithoutTicket;
    }
    
    @Override
    public void displayTotals()
    {
        System.out.println("From " + totalCheckInsWithoutTicket + " Lost Tickets, a total of " + n.format(totalWithoutTicket) + " was acquired.\n");
    }
}
