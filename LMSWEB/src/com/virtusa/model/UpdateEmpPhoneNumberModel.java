package com.virtusa.model;

public class UpdateEmpPhoneNumberModel {
	private int employeeId;
	private String newphoneNumber;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getNewphoneNumber() {
		return newphoneNumber;
	}
	public void setNewphoneNumber(String newphoneNumber) {
		this.newphoneNumber = newphoneNumber;
	}
	@Override
	public String toString() {
		return "UpdateEmpPhoneNumberModel [employeeId=" + employeeId + ", newphoneNumber=" + newphoneNumber + "]";
	}
}
