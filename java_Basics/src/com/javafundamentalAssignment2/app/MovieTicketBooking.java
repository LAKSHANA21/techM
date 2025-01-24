package com.javafundamentalAssignment2.app;

import java.util.Scanner;

public class MovieTicketBooking {
	
	public static boolean login(String userName, String password) {
	    
		String[] names = {"Lakshu" , "Jaswin" , "Amirtha"};
		String[] pass = {"Lakshu@123" , "Jaswin@123" , "Amirtha@123"};
		
		boolean result = false;
		for(int i = 0; i < 3; i++) {
			if(userName.equals(names[i])) {
				if(password.equals(pass[i])) {
					result = true;
			}
		}
		}
			return result;
	}
	
	public static void getDetails() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the username: ");
		String userName = input.nextLine();
		
		System.out.println("Enter the password: ");
	    String password = input.nextLine();

		boolean result = login(userName, password);
		
		if(!result) {
			System.out.println("Re-enter the correct details");
			getDetails();
		}
		else {
			System.out.println("Successfully logged in and Access granted");
		}
	}
	
	public static void movieShows(String[] movieNames, boolean[][] seats) {
		
		System.out.println("Available Movie Shows:");
		
		for (int i = 0; i < movieNames.length; i++) {
			System.out.println(movieNames[i]);
			System.out.print("Available Seats: ");
			
			for (int j = 0; j < seats[i].length; j++) {
				System.out.print((seats[i][j] ? "true " : " Booked "));
			}
			System.out.println();
		}
	}
	
	public static void seatBooking(int movieIndex, boolean[][] seats) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Select the seat: ");
		int seatNumber = input.nextInt() - 1;
		
		if (seatNumber < 0 || seatNumber >= seats[movieIndex].length) {
			System.out.println("Invalid seat number. Please try again.");
			seatBooking(movieIndex, seats);
			return;
		}
		
		if (seats[movieIndex][seatNumber]) {
			seats[movieIndex][seatNumber] = false;
			System.out.println("Seat booked successfully! Seat number: " + (seatNumber + 1));
		} else {
			System.out.println("Seat is already booked. Please select another seat.");
			seatBooking(movieIndex, seats);
		}
	}
	
	public static void movieBooking(String[] movieNames, boolean[][] seats) {
		Scanner input = new Scanner(System.in);
		System.out.println("Select the movie");
		for (int i = 0; i < movieNames.length; i++) {
			System.out.println(movieNames[i]);
		}
		
		int choice = input.nextInt();
		if (choice < 1 || choice > movieNames.length) {
			System.out.println("Invalid choice. Please try again.");
			movieBooking(movieNames, seats);
			return;
		}
		
		System.out.println("You selected: " + movieNames[choice - 1]);
		seatBooking(choice - 1, seats);
	}
	
	public static void main(String[] args) {
		String[] movieNames = {
			"1. Lucky Baskar - 2:00 PM",
			"2. Amaran - 5:00 PM",
			"3. Kanguva - 8:00 PM"
		};
		
		boolean[][] seats = { 
			{true, true, true, true, true},
			{true, true, true, true, true}, 
			{true, true, true, true, true} 
		};
		
		getDetails();
		movieShows(movieNames, seats);
		movieBooking(movieNames, seats);
	}
	
}

