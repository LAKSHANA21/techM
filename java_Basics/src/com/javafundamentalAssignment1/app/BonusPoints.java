package com.javafundamentalAssignment1.app;
import java.util.Scanner;

public class BonusPoints {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the distance:");
		int distance = input.nextInt();
		
		if(distance < 0) {
			System.out.println("Error");
		}else if(distance == 0) {
			System.out.println("The bonus point is 0");
		}else {
			int odd_product = 1;
			int even_product = 1;
			int position = 1;
			
			while(distance > 0) {
				int digit = distance % 10;
				if(position % 2 == 0) {
					even_product *= digit;
				}else {
					odd_product *= digit;
				}
				distance /= 10;
				position++;
			}
	
			int bonus_points;
			
			if(even_product == odd_product) {
				bonus_points = 2 * even_product;
			}else if(even_product > odd_product) {
				bonus_points = even_product;
			}else {
				bonus_points = odd_product;
			}
			
			System.out.println("Bonus points: "+bonus_points);
			input.close();
		}
	}
}
