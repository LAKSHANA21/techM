package com.javafundamentalAssignment1.app;

import java.util.Scanner;

public class MaxDifference

{
	public static void main(String[] args) 

	{

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the size of arrays : ");

		int size = input.nextInt();

		if (size < 3) 

			System.out.println("Invalid size.");
		
		else

		{

			int array[] = new int[size];

			System.out.println("Enter the array elements : ");

			for (int i = 0; i < size; i++) {

				array[i] = input.nextInt();

			}

			int maxDiff = 0;

			int index1 = 0, index2 = 0;

			for (int i = 0; i < size - 2; i++) 

			{
				int diff = Math.abs(array[i] - array[i + 2]);

				if(diff > maxDiff) {
					maxDiff = diff;
					index1 = i;
					index2 = i + 2;
				}

			}
			System.out.println("Pair that has maximum absolute values : " + array[index1] + " , " + array[index2]);

		}

			input.close();

	}

}

