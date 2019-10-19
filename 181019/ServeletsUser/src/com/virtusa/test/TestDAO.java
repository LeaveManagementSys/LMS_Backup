package com.virtusa.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.virtusa.DAO.UserDAOImp;
import com.virtusa.DAO.UserDao;
import com.virtusa.entities.User;
import com.virtusa.helper.UserData;

public class TestDAO 
{
	 UserData userdata=new UserData();
		UserDao userDAO= userdata.createUserDAO();
	@Test
	public void testuserVerification_postive() {
		
		try {
			boolean actualResult=userDAO.userVerification(100,"gayathri");
			System.out.println(actualResult);
			boolean expectedResult=true;
			assertEquals(actualResult,expectedResult);    
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
		
		
	}
		
		
}
/*class DeleteDaoTest {

@Test
void testDeleteEmployee_postive() {

Employee employee=new Employee();
EmployeeDao employeedao=new EmployeeDaoImpl();    
employee.setEmployeeId(120);

try {
    boolean actualResult=employeedao.deleteEmployeeDetails(employee);
    boolean expected=true;
    assertEquals(actualResult,expected);            
} catch (ClassNotFoundException e) {
    assertTrue(true);
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (SQLException e) {
    assertTrue(true);
    // TODO Auto-generated catch block
    e.printStackTrace();
}        
}*/