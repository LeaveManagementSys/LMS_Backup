package com.virtusa.DAO;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.entities.User;

public interface UserDao {
	
	 boolean userVerification(int empId,String password) throws ClassNotFoundException, SQLException;
	 //verifies the user is present are not
     String returnUserType(int empId,String password) throws ClassNotFoundException, SQLException;
     //by verifying user returns user type
     
     List<User> getAllUsers() throws ClassNotFoundException, SQLException;
}
