package com.javafundamentalAssignment1.app;

import java.util.Scanner;

public class AgeCounter {
	
	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);

	        int count = 0;
	        int sum = 0;

	        System.out.println("Enter the ages:");
	        
	        while (true) {
	            int age = input.nextInt();

	            if (age < 28 || age > 40) {
	                System.out.println("Age out of range");
	                break;
	            }

	            sum += age;
	            count++;
	        }

	        if (count < 2) {
	            System.out.println("Insufficient data. 2 employees are required");
	        } else {
	            float averageAge = (float) sum / count;
	            System.out.println("Average age of employees in the range 28-40: " + averageAge);
	        }
	        
	        input.close();
	    }
	}



