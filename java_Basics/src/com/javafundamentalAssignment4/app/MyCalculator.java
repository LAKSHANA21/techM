package com.javafundamentalAssignment4.app;

import java.util.Scanner;

class InvalidIOException extends Exception{
	public InvalidIOException(String message) {
		super(message);
	}
}

public class MyCalculator {
    public long power(int n, int p) throws InvalidIOException {
        if (n < 0 || p < 0) 
        { // Both should be <= 0 to throw the exception
            throw new InvalidIOException("n and p should not be negative");
        }if(n == 0 || p == 0) {
        	throw new InvalidIOException("n and p should not be zero");
        }
        return (long) Math.pow(n, p);
    }

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int num1 = input.nextInt();
	int num2 = input.nextInt();
	MyCalculator cal = new MyCalculator();
	try {
	System.out.println(cal.power(num1, num2));
	}
	catch(InvalidIOException e) {
		System.out.print(e);
	}
	input.close();
	}
	

}
