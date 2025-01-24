package com.javafundamentalAssignment5.app;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class EmployeeAgeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Enter employee's date of birth: ");
        String dobInput = input.nextLine().trim(); 

        try {
            LocalDate dateOfBirth = LocalDate.parse(dobInput, dateFormatter);

            LocalDate currentDate = LocalDate.now();
            if (dateOfBirth.isAfter(currentDate)) {
                System.out.println("Date of birth cannot be in the future.");
                return;
            }

            Period age = Period.between(dateOfBirth, currentDate);

            System.out.println("Exact Age:");
            System.out.println(age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days.");

            if (dateOfBirth.getMonthValue() == 2 && dateOfBirth.getDayOfMonth() == 29) {
                System.out.println("Note: This employee was born on a leap day!");
            }

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
        }

        input.close();
    }
}
