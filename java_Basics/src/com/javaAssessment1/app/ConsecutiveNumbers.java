package com.javaAssessment1.app;

import java.util.Scanner;

public class ConsecutiveNumbers{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of array : ");
		
		int size = scanner.nextInt();
		int[] array = new int[size];
		
		System.out.println("Enter the elements of array : ");
		
		for (int i = 0; i < size; i++)
		{
			array[i] = scanner.nextInt();
		}
		
		int totalSum = 0; int start = 0, end = 0;
		
		for (int i = 0; i < size; i++){
			for (int j = i+1; j < size; j++){
				if (array[i] + 1 == array[j]) {
					start = i; 
					end = j;
					break;
				}
			}
		}
		
		for (int i = 0; i < size; i++){
			if (i >= start && i <= end)
				continue;
			totalSum += array[i];
		}
		
		System.out.println("Total sum excluding the consecutive element : " + totalSum);
		scanner.close();
	}
}