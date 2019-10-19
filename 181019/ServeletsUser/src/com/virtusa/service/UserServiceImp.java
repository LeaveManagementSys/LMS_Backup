package com.virtusa.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.DAO.UserDao;
import com.virtusa.entities.User;
import com.virtusa.helper.UserData;
import com.virtusa.model.UserModel;

public class UserServiceImp implements UserService {
	
private UserDao userDAO=null;
	
	public UserServiceImp() {
		this.userDAO=UserData.createUserDAO();
	}
	@Override
	public String authenticateService(UserModel userModel) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String userType=null;
		boolean validateUser=
				userDAO.userVerification(userModel.getEmpId() ,userModel.getPassword());
		
		if(validateUser) {
			userType=userDAO.returnUserType(userModel.getEmpId() ,userModel.getPassword());	
		}
		return userType;
	}
	@Override
	public List<UserModel> getuserList() {
		
		List<UserModel> userModelList=new ArrayList();
		try {
			UserModel userModel=new UserModel();
			List<User> userslist=userDAO.getAllUsers();
			for(User users:userslist)
			{
			userModel.setEmpId(users.getEmpId());
			userModel.setPassword(users.getPassword());
			 userModelList.add(userModel);
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return userModelList;
	}
}
