package com.javapractices.app;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class DateAndTime {
	public static void main(String[] args) {
	LocalDate date = LocalDate.now();
	System.out.println(date);	
	LocalTime time = LocalTime.now();
	System.out.println(time);	
	LocalDate date1 = LocalDate.of(2025, 01, 10);
	System.out.println(date1);
	DateTimeFormatter date2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String format = date.format(date2);
    System.out.println(format); 
	}
}
