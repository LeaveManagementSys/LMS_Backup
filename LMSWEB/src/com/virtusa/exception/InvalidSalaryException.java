package com.virtusa.exception;

public class InvalidSalaryException extends Exception{
	String message;
	 public InvalidSalaryException(String message) {
		    super();
			this.message = message; 
	 }
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
