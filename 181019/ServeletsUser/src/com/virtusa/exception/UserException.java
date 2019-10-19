package com.virtusa.exception;

public class UserException extends Exception{

	
private String message;
	
	public UserException(String message) {
		// TODO Auto-generated constructor stub
		super();
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
