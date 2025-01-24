package com.javafundamentalAssignment7.app;
import java.util.*;
import java.util.stream.*;
class Employee{
	private String name;
	private String dptm;
	private double salary;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getDptm() {
		return dptm;
	}
	
	public void setDptm(String dptm) {
		this.dptm=dptm;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary=salary;
	}
	
	Employee(String name, String dptm, double salary){
		this.name=name;
		this.dptm=dptm;
		this.salary=salary;
	}
}

public class EmployeeManagementSystem {

	public static void main(String[] args) {
	List<Employee> details = new ArrayList<>();
	Scanner input = new Scanner(System.in);
	
	System.out.println("Enter the number of Employees");
	int noOfEmployees = input.nextInt();
	input.nextLine();
	
	for(int i=0;i<noOfEmployees;i++) {
		System.out.printf("Enter the details of the Employee %d\n",i+1);
		System.out.print("Name: ");
		String name = input.nextLine();
		System.out.print("Enter the department: ");
		String dptm = input.nextLine();
		System.out.print("Enter the salary: ");
		double salary = input.nextDouble();
		input.nextLine();
		
		details.add(new Employee(name,dptm,salary));
	}
	
	 List<Employee> details1 = details.stream()
             .filter(e -> e.getSalary() >= 50000)
             .collect(Collectors.toList());

     Map<String, Double> details2 = details1.stream()
             .collect(Collectors.groupingBy(Employee::getDptm, Collectors.summingDouble(Employee::getSalary)));

     Map.Entry<String, Double> details3 = details2.entrySet().stream()
             .max(Map.Entry.comparingByValue())
             .orElseThrow(() -> new NoSuchElementException("No department found"));

     System.out.printf("Department with the hi	ghest total salary: %s and %.2f\n",
             details3.getKey(), details3.getValue());

     input.close();
	}

}
