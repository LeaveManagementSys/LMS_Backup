package com.virtusa.helper;

import com.virtusa.DAO.UserDAOImp;
import com.virtusa.DAO.UserDao;
import com.virtusa.service.UserService;
import com.virtusa.service.UserServiceImp;

public class UserData {
	public static UserDao createUserDAO() {
		UserDao userDAO=new UserDAOImp();
		return userDAO;
	}
	//returns helper class object of DAO class
	public static UserService createUserService() {
		UserService userService=new UserServiceImp();
		return userService;
	}
	//returns helper class object of service class
}
