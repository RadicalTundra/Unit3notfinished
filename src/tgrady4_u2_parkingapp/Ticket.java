/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgrady4_u2_parkingapp;

/**
 *
 * @author tgrady4
 */
public class Ticket {
    private int id;
    private double cost;
    
    public Ticket(int id){
        this.id = id;
        cost = 0;
    }
    
    public Ticket(int id, double cost)
    {
        this.id = id;
        this.cost = cost;
    }
    
    public int getId(){
        return id;
    }
    
    public double getCost()
    {
        return cost;
    }
    
    public void setCost(double cost)
    {
        this.cost = cost;
    }
    
}
