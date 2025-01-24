package com.javafundamentalAssignment5.app;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class SubscriptionService {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Enter subscription start date: ");
        String startDateInput = input.nextLine();

        System.out.print("Enter subscription duration: ");
        String durationInput = input.nextLine();

        try {
            LocalDate startDate = LocalDate.parse(startDateInput, dateFormatter);

            Period duration = Period.parse(durationInput);

            LocalDate expiryDate = startDate.plus(duration);

            System.out.println("Subscription Start Date: " + startDate.format(dateFormatter));
            System.out.println("Subscription Expiry Date: " + expiryDate.format(dateFormatter));

            long days = ChronoUnit.DAYS.between(startDate, expiryDate);
            long months = ChronoUnit.MONTHS.between(startDate, expiryDate);
            long years = ChronoUnit.YEARS.between(startDate, expiryDate);

            System.out.println("Duration in days: " + days);
            System.out.println("Duration in months: " + months);
            System.out.println("Duration in years: " + years);

        } catch (Exception e) {
            System.out.println("Invalid input. Please check the date or duration format.");
        }

        input.close();
    }
}

