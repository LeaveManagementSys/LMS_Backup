package com.virtusa.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.entities.User;
import com.virtusa.integrate.ConnectionManager;

public class UserDAOImp implements UserDao {
	
	public UserDAOImp() {
	
	}
	@Override
	public boolean userVerification(int empId, String password) throws ClassNotFoundException, SQLException {
		
		boolean result=false;
		//Connection connection=ConnectionManager.openConnection();
		Connection connection=ConnectionManager.openConnection();
		
		Statement statement=connection.createStatement();
		ResultSet resultSet=
				statement.executeQuery("select * from user_login");
		
		List<User> userList=new ArrayList<>();
		while(resultSet.next()) {
			User users=new User();
			users.setEmpId(resultSet.getInt("emp_id"));
			users.setPassword(resultSet.getString("password"));
			userList.add(users);
		}
		
		for(User users:userList)
		{
			/*System.out.print("userdata"+empId);
			System.out.println(" db"+users.getEmpId());
			System.out.print("userdata"+password);
			System.out.println(" db"+users.getPassword());*/
		if(empId==users.getEmpId()&&password.equalsIgnoreCase(users.getPassword()))
			{		
				result=true;
				break;
			}	
		}		
		ConnectionManager.closeConnection();	
		return result;	
}
	@Override
	public String returnUserType(int empId, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String returnUserType=null;
     Connection connection=ConnectionManager.openConnection();
		
		Statement statement=connection.createStatement();
		ResultSet resultSet=
				statement.executeQuery("select * from user_login");
		
		   List<User> userList=new ArrayList<>();
		   while(resultSet.next()) {
			User users=new User();
        	users.setEmpId(resultSet.getInt("emp_id"));
			users.setPassword(resultSet.getString("password"));
			users.setUserType(resultSet.getString("user_type"));
			userList.add(users);
		}
		
		for(User users:userList)
		{
			
		if(empId==users.getEmpId()&&password.equalsIgnoreCase(users.getPassword()))
			{
			
		     String	UserTypes =users.getUserType();
              switch(UserTypes) {
    		
			  case "EMPLOYEE":
			  {
				  returnUserType="EMPLOYEE";
				  break;					
			  }
				
			   case "MANAGER":
			   {
				   returnUserType="MANAGER";
				   break;
					
			   }
			 
			   case "HR":
			   {
					returnUserType="HR";
					break;					 
			   }			   
			}			
		}		
		ConnectionManager.closeConnection();
		
	}
		return returnUserType;		
	}
	@Override
	public List<User> getAllUsers()  throws ClassNotFoundException, SQLException {
		
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultset=statement.executeQuery("select * from user_login");
		
		List<User> usersList=new ArrayList<User>();
		while(resultset.next()) {
			User user=new User();
			user.setEmpId(resultset.getInt("emp_id"));
			user.setPassword(resultset.getString("password"));
			user.setUserType(resultset.getString("user_type"));
		}
		ConnectionManager.closeConnection();
		return usersList;
	}

}
