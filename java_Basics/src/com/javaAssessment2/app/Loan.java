package com.javaAssessment2.app;

class Loan{
	/**
	 * 
	 * @param employee
	 * @return
	 */
    public double calculateLoanAmount(Employee employee) {
        if (employee instanceof PermanentEmployee) {
            return employee.getSalary() * 0.15;
        }else if (employee instanceof TemporaryEmployee) {
            return employee.getSalary() * 0.10;
        }
        return 0;
    }
}

