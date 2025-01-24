package com.javaAssessment1.app;

import java.util.Scanner;

public class SalesDataReport {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter number of stores: ");
        int rows = input.nextInt();
        
        System.out.println("Enter number of products: ");
        int cols = input.nextInt();
        
        int[][] sales = new int[rows][cols];
        System.out.println("Enter the stores and products in matrix: ");
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sales[i][j] = input.nextInt();
            }
        }
        
        System.out.println("Total Sales for each store: ");
        int k = 1;
        for (int i = 0; i < sales.length; i++) {
            int sum1 = 0; 
            for (int sale : sales[i]) {
                sum1 += sale;
            }
            System.out.printf("Store%d -> %d%n", k, sum1);
            k++;
        }
        
        System.out.println("Total Sales for each product: ");
        int a = 1;
        for (int j = 0; j < sales[0].length; j++) {
            int sum2 = 0;
            for (int[] product : sales) {
                sum2 += product[j];
            }
            System.out.printf("Product%d -> %d%n", a, sum2);
            a++;
        }
        
        int sale_max = 0;
        int sale_index = -1;
        System.out.println("Store with highest sale: ");
        for (int i = 0; i < sales.length; i++) {
            int sum3 = 0; 
            for (int sale : sales[i]) {
                sum3 += sale;
            }
            if (sum3 > sale_max) {
                sale_max = sum3;
                sale_index = i;
            }
        }
        System.out.printf("Store%d -> %d%n", sale_index + 1, sale_max);
          
        int product_max = 0;
        int product_index = -1;
        System.out.println("Product with highest sale: ");
        for (int j = 0; j < sales[0].length; j++) {
            int sum4 = 0; 
            for (int[] product : sales) {
                sum4 += product[j];
            }
            if (sum4 > product_max) {
                product_max = sum4;
                product_index = j;
            }
        }
        System.out.printf("Product%d -> %d%n", product_index + 1, product_max);
        
        int b=1;
        System.out.println("Average sale for each store: ");
        for(int i =0;i<sales.length;i++) {
        	int sum5 =0;
        	for(int sale: sales[i]) {
        		sum5 += sale;
        	}
        	System.out.printf("Store%d ->",b);
        	System.out.println(sum5/sales[i].length);
        	b++;
        }
        
        int c=1;
        System.out.println("Average product sale for each store: ");
        for(int j =0; j<sales[0].length;j++) {
        	int sum6=0;
        	for(int[] product : sales) {
        		sum6 += product[j];
        	}
        	System.out.printf("Product%d ->",c);
        	System.out.println(sum6/sales[j].length);
        }
        input.close();
    }
}
