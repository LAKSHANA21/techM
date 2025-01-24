package com.javafundamentalAssignment5.app;

import java.time.*;

class UsageTracker {
    private double dailyUsage;
    private double weeklyUsage;
    private double monthlyUsage;
    private double dailyLimit;
    private double weeklyLimit;
    private double monthlyLimit;
    
    private LocalDate lastDailyReset;
    private LocalDate lastWeeklyReset;
    private LocalDate lastMonthlyReset;
    
    public UsageTracker(double dailyLimit, double weeklyLimit, double monthlyLimit) {
        this.dailyLimit = dailyLimit;
        this.weeklyLimit = weeklyLimit;
        this.monthlyLimit = monthlyLimit;
        this.dailyUsage = 0;
        this.weeklyUsage = 0;
        this.monthlyUsage = 0;
        
        this.lastDailyReset = LocalDate.now();
        this.lastWeeklyReset = LocalDate.now().with(DayOfWeek.MONDAY);
        this.lastMonthlyReset = LocalDate.now().withDayOfMonth(1);
    }

    public void trackUsage(double dataUsageInMB) {
        LocalDate currentDate = LocalDate.now();

        if (!lastDailyReset.isEqual(currentDate)) {
            resetDailyUsage();
        }
        if (!lastWeeklyReset.isEqual(currentDate.with(DayOfWeek.MONDAY))) {
            resetWeeklyUsage();
        }
        if (!lastMonthlyReset.isEqual(currentDate.withDayOfMonth(1))) {
            resetMonthlyUsage();
        }

        dailyUsage += dataUsageInMB;
        weeklyUsage += dataUsageInMB;
        monthlyUsage += dataUsageInMB;
        checkAlerts();
    }

    private void checkAlerts() {
        if (dailyUsage > dailyLimit) {
            System.out.println("Alert: You have exceeded your daily data limit.");
        } else if (dailyUsage > dailyLimit * 0.8) {
            System.out.println("Alert: You are nearing your daily data limit.");
        }

        if (weeklyUsage > weeklyLimit) {
            System.out.println("Alert: You have exceeded your weekly data limit.");
        } else if (weeklyUsage > weeklyLimit * 0.8) {
            System.out.println("Alert: You are nearing your weekly data limit.");
        }

        if (monthlyUsage > monthlyLimit) {
            System.out.println("Alert: You have exceeded your monthly data limit.");
        } else if (monthlyUsage > monthlyLimit * 0.8) {
            System.out.println("Alert: You are nearing your monthly data limit.");
        }
    }

    public double getRemainingData() {
        double remainingDaily = dailyLimit - dailyUsage;
        double remainingWeekly = weeklyLimit - weeklyUsage;
        double remainingMonthly = monthlyLimit - monthlyUsage;

        System.out.println("Remaining Daily Data: " + remainingDaily + " MB");
        System.out.println("Remaining Weekly Data: " + remainingWeekly + " MB");
        System.out.println("Remaining Monthly Data: " + remainingMonthly + " MB");
        return remainingDaily + remainingWeekly + remainingMonthly;
    }

    private void resetDailyUsage() {
        dailyUsage = 0;
        lastDailyReset = LocalDate.now();
        System.out.println("Daily data usage has been reset.");
    }

    private void resetWeeklyUsage() {
        weeklyUsage = 0;
        lastWeeklyReset = LocalDate.now().with(DayOfWeek.MONDAY);
        System.out.println("Weekly data usage has been reset.");
    }

    private void resetMonthlyUsage() {
        monthlyUsage = 0;
        lastMonthlyReset = LocalDate.now().withDayOfMonth(1);
        System.out.println("Monthly data usage has been reset.");
    }
}

public class UsageTrackerApp {
    public static void main(String[] args) {
        UsageTracker tracker = new UsageTracker(500, 3500, 15000);
        tracker.trackUsage(100);
        tracker.trackUsage(50); 
        tracker.trackUsage(400); 
        tracker.getRemainingData();
    }
}

