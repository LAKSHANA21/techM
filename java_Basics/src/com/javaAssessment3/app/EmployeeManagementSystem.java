package com.javaAssessment3.app;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.*;

class Employee {
    private String id;
    private String name;
    private String department;
    private double salary;
    private LocalDate joiningDate;
    /**
     * 
     * @return
     */
    public String getId() {
        return id;
    }
    /**
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
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
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
     * @return
     */
    public String getDepartment() {
        return department;
    }
    /**
     * 
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }
    /**
     * 
     * @return
     */
    public double getSalary() {
        return salary;
    }
    /**
     * 
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
    /**
     * 
     * @return
     */
    public LocalDate getJoiningDate() {
        return joiningDate;
    }
    /**
     * 
     * @param joiningDate
     */
    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }
    /**
     * 
     * @param id
     * @param name
     * @param department
     * @param salary
     * @param joiningDate
     */
    Employee(String id, String name, String department, double salary, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }
    
    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Department='" + department + '\'' +
                ", Salary=" + salary +
                ", JoiningDate=" + joiningDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +
                '}';
    }
}

public class EmployeeManagementSystem {

    public static void main(String[] args) {
        List<Employee> detail = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("Enter number of employees");
        int noOfEmployees = input.nextInt();
        input.nextLine(); // Consume the newline left by nextInt()

        for (int i = 0; i < noOfEmployees; i++) {
            System.out.printf("Details of the Employee %d%n", i + 1);
            System.out.print("ID: ");
            String id = input.nextLine();
            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("Department: ");
            String department = input.nextLine();
            System.out.print("Salary: ");
            double salary = input.nextDouble();
            input.nextLine(); // Consume the newline left by nextDouble()
            System.out.print("Joining Date (dd-MM-yyyy): ");
            String date = input.nextLine();
            LocalDate joiningDate = LocalDate.parse(date, dateFormatter);
            System.out.println();

            detail.add(new Employee(id, name, department, salary, joiningDate));
        }

        System.out.println("Employees with work anniversary this month:");
        Month current = LocalDate.now().getMonth();

        detail.stream()
                .filter(emp -> emp.getJoiningDate().getMonth() == current)
                .forEach(System.out::println);

        System.out.println("\nNumber of employees in each department:");
        Map<String, Long> count = detail.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        count.forEach((dept, cnt) -> System.out.println(dept + ": " + cnt));

        input.close();
    }
}
