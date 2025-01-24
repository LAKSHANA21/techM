package com.javafundamentalAssignment1.app;

import java.util.Scanner;

public class GiftsDistribution {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter the number of boxes sold by Sara");
	int noOfBoxes_Sara = input.nextInt();
	
	System.out.println("Enter the number of boxes sold by Harry");
	int noOfBoxes_Harry = input.nextInt();
	
	System.out.println("Enter the number of boxes sold by Leo");
	int noOfBoxes_Leo = input.nextInt();
	
	System.out.println("Enter the number of boxes sold by James");
	int noOfBoxes_James = input.nextInt();
	
	if(noOfBoxes_Sara == noOfBoxes_Harry && noOfBoxes_Harry == noOfBoxes_Leo && noOfBoxes_Leo == noOfBoxes_James) {
		System.out.println("Everyone receives the gifts");
		return;
	}
	
	int maximum = Math.max(Math.max(noOfBoxes_Sara, noOfBoxes_Harry), Math.max(noOfBoxes_Leo, noOfBoxes_James));
	
	System.out.println("Individual Gifts");
	
	if(noOfBoxes_Sara == maximum) {
		System.out.print("Sara receives the gifts");
	}if(noOfBoxes_Harry == maximum) {
		System.out.print("Harry receives the gifts");
	}if(noOfBoxes_Leo == maximum) {
		System.out.print("Leo receives the gifts");
	}if(noOfBoxes_James == maximum) {
		System.out.print("James receives the gifts");
	}
	
	System.out.println();
	input.close();
	}

}
