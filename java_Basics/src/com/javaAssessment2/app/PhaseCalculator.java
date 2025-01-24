package com.javaAssessment2.app;

import java.util.Scanner;
/**
 * The Associate class represents an employee with attributes
 * such as ID, name, and work status. It includes methods to
 * set and get these attributes and track the associate's
 * status based on the number of days worked.
 */
class Associate {

    private int associateId;        // ID of the associate
    private String associateName;   // Name of the associate
    private String workStatus;      // Current work status of the associate

    /**
     * Gets the associate ID.
     *
     * @return the ID of the associate
     */
    public int getAssociateId() {
        return associateId;
    }

    /**
     * Sets the associate ID.
     *
     * @param associateId the ID to set for the associate
     */
    public void setAssociateId(int associateId) {
        this.associateId = associateId;
    }

    /**
     * Gets the associate's name.
     *
     * @return the name of the associate
     */
    public String getAssociateName() {
        return associateName;
    }

    /**
     * Sets the associate's name.
     *
     * @param associateName the name to set for the associate
     */
    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }

    /**
     * Gets the work status of the associate.
     *
     * @return the current work status
     */
    public String getWorkStatus() {
        return workStatus;
    }

    /**
     * Sets the work status of the associate.
     *
     * @param workStatus the work status to set
     */
    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    /**
     * Default constructor initializes an associate
     * with default values for ID, name, and work status.
     */
    Associate() {
        this.associateId = 0;
        this.associateName = "";
        this.workStatus = "";
    }

    /**
     * Tracks and updates the work status of the associate
     * based on the number of days worked.
     *
     * @param noOfDays the number of days the associate has worked
     */
    public void trackAssociateStatus(int noOfDays) {
        if (noOfDays > 0 && noOfDays <= 20) {
            this.workStatus = "Core Skills";
        } else if (noOfDays > 20 && noOfDays <= 40) {
            this.workStatus = "Advanced Modules";
        } else if (noOfDays > 40 && noOfDays <= 60) {
            this.workStatus = "Project Phase";
        } else if (noOfDays > 60) {
            this.workStatus = "Deployed in Project";
        } else {
            this.workStatus = "Invalid data";
        }
    }
}

/**
 * The PhaseCalculator class serves as the main class to run the program.
 * It creates an Associate object, accepts input for the number of days worked,
 * and displays the associate's details and current work status.
 */
public class PhaseCalculator {

    /**
     * The main method serves as the entry point of the program.
     * It accepts the number of days worked, updates the associate's
     * status, and displays their details.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user for input
        System.out.println("Enter number of days:");
        int numberOfDays = input.nextInt();

        // Create and initialize an Associate object
        Associate associate = new Associate();
        associate.setAssociateId(32);
        associate.setAssociateName("Lakshu");

        // Update the associate's work status
        associate.trackAssociateStatus(numberOfDays);

        // Display associate details
        System.out.println("Associate ID: " + associate.getAssociateId());
        System.out.println("Associate Name: " + associate.getAssociateName());
        System.out.println("Associate WorkStatus: " + associate.getWorkStatus());

        input.close(); // Close the scanner to release resources
    }
}
