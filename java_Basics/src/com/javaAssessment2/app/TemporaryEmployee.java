package com.javaAssessment2.app;

class TemporaryEmployee extends Employee {
    private int hoursWorked; 
    private int hourlyWages;
    /**
     * 
     * @param employeeId
     * @param employeeName
     * @param hoursWorked
     * @param hourlyWages
     */
    public TemporaryEmployee(int employeeId, String employeeName, int hoursWorked, int hourlyWages) {
        super(employeeId, employeeName);
        this.hoursWorked = hoursWorked;
        this.hourlyWages = hourlyWages;
    }
    /**
     * 
     * @return
     */
    public int getHoursWorked() {
        return hoursWorked;
    }
    /**
     * 
     * @param hoursWorked
     */
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    /**
     * 
     * @return
     */
    public int getHourlyWages() {
        return hourlyWages;
    }
    /**
     * 
     * @param hourlyWages
     */
    public void setHourlyWages(int hourlyWages) {
        this.hourlyWages = hourlyWages;
    }

    @Override
    public void calculateSalary() {
        this.salary = hoursWorked * hourlyWages;
    }
}

