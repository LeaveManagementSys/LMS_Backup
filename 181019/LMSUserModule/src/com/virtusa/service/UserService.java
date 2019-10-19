package com.virtusa.service;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.entities.User;
import com.virtusa.model.UserModel;

public interface UserService {
	String authenticateService(UserModel userModel) throws ClassNotFoundException, SQLException;
	List<UserModel> getuserList() throws ClassNotFoundException, SQLException;
	
}//user model is passed here to authenticate the user

