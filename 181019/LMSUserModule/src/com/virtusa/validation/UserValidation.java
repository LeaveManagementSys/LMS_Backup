package com.virtusa.validation;

import java.util.ArrayList;
import java.util.List;

public class UserValidation {
	
	 public boolean validatePassword(String password) {
	    	
	    	boolean result=false;
			char chars[]=password.toCharArray();
			List<Character> alphabets=new ArrayList<>();
			for(int i=64;i<=122;i++) {
				alphabets.add((char)i);
			}		
			for(char ch:chars) {
				if(alphabets.contains(ch)) {
					result=true;
				}else {
					return false;
				}
			}
			return result;
	    	/*Pattern p=Pattern.compile("[A-Za-z0-9@*]");
	    	boolean result=p.matcher(password).matches();
	    	return result;\*/   	
	    }
	    
	    public boolean validNumber(int number) {
			boolean result=false;
			String data=String.valueOf(number);
			if(data.matches(".*[0-9]")) {
				result=true;
			}
			return result;
		}

}
