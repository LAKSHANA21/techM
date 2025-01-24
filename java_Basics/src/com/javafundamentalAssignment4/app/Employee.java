package com.javafundamentalAssignment4.app;

import java.util.Scanner;

class EmployeeDetails {
    private int empCode;
    private String name;
    private java.time.LocalDate dateOfBirth;
    private java.time.LocalDate dateOfAppointment;

    public EmployeeDetails() {}

    public EmployeeDetails(int empCode, String name, java.time.LocalDate dateOfBirth, java.time.LocalDate dateOfAppointment) {
        this.empCode = empCode;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAppointment = dateOfAppointment;
    }

    public int getYearsOfExperience() {
        return java.time.Period.between(dateOfAppointment, java.time.LocalDate.now()).getYears();
    }

    public void display() {
        System.out.println("Employee Code: " + empCode);
        System.out.println("Employee Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Date of Appointment: " + dateOfAppointment);
        System.out.println("Years of Experience: " + getYearsOfExperience());
    }
}

class InvalidEmpNumberException extends Exception {
    public InvalidEmpNumberException(String message) {
        super(message);
    }
}

class InvalidDateOfJoinException extends Exception {
    public InvalidDateOfJoinException(String message) {
        super(message);
    }
}

public class Employee {

    public static void validEmpcode(int emp_code) throws InvalidEmpNumberException {
        if (emp_code <= 0) {
            throw new InvalidEmpNumberException("Invalid Employee Code: Must be a positive number.");
        } else {
            System.out.println("Employee Code Validation Passed.");
        }
    }

    public static void validateDates(java.time.LocalDate dob, java.time.LocalDate doa) throws InvalidDateOfJoinException {
        if (dob.isAfter(doa)) {
            throw new InvalidDateOfJoinException("Date of Birth must be before the Date of Appointment.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {

            System.out.print("Enter Employee Code: ");
            int employee_code = input.nextInt();
            input.nextLine(); 
            
            System.out.print("Enter Employee Name: ");
            String employee_name = input.nextLine();

            System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
            java.time.LocalDate dob = java.time.LocalDate.parse(input.nextLine());

            System.out.print("Enter Date of Appointment (YYYY-MM-DD): ");
            java.time.LocalDate doa = java.time.LocalDate.parse(input.nextLine());

            validEmpcode(employee_code);

            validateDates(dob, doa);

            EmployeeDetails emp1 = new EmployeeDetails(employee_code, employee_name, dob, doa);
            System.out.println("\nEmployee Details:");
            emp1.display();

        } catch (InvalidEmpNumberException | InvalidDateOfJoinException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Invalid Input. Please check your entries.");
        } finally {
            input.close();
        }
    }
}
