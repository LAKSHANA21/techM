package com.javapractices.app;
import java.util.Scanner;
public class ExceptionHandling {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int numerator=sc.nextInt();
	int denominator=sc.nextInt();
	
	try {
		int c=numerator/denominator;
		System.out.println(c);
		
	}catch(ArithmeticException e) {
		System.out.println("Cannot be divided by 0");
	}
	
	sc.close();
	}

}
