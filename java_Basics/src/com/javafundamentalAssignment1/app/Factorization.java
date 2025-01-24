package com.javafundamentalAssignment1.app;
import java.util.Scanner;
public class Factorization {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the number:");
		int num = input.nextInt();

		if(num == 0) {
			System.out.println("No Factors");
		}
		
		num = Math.abs(num);
		
		for(int i = 1; i <= num; i++) {
			if(num % i == 0) {
				System.out.print(i);
				if(i != num) {
					System.out.print(",");
				}
			}
					
		}
		
		input.close();

	}

}
