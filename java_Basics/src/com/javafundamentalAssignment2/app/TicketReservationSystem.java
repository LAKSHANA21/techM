package com.javafundamentalAssignment2.app;

import java.util.Scanner;

public class TicketReservationSystem {
	
	public static void displayCategories(String[] categories, boolean[][] seats) {
		
		System.out.println("Available Seating Categories:");
		
		for (int i = 0; i < categories.length; i++) {
			
			System.out.println((i + 1) + ". " + categories[i]);
			
			System.out.print("Available Seats: ");
			
			for (int j = 0; j < seats[i].length; j++) {
				System.out.print((seats[i][j] ? " true " : " Booked "));
			}
			System.out.println();
		}
	}

	public static void reserveSeat(int categoryIndex, boolean[][] seats) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Select a seat (1 to " + seats[categoryIndex].length + "): ");
		
		int seatNumber = input.nextInt() - 1;
		
		if (seatNumber < 0 || seatNumber >= seats[categoryIndex].length) {
			
			System.out.println("Invalid seat number. Please try again.");
			
			reserveSeat(categoryIndex, seats);
			return;
		}
		 
		if (seats[categoryIndex][seatNumber]) {
			
			seats[categoryIndex][seatNumber] = false;
			System.out.println("Seat booked successfully in " + (categoryIndex + 1) + ". category! Seat number: " + (seatNumber + 1));
			
		} else {
			
			System.out.println("Seat is already booked. Please select another seat.");
			reserveSeat(categoryIndex, seats);
		}
	}
	
	public static void bookTicket(String[] categories, boolean[][] seats) {
		Scanner input = new Scanner(System.in);
		System.out.println("Select a category by entering the corresponding number: ");
		for (int i = 0; i < categories.length; i++) {
			System.out.println((i + 1) + ". " + categories[i]);
		}
		
		int choice = input.nextInt();
		if (choice < 1 || choice > categories.length) {
			System.out.println("Invalid choice. Please try again.");
			bookTicket(categories, seats);
			return;
		}
		
		if (hasAvailableSeats(choice - 1, seats)) {
			System.out.println("You selected: " + categories[choice - 1]);
			reserveSeat(choice - 1, seats);
		} else {
			System.out.println("No seats available in this category. Please select another category.");
			bookTicket(categories, seats);
		}
	}
	
	public static boolean hasAvailableSeats(int categoryIndex, boolean[][] seats) {
		for (boolean seat : seats[categoryIndex]) {
			if (seat) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String[] categories = {
			"Regular",
			"Premium",
			"VIP"
		};
		
		boolean[][] seats = { 
			{true, true, true, true, true, true, true, true, true, true},
			{true, true, true, true, true},
			{true, true}  
		};
		
		displayCategories(categories, seats);
		bookTicket(categories, seats);
	}
}


