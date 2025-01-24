package com.javafundamentalAssignment1.app;

import java.util.Scanner;

public class TotalBill {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter number of pizzas");
		int no_of_pizzas = input.nextInt();
		
		System.out.println("Enter number of puffs");
		int no_of_puffs = input.nextInt();
		
		System.out.println("Enter number of cooldrinks");
		int no_of_coolDrinks = input.nextInt();
		
		int pizza_cost = 100 * no_of_pizzas;
		int puffs_cost = 20 * no_of_puffs;
		int coolDrinks_cost = 10 * no_of_coolDrinks;
		
		int total_cost = pizza_cost + puffs_cost + coolDrinks_cost;
		
		System.out.println("The number of pizzas purchased: "+no_of_pizzas);
		System.out.println("The number of puffs purchased: "+no_of_puffs);
		System.out.println("The number of coolDrinks purchased: "+no_of_coolDrinks);
		System.out.println("The total price is: "+total_cost);
		System.out.println("ENJOY THE SHOW!!!");
		
		input.close();
	}

}
