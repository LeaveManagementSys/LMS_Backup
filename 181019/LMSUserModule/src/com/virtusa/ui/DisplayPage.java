package com.virtusa.ui;

import java.util.Scanner;

import com.virtusa.controller.UserLoginController;
import com.virtusa.exception.UserException;
import com.virtusa.model.UserModel;
import com.virtusa.validation.UserValidation;

public class DisplayPage {
public static void main(String[] args) {
		
		DisplayPage displaypage=new DisplayPage();
		 displaypage.userView();
	}
	
	public void userView()
	{
		
		try(Scanner scanner=new Scanner(System.in);){           
			 UserValidation uservalidation=new UserValidation(); 
			 System.out.println("LeaveManagementSystem");
			 System.out.println("------------------------------");
           int empId=0;    
           System.out.print("Employee Id:");
           if(scanner.hasNextInt())
           {
           	empId=scanner.nextInt();
           }
           else
           {
               try {
            	   
               throw new UserException("[!ERROR:Invalid EmpId]");
               }catch(UserException e) {
                   System.out.println(e.getMessage());
                   userView();
               } 
           }//authenticates type of id should be entered
           
           System.out.print("Password:");
           String password=scanner.next();            
           boolean validpassword=uservalidation.validatePassword(password);
           System.out.println(validpassword);
           if(!validpassword)
               try {
               throw new UserException("Password cannot not include numbers");
               }catch(UserException e) {
                   System.out.println(e.getMessage());
                   userView();
               } 
           
           UserModel usermodel=new UserModel();
           usermodel.setEmpId(empId);
           usermodel.setPassword(password);
           UserLoginController userlogincontroller=new  UserLoginController();
           userlogincontroller.userVerification(usermodel);
          
       }catch(Exception e)
       {
    	   e.printStackTrace();
       	System.out.println("Invalid login credentials");
       	
       }	
   }//authenticates type of password should be entered

}
