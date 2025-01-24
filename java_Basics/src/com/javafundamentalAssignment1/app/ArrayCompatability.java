package com.javafundamentalAssignment1.app;

import java.util.Scanner;

public class ArrayCompatability {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter the size of the Array");
	int n = input.nextInt();
	
	if(n <= 0) {
		System.out.println("Invail Input");
		return;
	}
	
	System.out.println("Enter the elements of the Array1");
	
	int arr1[] = new int[n];
	
	for(int i = 0; i < n; i++) {
		arr1[i] = input.nextInt();
	}
	
	System.out.println("Enter the elements of the Array2");
	
	int arr2[] = new int[n];
	
	for(int i = 0; i < n; i++) {
		arr2[i] = input.nextInt();
	}
	
	boolean Compatable = true;
	
	for(int i = 0; i < n; i++) {
		if(arr1[i] < arr2[i]) {
			Compatable = false;
			break;
		}
	}
	
	if(Compatable) {
		System.out.println("Array is compatable");
	}else {
		System.out.println("Array is not compatable");
	}
	
	input.close();
	}

}
