package com.javaAssessment2.app;

public class EmployeeManagementSystem {
    public static void main(String[] args) {

        PermanentEmployee permanentEmployee = new PermanentEmployee(32, "Lakshu", 50000);
        permanentEmployee.calculateSalary();
        System.out.println("Permanent Employee Salary: " + permanentEmployee.getSalary());

        TemporaryEmployee temporaryEmployee = new TemporaryEmployee(04, "Amritha", 160, 200);
        temporaryEmployee.calculateSalary();
        System.out.println("Temporary Employee Salary: " + temporaryEmployee.getSalary());

        Loan loan = new Loan();
        double permanentLoan = loan.calculateLoanAmount(permanentEmployee);
        double temporaryLoan = loan.calculateLoanAmount(temporaryEmployee);

        System.out.println("Loan Amount for Permanent Employee: " + permanentLoan);
        System.out.println("Loan Amount for Temporary Employee: " + temporaryLoan);
    }
}
