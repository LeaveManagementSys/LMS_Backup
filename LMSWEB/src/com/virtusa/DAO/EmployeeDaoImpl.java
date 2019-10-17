package com.virtusa.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.entities.Employee;
import com.virtusa.entities.Jobs;
import com.virtusa.integrate.ConnectionManager;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public boolean storeEmployeeDetails(Employee employee) throws ClassNotFoundException, SQLException {
		
		Connection connection=ConnectionManager.openConnection();
		
		PreparedStatement statement=
				connection.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?,?,?)");
		
		statement.setInt(1,employee.getEmployeeId());
		statement.setString(2,employee.getFirstName());
		statement.setString(3, employee.getLastName());
		statement.setString(4, employee.getEmail());
		statement.setString(5,employee.getPhoneNumber());
		LocalDate localDate=employee.getHireDate();
		java.sql.Date hireDate=new java.sql.Date(localDate.getYear(),localDate.getMonthValue(),localDate.getDayOfMonth());
		statement.setDate(6,hireDate);
		
		statement.setString(7, employee.getDesignation());
		statement.setDouble(8,employee.getSalary());
		LocalDate localDateDob=employee.getDateOfBirth();
		java.sql.Date dateOfBirth=new java.sql.Date(localDateDob.getYear(),localDateDob.getMonthValue(),localDateDob.getDayOfMonth());
		
		statement.setDate(9,dateOfBirth );
		statement.setString(10,employee.getJobLocation());
		
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		
		if(rows>0)
		{
			return true;
		}
			
		else
	
		return false;	
		// TODO Auto-generated method stub
	
	}

	@Override
	public boolean updateEmployeeSalary(Employee employee) throws ClassNotFoundException, SQLException {
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=
				connection.prepareStatement("update employees set salary=? where employee_id=?");
		statement.setDouble(1,employee.getSalary());
		statement.setInt(2, employee.getEmployeeId());
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		if(rows>0)
		{
			return true;
		}
		else
		return false;		
	}

	@Override
	public boolean deleteEmployeeDetails(Employee employee) throws ClassNotFoundException, SQLException {
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=
				connection.prepareStatement("delete from employees where employee_id=?");
		statement.setInt(1, employee.getEmployeeId());
		int rows=statement.executeUpdate();

		ConnectionManager.closeConnection();
		if(rows>0)
		{
			return true;
		}
		else
		{
			System.out.println(rows);
		    return false;	
		}
}

	@Override
	public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=
				statement.executeQuery("select * from employees");
		
		List<Employee> employeesList=new ArrayList<Employee>();
		while(resultSet.next()) {
			Employee employees=new Employee();
			employees.setEmployeeId(resultSet.getInt("employee_id"));
			employees.setFirstName(resultSet.getString("first_name"));
			employees.setLastName(resultSet.getString("last_name"));
			employees.setEmail(resultSet.getString("email"));
			employees.setPhoneNumber(resultSet.getString("phone_number"));
			java.sql.Date 
			hire_date=resultSet.getDate("hire_date");
			employees.setHireDate(hire_date.toLocalDate());
			employees.setDesignation(resultSet.getString("designation"));
			employees.setSalary(resultSet.getDouble("salary"));
			java.sql.Date 
			dateOfBirth=resultSet.getDate("date_of_birth");
			employees.setDateOfBirth(dateOfBirth.toLocalDate());
			employees.setJobLocation(resultSet.getString("job_location"));
			employeesList.add(employees);
		}
		ConnectionManager.closeConnection();
		return employeesList;
				
	}

	@Override
	public boolean updateEmployeePhoneNumber(Employee employee) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=
				connection.prepareStatement("update employees set phone_number=? where employee_id=?");
		statement.setString(1,employee.getPhoneNumber());
		statement.setInt(2,employee.getEmployeeId());
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		if(rows>0)
		{
			return true;
		}
		else
		return false;	
	}

	@Override
	public boolean updateEmployeeDesignation(Employee employee) throws ClassNotFoundException, SQLException {
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=
				connection.prepareStatement("update employees set designation=? where employee_id=?");
		statement.setString(1,employee.getDesignation());
		statement.setInt(2,employee.getEmployeeId());
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		boolean result=false;
		if(rows>0)
			result=true;
		return result;
		// TODO Auto-generated method stub
	}

	@Override
	public List<Jobs> getDesignation() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=
				statement.executeQuery("select job_title from jobs");
		List<Jobs> designationList=new ArrayList();
		while(resultSet.next()) {
			Jobs jobs=new Jobs();
			jobs.setDesignation(resultSet.getString("job_title"));
			designationList.add(jobs);			
		}
		ConnectionManager.closeConnection();
		return designationList ;
		
	}

	
}
