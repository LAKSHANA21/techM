package com.javaAssessment2.app;

class PermanentEmployee extends Employee {
    private double basicPay; 
    /**
     * 
     * @param employeeId
     * @param employeeName
     * @param basicPay
     */
    public PermanentEmployee(int employeeId, String employeeName, double basicPay) {
        super(employeeId, employeeName);
        this.basicPay = basicPay;
    }
    /**
     * 
     * @return basicPay
     */
    public double getBasicPay() {
        return basicPay;
    }
    /**
     * 
     * @param basicPay
     */
    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    @Override
    public void calculateSalary() {
        double pfAmount = basicPay * 0.12;
        this.salary = basicPay - pfAmount;
    }
}