package com.javafundamentalAssignment5.app;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

class RechargePlan {
    private String planName;
    private LocalDateTime activationTime;
    private LocalDateTime expiryTime;

    public RechargePlan(String planName, LocalDateTime activationTime, int validityDays) {
        this.planName = planName;
        this.activationTime = activationTime;
        this.expiryTime = activationTime.plusDays(validityDays);
    }

    public String getPlanName() {
        return planName;
    }

    public LocalDateTime getActivationTime() {
        return activationTime;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public long getRemainingDays(LocalDateTime now) {
        return ChronoUnit.DAYS.between(now, expiryTime);
    }

    public long getRemainingHours(LocalDateTime now) {
        return ChronoUnit.HOURS.between(now, expiryTime) % 24;
    }

    public long getRemainingMinutes(LocalDateTime now) {
        return ChronoUnit.MINUTES.between(now, expiryTime) % 60;
    }

    @Override
    public String toString() {
        return "Plan: " + planName +
                ", Activation: " + activationTime +
                ", Expiry: " + expiryTime;
    }
}

class PrepaidMobileApp {
    private List<RechargePlan> activePlans = new ArrayList<>();
    public void activatePlan(String planName, int validityDays) {
        LocalDateTime now = LocalDateTime.now();
        if (!activePlans.isEmpty()) {
            RechargePlan currentPlan = activePlans.get(activePlans.size() - 1);
            if (currentPlan.getExpiryTime().isAfter(now)) {
                System.out.println("Existing plan overlaps with the new plan. Adjusting expiry.");
                now = currentPlan.getExpiryTime();
            }
        }
        RechargePlan newPlan = new RechargePlan(planName, now, validityDays);
        activePlans.add(newPlan);
        System.out.println("Activated new plan: " + newPlan);
    }

    public void notifyExpiry() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("\nExpiry Notifications:");
        for (RechargePlan plan : activePlans) {
            long daysUntilExpiry = ChronoUnit.DAYS.between(now, plan.getExpiryTime());
            if (daysUntilExpiry == 3 || daysUntilExpiry == 1) {
                System.out.println("Plan '" + plan.getPlanName() + "' expires in " + daysUntilExpiry + " days.");
            }
        }
    }

    public void displayRemainingValidity() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("\nRemaining Validity for Active Plans:");
        for (RechargePlan plan : activePlans) {
            if (plan.getExpiryTime().isAfter(now)) {
                System.out.println("Plan: " + plan.getPlanName() + 
                    " - Remaining: " + plan.getRemainingDays(now) + " days, " + 
                    plan.getRemainingHours(now) + " hours, " + 
                    plan.getRemainingMinutes(now) + " minutes.");
            }
        }
    }
}

public class PrepaidMobileAppDemo {
    public static void main(String[] args) {
        PrepaidMobileApp app = new PrepaidMobileApp();
        app.activatePlan("Plan A", 7);
        app.activatePlan("Plan B", 10);
        app.notifyExpiry();
        app.displayRemainingValidity();
    }
}
