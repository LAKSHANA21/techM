package com.javaAssessment2.app;

abstract class Employee{	
    protected int employeeId;
    protected String employeeName; 
    protected double salary;
    /**
     * 
     * @param employeeId
     * @param employeeName
     */
    public Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }
    /**
     * 
     * @return
     */
    public int getEmployeeId() {
        return employeeId;
    }
    /**
     * 
     * @param employeeId
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    /**
     * 
     * @return
     */
    public String getEmployeeName() {
        return employeeName;
    }
    /**
     * 
     * @param employeeName
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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
     * abstract method to extend by other classes
     */
    public abstract void calculateSalary();
}
