 package com.javafundamentalAssignment5.app;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DeliveryDateValidator {
    private static final Set<LocalDate> holidays = new HashSet<>();
    static {
        holidays.add(LocalDate.of(2025, 1, 1)); 
        holidays.add(LocalDate.of(2025, 1, 26));
    }
    /**
     * 
     * @param deliveryDate
     * @param minDate
     * @param maxDate
     * @return
     */
    private static boolean isValidDeliveryDate(LocalDate deliveryDate, LocalDate minDate, LocalDate maxDate) {
        if (deliveryDate.isBefore(minDate) || deliveryDate.isAfter(maxDate)) {
            System.out.println("Error: The delivery date must be between " + minDate + " and " + maxDate + ".");
            return false;
        }

        DayOfWeek dayOfWeek = deliveryDate.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            System.out.println("Error: The delivery date cannot be a weekend.");
            return false;
        }

        if (holidays.contains(deliveryDate)) {
            System.out.println("Error: The delivery date cannot be a holiday.");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
    	 
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate minDate = LocalDate.now().plusDays(1); 
        LocalDate maxDate = LocalDate.now().plusWeeks(2); 
                   
        System.out.println("Delivery Date Validator");
        System.out.println("Select a delivery date between " + minDate + " and " + maxDate + ".");

        System.out.print("Enter your desired delivery date: ");
        String inputDate = input.nextLine().trim();

        try {
            LocalDate deliveryDate = LocalDate.parse(inputDate, formatter);
            if (isValidDeliveryDate(deliveryDate, minDate, maxDate)) {
                System.out.println("The delivery date " + deliveryDate + " is valid.");
            } else {
                System.out.println("The delivery date " + deliveryDate + " is invalid.");
            }

        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }
        
        input.close();
    }
}

