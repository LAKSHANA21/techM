package com.javafundamentalAssignment1.app;
import java.util.Scanner;
public class NumberSeries {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter the first number");
	int first = input.nextInt();
	
	if(first <= 0) {
		System.out.println("Invalid Input");
		return;
	}
	
	System.out.println("Enter the second number");
	int second = input.nextInt();
	
	if(second <= 0 || first >= second) {
		System.out.println("Invalid Input");
		return;
	}
	
	System.out.println("Enter the number Series");
	int number_Series = input.nextInt();
	
	if(number_Series <= 0) {
		System.out.println("Invalid Input");
		return;
	}
	
	System.out.print(first+","+second);
	int previous1 = first, previous2 = second;
	
	for(int i = 0; i < number_Series; i++) {
		int numberOfTerms = previous1 * previous2;
		System.out.print(","+numberOfTerms);
		previous1 = previous2;
		previous2 = numberOfTerms;
	}
	
	input.close();
	}

}
