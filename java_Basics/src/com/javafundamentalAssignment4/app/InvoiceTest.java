package com.javafundamentalAssignment4.app;

import java.util.Scanner;

class Invoice {
    private int partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;
    
    	public Invoice(int partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void displayInvoice() {
        System.out.println("\n--- Invoice Details ---");
        System.out.println("Part Number: " + partNumber);
        System.out.println("Part Description: " + partDescription);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price Per Item: $" + pricePerItem);
        System.out.println("Total Cost: $" + (quantity * pricePerItem));
    }
}

public class InvoiceTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Part Number: ");
            int partNumber = scanner.nextInt();
            if (partNumber <= 0) {
                throw new IllegalArgumentException("Part number must be greater than 0.");
            }

            scanner.nextLine();

            System.out.print("Enter Part Description: ");
            String partDescription = scanner.nextLine();
            if (partDescription == null || partDescription.trim().isEmpty()) {
                throw new IllegalArgumentException("Part description cannot be null or empty.");
            }

            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than 0.");
            }

            System.out.print("Enter Price Per Item: ");
            double pricePerItem = scanner.nextDouble();
            if (pricePerItem <= 0) {
                throw new IllegalArgumentException("Price per item must be greater than 0.");
            }

            Invoice invoice = new Invoice(partNumber, partDescription, quantity, pricePerItem);

            invoice.displayInvoice();

        } catch (IllegalArgumentException e) {
            System.err.println("Validation Error: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.err.println("Input Error: Please enter valid data types for the inputs.");
        } finally {
            scanner.close();
        }
    }
}

