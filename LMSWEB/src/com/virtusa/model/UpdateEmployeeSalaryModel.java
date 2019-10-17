package com.virtusa.model;

public class UpdateEmployeeSalaryModel {
	private int employeeId;
	private double newSalary;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public double getNewSalary() {
		return newSalary;
	}
	public void setNewSalary(double newSalary) {
		this.newSalary = newSalary;
	}
}
