package com.javafundamentalAssignment1.app;
import java.util.Scanner;
public class Count {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter number of heads:");
		int heads = input.nextInt();
		
		System.out.println("Enter number of legs:");
		int legs = input.nextInt();
		
		if(heads < 0 || legs < 0 || legs > heads * 4 || legs % 2 != 0) {
			System.out.println("Invalid Input");
            
		}else {
			int cows = (legs - 2 * heads) / 2;
            int men = heads - cows;
            
            if(cows < 0 || men < 0) {
            	System.out.println("Invalid Input");
            }else {
            	System.out.println("Number of cows: "+cows);
            	System.out.println("Number of mens: "+men);
            }
		}
		
		input.close();
	}

}
