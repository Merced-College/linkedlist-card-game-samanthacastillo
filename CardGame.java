//package linkedLists;
// Samantha Castillo 11/18/25

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;



public class CardGame {
	
	private static LinkList cardList = new LinkList();  // make list

	public static void main(String[] args) {

		// File name to read from
        String fileName = "cards.txt"; // Ensure the file is in the working directory or specify the full path

        // Read the file and create Card objects
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into components
                String[] details = line.split(","); // Assuming comma-separated values
                if (details.length == 4) {
                    // Parse card details
                    String suit = details[0].trim();
                    String name = details[1].trim();
                    int value = Integer.parseInt(details[2].trim());
                    String pic = details[3].trim();

                    // Create a new Card object
                    Card card = new Card(suit, name, value, pic);

                    // Add the Card object to the list
                    cardList.add(card);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Print the loaded cards
        System.out.println("Cards loaded:");
        cardList.displayList();
		
		Card[] playerHand = new Card[5];
		for(int i = 0; i < playerHand.length; i++)
			playerHand[i] = cardList.getFirst();
		
		System.out.println("players hand");
		for(int i = 0; i < playerHand.length; i++)
			System.out.println(playerHand[i]);
		
		System.out.println();
		System.out.println("the deck");
		cardList.displayList();


        //added code - computer hand
        Card[] computerHand = new Card[5];
        for(int i = 0; i < computerHand.length; i++)
            computerHand[i] = cardList.getFirst();
        
        System.out.println("computer hand");
        for(int i = 0; i < computerHand.length; i++)
            System.out.println(computerHand[i]);
        
        System.out.println();
        System.out.println("the deck");
        cardList.displayList();
       
        //ADDED CODE BELOW

        //gather the top card's information from each deck
        Card topPlayerHand = playerHand[0];
        Card topComputerHand = computerHand[0];

        System.out.println("Top Player Card: " + topPlayerHand +
        "\nTop Computer Hand: " + topComputerHand + "\nComparing Values...");

        //compare card values to determine higher valued card
        if (topPlayerHand.getCardValue() > topComputerHand.getCardValue()) {
            System.out.println("Player won with value of " + topPlayerHand.getCardValue()
            + ". Computer lost with value of " + topComputerHand.getCardValue() + ".");
        }

        else if (topPlayerHand.getCardValue() < topComputerHand.getCardValue()) {
            System.out.println("Computer won with value of " + topComputerHand.getCardValue()
            + ". Player lost with value of " + topPlayerHand.getCardValue() + ".");
        }

        //last if statement in case of error
        else {
            System.out.println("Error.");
        }


	}//end main

}//end class
