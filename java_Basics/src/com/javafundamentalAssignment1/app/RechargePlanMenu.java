package com.javafundamentalAssignment1.app;



import java.util.Scanner;



public class RechargePlanMenu 

{

	public static void main(String[] args) 

	{

		Scanner input = new Scanner(System.in);

		

		int balance = 300;

		

		// Available recharges plans

        int[] planNum = {1, 2, 3};

        String[] data = {"1.5GB/day", "2GB/day", "3GB/day"};

        int[] validity = {50, 84, 28};

        int[] costs = {199, 299, 399}; 

        

        System.out.println("Available Recharge Plans:");

        for (int i = 0; i < 3; i++) 

        {

            System.out.println("Plan Number: " + planNum[i] + ", Data: " + data[i] + ", Validity: " + validity[i] + " days, Cost: ₹" + costs[i]);

        }



        System.out.println("Choose the recharge plan : ");

        int plan = input.nextInt();



        if (plan < 1 || plan > planNum.length) 

            System.out.println("No such plan exists.");

        

        else

        {

        	if (balance >= costs[plan-1]) 

                System.out.println("Recharged successfully.");

            

    		else 

                System.out.println("Insufficient balance.");

        }

        input.close();

	}



}

