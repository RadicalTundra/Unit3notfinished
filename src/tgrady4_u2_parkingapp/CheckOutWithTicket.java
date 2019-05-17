package tgrady4_u2_parkingapp;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

public class CheckOutWithTicket implements CheckOutStrategy {

    private Duration timeParkedDuration;
    private long timeParked;
    Random rand = new Random();
    private final double minimumFee = 5.00;
    private final double hourlyRate = 1.00;
    private final double allDayWithTicket = 15.00;
    private int totalCheckInsWithTicket = 0;
    private double totalWithTicket = 0.00;
    NumberFormat n = NumberFormat.getCurrencyInstance();
    
    @Override
    public void checkOut(List<ParkingSpot> parkingSpots, List<Ticket> tickets) {
        if(parkingSpots.size() > 0)
        {
            int hourOfNight = rand.nextInt(11);
            hourOfNight = hourOfNight + 12;
            LocalTime timeLeft = LocalTime.of(hourOfNight, 0);
            double ammountDue = 0;
             //eventually this will be a "mechine" class(maybe a second one) with the method called checkOut(some parameters)
            System.out.println("\nReceipt for vehicle " + parkingSpots.get(0).getCar().getId() + "\n");
            timeParkedDuration = Duration.between(parkingSpots.get(0).getTime(), timeLeft);
            timeParked = (timeParkedDuration.getSeconds()/60)/60;
            if(parkingSpots.get(0).getTime().toString().equals("12:00")){
                System.out.println(timeParked + " hours parked. You parked from " + parkingSpots.get(0).getTime() + "PM to " + (timeLeft.minusHours(12)) + "PM.");
            }
            else{
                System.out.println(timeParked + " hours parked.\nYou parked from " + parkingSpots.get(0).getTime() + "AM - " + (timeLeft.minusHours(12)) + "PM.");
            }
            ammountDue += minimumFee;
            if(timeParked > 3){
                //only calculate the time parked if it's over the minimum of 3 hours, and until you hit the max of a day at $15
                for(int i = 0; i < timeParked - 3; i++){
                    if(ammountDue < allDayWithTicket){
                        ammountDue += hourlyRate;
                    }
                }
            }
            totalWithTicket += ammountDue;
            System.out.println("You paid: " + n.format(ammountDue) + "\n");
            for(int i = 0; i < tickets.size(); i++)
            {
                if(parkingSpots.get(0).getCar().getId() == tickets.get(i).getId())
                {
                    tickets.get(i).setCost(ammountDue);
                }
            }
            parkingSpots.remove(0);
            totalCheckInsWithTicket++;
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
        return totalWithTicket;
    }
    
    @Override
    public int getTotalCheckIns(){
        return totalCheckInsWithTicket;
    }
    
    @Override
    public void displayTotals()
    {
        System.out.println("From " + totalCheckInsWithTicket + " Check Ins, a total of " + n.format(totalWithTicket) + " was acquired.\n");
    }
}
