package com.virtusa.exception;

public class ValidationException extends Exception{
	//#Exception class code if authentication of a user fails
	private String message;

	public ValidationException(String message) {
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
