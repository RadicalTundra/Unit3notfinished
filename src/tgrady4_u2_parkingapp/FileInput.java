/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgrady4_u2_parkingapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Teddy
 */
public class FileInput {
    
    public void getAllIds(List<Ticket> tickets) throws IOException{
        try{
        BufferedReader inFile = new BufferedReader(new FileReader("ListOfTickets.txt"));
        String line = inFile.readLine();
        while (line != null){
            String[] splitLine = line.split(", ");
            String[] splitStr1 = null;
            String[] splitStr2 = null;
            for(int i = 0; i < splitLine.length; i++)
            {
                splitStr1 = splitLine[0].split(": ");
                splitStr2 = splitLine[1].split(": ");
            }
            Ticket newTicket = new Ticket(Integer.parseInt(splitStr1[1]), Double.parseDouble(splitStr2[1]));
            tickets.add(newTicket);
            line = inFile.readLine();
        }
        inFile.close();
        }catch(FileNotFoundException e){
            System.out.println("****************************************************************");
            System.out.println("Hey!!! File not found! There is not current history for tickets.");
            System.out.println("*****************************************************************\n");
        }catch(IOException e){
            System.out.println("*********************************************************");
            System.out.println("There is an IOException being thrown from the file input.");
            System.out.println("**********************************************************\n");
        }
    }
}
