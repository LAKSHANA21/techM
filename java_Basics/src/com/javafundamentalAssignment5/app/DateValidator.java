package com.javafundamentalAssignment5.app;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateValidator{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        DateTimeFormatter[] acceptedFormats = {
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
            DateTimeFormatter.ofPattern("MM-dd-yyyy"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd")
        };
                                                                                                            
        DateTimeFormatter standardFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.print("Enter a date: ");

        String inputDate = input.nextLine();
        LocalDate parsedDate = null;

        for (DateTimeFormatter formatter : acceptedFormats) {
            try {
                parsedDate = LocalDate.parse(inputDate, formatter);
                break;
            } catch (DateTimeParseException e) {   
            }
        }
        
        if (parsedDate != null){
            String formattedDate = parsedDate.format(standardFormat);
            System.out.println("Valid date. Standardized format: " + formattedDate);
        } else {
            System.out.println("Invalid date format. Please try again.");
        }
        
        input.close();
    }
}

