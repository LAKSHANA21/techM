package com.javafundamentalAssignment5.app;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Event {
	
    private String name;
    private ZonedDateTime startTime;
    private Period recurrencePeriod;
    /**
     * 
     * @param name
     * @param startTime
     * @param recurrencePeriod
     */
    public Event(String name, ZonedDateTime startTime, Period recurrencePeriod) {
        this.name = name;
        this.startTime = startTime;
        this.recurrencePeriod = recurrencePeriod;
    }
    /**
     * 
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * 
     * @return
     */
    public ZonedDateTime getStartTime() {
        return startTime;
    }
    /**
     * 
     * @return
     */
    public Period getRecurrencePeriod() {
        return recurrencePeriod;
    }
 
    public void updateStartTime() {
        if (!recurrencePeriod.isZero()) {
            this.startTime = this.startTime.plus(recurrencePeriod);
        }
    }

    @Override
    public String toString() {
        return "Event{name='" + name + "', startTime=" + startTime + ", recurrencePeriod=" + recurrencePeriod + "}";
    }
}

class Scheduler {
    private List<Event> events = new ArrayList<>();
    /**
     * 
     * @param name
     * @param startTime
     * @param timeZone
     * @param recurrencePeriod
     */
    public void addEvent(String name, String startTime, String timeZone, Period recurrencePeriod) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(startTime, formatter);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(timeZone));
        events.add(new Event(name, zonedDateTime, recurrencePeriod));
    }

    public void listAllEvents() {
        System.out.println("All Events:");
        for (Event event : events) {
            System.out.println(event);
        }
    }
    /**
     * 
     * @param localTimeZone
     */
    public void notifyUpcomingEvents(String localTimeZone) {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(localTimeZone));
        System.out.println("Notifications for upcoming events:");

        boolean hasUpcomingEvents = false;

        for (Event event : events) {
            while (event.getStartTime().isBefore(now) && !event.getRecurrencePeriod().isZero()) {
                event.updateStartTime();
            }

            ZonedDateTime eventTime = event.getStartTime();
            if (eventTime.isAfter(now)) {
                hasUpcomingEvents = true;
                Duration duration = Duration.between(now, eventTime);
                long hours = duration.toHours();
                System.out.println("Event: " + event.getName() +
                        " is scheduled at " + eventTime +
                        " (in " + hours + " hours)");
            }
        }

        if (!hasUpcomingEvents) {
            System.out.println("No upcoming events found.");
        }
    }

}

public class SchedulerApp {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        scheduler.addEvent("Team Meeting", "2025-01-03 10:00", "America/New_York", Period.ofDays(7));
        scheduler.addEvent("Code Review", "2025-01-04 14:00", "Europe/London", Period.ofMonths(1));
        scheduler.addEvent("Project Deadline", "2025-01-02 23:59", "Asia/Kolkata", Period.ofDays(0));
        scheduler.listAllEvents();
        scheduler.notifyUpcomingEvents("America/New_York");
    }
}
 