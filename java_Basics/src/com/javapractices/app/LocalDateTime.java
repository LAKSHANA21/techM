package com.javapractices.app;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.Month;

public class LocalDateTime {

	public static void main(String[] args) {

        LocalTime now = LocalTime.now();
        System.out.println("Current Time: " + now);

        LocalTime specificTime = LocalTime.of(14, 30);
        System.out.println("Specific Time: " + specificTime);

        LocalTime later = now.plusHours(2);
        System.out.println("2 Hours Later: " + later);
        
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);

        LocalDate specificDate = LocalDate.of(2025, 1, 3);
        System.out.println("Specific Date: " + specificDate);

        LocalDate tomorrow = today.plusDays(1);
        System.out.println("Tomorrow: " + tomorrow);

        LocalDate yesterday = today.minusDays(1);
        System.out.println("Yesterday: " + yesterday);
        
        int year = today.getYear();
        System.out.println(year);
        
        Month month = today.getMonth();
        System.out.println(month);
        
    }
 
}
