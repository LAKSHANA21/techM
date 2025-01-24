package com.javafundamentalAssignment4.app;
import java.util.Scanner;

class InvalidUserNameException extends Exception{
	public InvalidUserNameException(String message) {
		super(message);
	}
}

class InvalidPasswordException extends Exception{
	public InvalidPasswordException(String message) {
		super(message);
	}
}
class User{
	
	private static final String username1 = "Lakshu";
	private static final String password1 = "Lakshu@123";
	private static final String username2 = "Jaswin";
	private static final String password2 = "Jaswin@123";
	private static final String username3 = "Amritha";
	private static final String password3 = "Amritha@123";
	
	public static void validusername(String username) throws InvalidUserNameException {
		String details="^[a-zA-Z][a-zA-Z0-9_]{5,29}$";
		if(username.length() < 6 || username.length() > 30) {
			throw new InvalidUserNameException("Invalid username");
		}
		if (!Character.isLetter(username.charAt(0))) {
            throw new InvalidUserNameException("Username must start with an alphabetic character.");
        }
        for (char c : username.toCharArray()) {
            if (!(Character.isLetterOrDigit(c) || c == '_')) {
                throw new InvalidUserNameException("Username can only contain alphanumeric characters and underscores.");
            }
        }
	} 
}

class Password{
	public static void validpassword(String password) throws InvalidPasswordException{
		 if (password.length() < 8) {
	            throw new InvalidPasswordException("Password must be at least 8 characters long.");
	        }
	        boolean lower = false, upper = false, digit = false, special = false;
	        String specialChars = "!@#$%^&*()-+";

	        for (char c : password.toCharArray()) {
	            if (Character.isLowerCase(c)) lower = true;
	            else if (Character.isUpperCase(c)) upper = true;
	            else if (Character.isDigit(c)) digit = true;
	            else if (specialChars.contains(String.valueOf(c))) special = true;
	        }

	        if (!lower) throw new InvalidPasswordException("Password must contain at least one lowercase character.");
	        if (!upper) throw new InvalidPasswordException("Password must contain at least one uppercase character.");
	        if (!digit) throw new InvalidPasswordException("Password must contain at least one digit.");
	        if (!special) throw new InvalidPasswordException("Password must contain at least one special character.");
	    }
}

public class Login {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	String username=sc.nextLine();
	User user=new User();
	
	String password=sc.nextLine();
	Password pass=new Password();
	
	try {
		user.validusername(username);
	}catch(InvalidUserNameException e) {
		System.out.println(e);
	}
	
	try {
		pass.validpassword(password);
		System.out.println("Welcome "+username);
	}catch(InvalidPasswordException e) {
		System.out.println(e);
	}
	sc.close();
	}

}
