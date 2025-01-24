package com.javaAssessment1.app;

import java.util.Scanner;

public class SumsOfSequences {
	
	public static int[] sequenceSum(int size, int[] arr1) {
		
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		
		for(int i = 0; i < size; i++) {
			if(i % 3 == 0) {
				sum1 += arr1[i];
			}else if(i % 3 == 1) {
				sum2 += arr1[i];
			}else {
				sum3 += arr1[i];
			}
		}
		
		return new int[] {sum1,sum2,sum3};

	}

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter the numberm of values: ");
	int n = input.nextInt();
	
	int[] arr = new int[n];
	System.out.println("Enter the sequences of values: ");
	for(int i = 0; i < n; i++) {
		arr[i]=input.nextInt();
	}
	
	int[] result = sequenceSum(n,arr);
    System.out.println(result[0]+" "+result[1]+" "+result[2]);
	
    input.close();
	}

}
