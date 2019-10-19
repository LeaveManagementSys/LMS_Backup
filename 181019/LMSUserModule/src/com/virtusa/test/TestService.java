package com.virtusa.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Test;

import com.virtusa.DAO.UserDAOImp;
import com.virtusa.DAO.UserDao;
import com.virtusa.entities.User;
import com.virtusa.helper.UserData;
import com.virtusa.model.UserModel;
import com.virtusa.service.UserService;
import com.virtusa.service.UserServiceImp;

public class TestService {

	    @SuppressWarnings("unused")
	@Test
    public void testUserAuthenticationService_positive() throws ClassNotFoundException, SQLException {
    	
	   UserData userdata=new UserData();
	   UserService userService=userdata.createUserService();
     	int empId=101;
     	String password="PAVANI";
        UserModel userModel=new UserModel();
        userModel.setEmpId(empId);
        userModel.setPassword(password);
        try {
        	String expected=userService.authenticateService(userModel);
            System.out.println(expected);
            String actual="HR";
            assertEquals(expected,actual);            
        } catch (ClassNotFoundException e) {
            assertTrue(true);
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            assertTrue(true);
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
    @Test
    public void testUserAuthenticationService_negative() throws ClassNotFoundException, SQLException {
    	
    	UserData userdata=new UserData();
     	int empId=100;
     	String password="gayathri";
        UserModel userModel=new UserModel();
        userModel.setEmpId(empId);
        userModel.setPassword(password);
        UserService userService=userdata.createUserService();
        
        try {
        	String actual=userService.authenticateService(userModel);

            String expected="STUDENT";
            assertEquals(expected,actual);            
        } catch (ClassNotFoundException e) {
            assertTrue(true);
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            assertTrue(true);
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
