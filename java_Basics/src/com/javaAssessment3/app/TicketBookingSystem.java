package com.javaAssessment3.app;

import java.util.*;

class PassengerDetails{
	
	private String name;
	private String phone;
	private String seatNumber;
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name=name;
	}
	/**
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone=phone;
	}
	/**
	 * 
	 * @return
	 */
	public String getSeatNumber() {
		return seatNumber;
	}
	/**
	 * 
	 * @param seatNumber
	 */
	public void setSeatNumber(String seatNumber) {
		this.seatNumber=seatNumber;
	}
	/**
	 * 
	 * @param name
	 * @param phone
	 * @param seatNumber
	 */
	 public PassengerDetails(String name, String phone, String seatNumber) {
		 this.name=name;
		 this.phone=phone;
		 this.seatNumber=seatNumber;
	 }

	 public String toString() {
		 return name+","+phone+","+seatNumber;
	 }
}

class InvalidFormateException extends Exception{
	public InvalidFormateException(String message) {
		super(message);
	}
}
class PhoneValidationException extends Exception{
	public PhoneValidationException(String message) {
		super(message);
	}
}
public class TicketBookingSystem {
	/**
	 * 
	 * @param name
	 * @param seatNumber
	 * @return
	 */
	public static String generateBookingId(String name, String seatNumber) {
		String firstName = name.replace("\\s"," ").substring(0,3).toUpperCase();
		int randomNumber=new Random().nextInt(9000)+1000;
		return firstName+randomNumber+seatNumber;
	}
	/**
	 * 
	 * @param input
	 * @throws InvalidFormateException
	 * @throws PhoneValidationException
	 */
	public static void validInput(String input) throws InvalidFormateException,PhoneValidationException{
		String[] parts=input.split(",");	
		if(parts.length!=3) {
			throw new InvalidFormateException("Invalid input format. Expected format: Name,Phone,SeatNumber.");
		}
		String name =parts[0].trim();
		String phone =parts[1].trim();
		String seatNumber =parts[2].trim();
		
		if(phone.length()!=10 || !phone.matches("\\d+")) {
			throw new PhoneValidationException("Invalid phone number. Phone number must be numeric and exactly 10 digits.");
		}
		
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the passenger Details");
		String details = input.nextLine();
		try {
			validInput(details);
			
			String[] parts = details.split(",");
            String name = parts[0].trim();
            String phone = parts[1].trim();
            String seatNumber = parts[2].trim();
            String bookingId = generateBookingId(name,seatNumber);
            System.out.println("Name: "+name);
            System.out.println("Phone Number: "+phone);
            System.out.println("Seat Number: "+seatNumber);
            System.out.println("Booking Id: "+bookingId);
		}catch( InvalidFormateException|PhoneValidationException e) {
			System.out.println(e.getMessage());
		}
		input.close();
	}

}
