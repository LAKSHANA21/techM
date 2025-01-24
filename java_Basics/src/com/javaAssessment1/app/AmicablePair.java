package com.javaAssessment1.app;

import java.util.Scanner;

public class AmicablePair {

	public static int properDivisors(int num) {
		int sum = 0;
		for(int i = 1; i < num; i++) {
			if( num % i == 0) {
				sum+=i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter the value of X: ");
	int x = input.nextInt();
	
	System.out.println("Enter the value of Y: ");
	int y = input.nextInt();
	
	int divisor_x=properDivisors(x);
	int divisor_y=properDivisors(y);
	
	if(divisor_x == y && divisor_y == x) {
		System.out.println("True");
	}
	else {
		System.out.println("False");
	}
	input.close();
}
}
