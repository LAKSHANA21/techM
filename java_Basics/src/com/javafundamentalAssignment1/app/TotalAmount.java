package com.javafundamentalAssignment1.app;

import java.util.Scanner;

public class TotalAmount {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the type of product");
        char type_of_product = input.next().toUpperCase().charAt(0);
        
        System.out.println("Enter the number of units");
        int units = input.nextInt();

        if (units < 0) {
            System.out.println("Units cannot be negative");
        } else if (type_of_product == 'E' || type_of_product == 'I') {
            int totalAmount = 0;

            if (type_of_product == 'E') { 
                if (units >= 21) {
                    totalAmount = units * 850;
                } else if (units >= 11) {
                    totalAmount = units * 900;
                } else {
                    totalAmount = units * 950;
                }
            } else if (type_of_product == 'I') { 
                if (units >= 26) {
                    totalAmount = units * 975;
                } else if (units >= 16) {
                    totalAmount = units * 1000;
                } else {
                    totalAmount = units * 1100;
                }
            }

        System.out.println("Total Amount: " + totalAmount);
        } else {
            System.out.println("Invalid Input");
        }

        input.close();
    }
}
