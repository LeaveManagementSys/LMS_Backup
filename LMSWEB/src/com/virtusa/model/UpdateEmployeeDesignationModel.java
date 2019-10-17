package com.virtusa.model;

public class UpdateEmployeeDesignationModel {
	private int employeeId;
	private String updateDesignation;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getUpdateDesignation() {
		return updateDesignation;
	}
	public void setUpdateDesignation(String updateDesignation) {
		this.updateDesignation = updateDesignation;
	}
	@Override
	public String toString() {
		return "UpdateEmployeeDesignationModel [employeeId=" + employeeId + ", updateDesignation=" + updateDesignation
				+ ", getEmployeeId()=" + getEmployeeId() + ", getUpdateDesignation()=" + getUpdateDesignation()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
