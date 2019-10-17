package com.virtusa.exception;

public class InvalidPhoneNumberExcept extends Exception {
    private String message;
	
	public  InvalidPhoneNumberExcept(String message)
	{
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
