package com.javafundamentalAssignment5.app;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MeetingSchedular {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the meeting date and time: ");
        String dateTimeInput = input.nextLine();
        System.out.print("Enter the time zone of the meeting (e.g., Asia/Calcutta): ");
        String inputTimeZone = input.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeInput, formatter);
        ZoneId originalZone = ZoneId.of(inputTimeZone);
        ZonedDateTime originalMeetingTime = localDateTime.atZone(originalZone);

        System.out.println("\nOriginal Meeting Time:");
        System.out.println("In " + inputTimeZone + ": " + originalMeetingTime);

        String[] timeZones = {
            "Europe/London", 
            "Asia/Tokyo", 
            "Australia/Sydney", 
            "America/Los_Angeles", 
            "UTC"
        };

        System.out.println("\nMeeting Times in Other Time Zones:");
        for (String zone : timeZones) {
            ZoneId zoneId = ZoneId.of(zone);
            ZonedDateTime zonedTime = originalMeetingTime.withZoneSameInstant(zoneId);
            System.out.println("In " + zone + ": " + zonedTime.format(formatter) + " " + zone);
        }

        input.close();
    }
}

