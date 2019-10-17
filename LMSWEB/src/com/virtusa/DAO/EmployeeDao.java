package com.virtusa.DAO;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.entities.Employee;
import com.virtusa.entities.Jobs;

public interface EmployeeDao {

	 List<Employee> getAllEmployees()throws ClassNotFoundException, SQLException;
	 List<Jobs> getDesignation()throws ClassNotFoundException, SQLException;
	 boolean storeEmployeeDetails(Employee employee)throws ClassNotFoundException, SQLException;
     boolean updateEmployeeSalary(Employee employee)throws ClassNotFoundException, SQLException;
	 boolean deleteEmployeeDetails(Employee employee)throws ClassNotFoundException, SQLException;
	 boolean updateEmployeePhoneNumber(Employee employee)throws ClassNotFoundException, SQLException;
	 boolean updateEmployeeDesignation(Employee employee)throws ClassNotFoundException, SQLException;

}
