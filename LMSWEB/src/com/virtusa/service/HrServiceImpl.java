package com.virtusa.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.DAO.EmployeeDao;
import com.virtusa.entities.Employee;
import com.virtusa.entities.Jobs;
import com.virtusa.exception.InvalidSalaryException;
import com.virtusa.exception.NoEmployeeFoundException;
import com.virtusa.exception.ValidationException;
import com.virtusa.helper.FactoryHr;
import com.virtusa.model.InsertEmployeeModel;
import com.virtusa.model.RetriveEmployeeDesignationModel;
import com.virtusa.model.RetriveEmployeeModel;
import com.virtusa.model.UpdateEmpPhoneNumberModel;
import com.virtusa.model.UpdateEmployeeDesignationModel;
import com.virtusa.model.UpdateEmployeeSalaryModel;


public class HrServiceImpl implements HrService{
private EmployeeDao employeedao;
	
	public HrServiceImpl()
	{
		this.employeedao=FactoryHr.createEmployeeDao();
	}
	@Override
	public String employeeInsert(InsertEmployeeModel insertemployeemodel) {		
		Employee employee=new Employee();	
		List<RetriveEmployeeModel> employeesList= retrieveEmployees();
		boolean employeeFound=false;
		for(RetriveEmployeeModel retriveempmodel: employeesList) {
			System.out.println("test");
			if( retriveempmodel.getEmployeeId()==insertemployeemodel.getEmployeeId()) {
				employeeFound=true;
				break;
			}
		}	
		employee.setEmployeeId(insertemployeemodel.getEmployeeId());
		employee.setFirstName(insertemployeemodel.getFirstName());
		employee.setLastName(insertemployeemodel.getLastName());
		employee.setEmail(insertemployeemodel.getEmail());
		employee.setPhoneNumber(insertemployeemodel.getPhoneNumber());
		employee.setHireDate(insertemployeemodel.getHireDate());
		employee.setDateOfBirth(insertemployeemodel.getDateOfBirth());
		employee.setJobLocation(insertemployeemodel.getJobLocation());
		   
		String result="fail";
		if(!employeeFound) {
			double tempSalary=insertemployeemodel.getSalary();
			if(tempSalary>25000) {
				employee.setSalary(tempSalary);
			}else {
				try {
				throw new InvalidSalaryException("Salary not valid");
				}catch(InvalidSalaryException e) {
					System.out.println("!ERROR[Salary must be greater than 25000]");
				}
			}
		    boolean designationFound=false;
			List<RetriveEmployeeDesignationModel> jobsTitleList=retrieveDesignation();
			for(RetriveEmployeeDesignationModel retriveEmployeeModelDesignation:jobsTitleList ) {
				if(retriveEmployeeModelDesignation.getDesignation().equalsIgnoreCase(insertemployeemodel.getDesignation())){			
					designationFound=true;
					break;
				}
			}	
			if(designationFound)
			{
				employee.setDesignation(insertemployeemodel.getDesignation());
			}
			else
			{
				try {
					throw new ValidationException("Designation does not exists");
				}catch( ValidationException e)
				{
					System.out.println(e.getMessage());
				}
			}	
			
			try {
				boolean stored=employeedao.storeEmployeeDetails(employee);
				if(stored&&insertemployeemodel.getSalary()>25000&&designationFound)
					result="success";
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("!ERROR[Employee record deletion failed!!]");
			}	
			
		}
			else {
				try {
					throw new ValidationException("EmployeeId already exists");
				} catch ( ValidationException e) {
					// TODO Auto-generated catch block
					System.out.println("!ERROR[Employee with specified id exist!!]");
				}
			}
			return result;			
	}

	@Override
	public String salaryupdate(UpdateEmployeeSalaryModel updateempsalarymodel) {
		
		Employee employee=new Employee();
		List<RetriveEmployeeModel> employeesList= retrieveEmployees();
		boolean employeeFound=false;
		String result="fail";
		for(RetriveEmployeeModel retriveempmodel: employeesList) {
			int tempEmpId=updateempsalarymodel.getEmployeeId();
			if( retriveempmodel.getEmployeeId()==tempEmpId) {
				employee.setEmployeeId(tempEmpId);
				employeeFound=true;
				break;
			}
		}		
         if(employeeFound) {
        	 double tempSalary=updateempsalarymodel.getNewSalary();
        		if(tempSalary>25000) {
        			employee.setSalary(tempSalary);
        		}else {
        			try {
        			throw new InvalidSalaryException("Salary not valid");
        			}catch(InvalidSalaryException e) {
        				System.out.println("!ERROR[Salary must be greater than 25000]");
        			}
        		}       		
        		try {
        			boolean updated=employeedao.updateEmployeeSalary(employee);
        			if((updated)&&(updateempsalarymodel.getNewSalary()>25000))
        			{
        				result="success";					
        			}
        		} catch (ClassNotFoundException | SQLException e) {
        			// TODO Auto-generated catch block
        			System.out.println("!ERROR[Employee salary updation failed!!]");
        		}		
		  }
         else
         {
        	 try {
 				throw new NoEmployeeFoundException("Employee not found");
 			} catch (NoEmployeeFoundException e) {
 				// TODO Auto-generated catch block
 				System.out.println("!ERROR[Employee with specified id does not exist!!]");
 			}
         }		
	return result;			
	}
		
	@Override
	public String deleteEmployee(RetriveEmployeeModel retriveemployeemodel) {
		
		List<RetriveEmployeeModel> employeesList= retrieveEmployees();
		String result="fail";
		boolean employeeFound=false;
		Employee employee=new Employee();
		for(RetriveEmployeeModel retriveempmodel: employeesList) {
			int tempEmpId=retriveemployeemodel.getEmployeeId();
			if( retriveempmodel.getEmployeeId()==tempEmpId) {
				employee.setEmployeeId(tempEmpId);
				employeeFound=true;
				break;
			}
		}
		if(employeeFound) {
		try {
			boolean deleted=employeedao.deleteEmployeeDetails(employee);
			if(deleted)
				result="success";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("!ERROR[Employee record deletion failed!!]");
		}	
		
	}
		return result;	
	}

	@Override
	public String phoneNumberUpdate(UpdateEmpPhoneNumberModel updateempphonenumbermodel) {
		// TODO Auto-generated method stub
		List<RetriveEmployeeModel> employeesList= retrieveEmployees();
		String result="fail";
		boolean employeeFound=false;
		Employee employee=new Employee();
		for(RetriveEmployeeModel retriveempmodel: employeesList) {
			int tempEmpId=updateempphonenumbermodel.getEmployeeId();
			if( retriveempmodel.getEmployeeId()==tempEmpId) {
				employee.setEmployeeId(tempEmpId);
				employeeFound=true;
				break;
			}
		}
		employee.setPhoneNumber(updateempphonenumbermodel.getNewphoneNumber());
		if(employeeFound)
		{
			try {
				boolean updated=employeedao.updateEmployeePhoneNumber(employee);
				if(updated)
				{
					result="success";
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("!ERROR[	Mobile number updation failed!!]");
			}			
		}
		else
		{
       	 try {
				throw new NoEmployeeFoundException("Employee not found");
			} catch (NoEmployeeFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("!ERROR[Employee with specified id does not exist!!]");
			}			
		}
		return result;	
	}

	@Override
	public String designationUpdate(UpdateEmployeeDesignationModel updateemployeedesgmodel) {	
		List<RetriveEmployeeModel> employeesList= retrieveEmployees();
		String result="fail";
		boolean employeeFound=false;
		boolean designationFound=false;
		Employee employee=new Employee();
		
		for(RetriveEmployeeModel retriveempmodel: employeesList) {
			int tempEmpId=updateemployeedesgmodel.getEmployeeId();
			if( retriveempmodel.getEmployeeId()==tempEmpId) {
				employee.setEmployeeId(tempEmpId);
				employeeFound=true;
				break;
			}
		}
		
		List<RetriveEmployeeDesignationModel> designationList=retrieveDesignation();
		for(RetriveEmployeeDesignationModel retriveEmployeeModelDesignation:designationList) {
			String designationTemp=updateemployeedesgmodel.getUpdateDesignation();
			if(retriveEmployeeModelDesignation.getDesignation().equalsIgnoreCase(designationTemp)){
				employee.setDesignation(designationTemp);
				designationFound=true;
				break;
			}
		}
		
		if((employeeFound)&&(designationFound))
		{
			try {
				boolean updated=employeedao.updateEmployeeDesignation(employee);
				if(updated)
				{
					result="success";
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("!ERROR[Designation updation failed!!]");
			}
			
		}
		else
		{

       	 try {
				throw new NoEmployeeFoundException("Employee not found");
			} catch (NoEmployeeFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("!ERROR[Employee with specified id does not exist!! or Entered designation is not in the list]");
			}
			
		}
		return result;			
		
		// TODO Auto-generated method stub
	}
	
	@Override
	public List<RetriveEmployeeModel> retrieveEmployees() {
		// TODO Auto-generated method stub
		List<RetriveEmployeeModel> retriveEmployeesModelList=new ArrayList<>();
		try {
			List<Employee> employeeList=employeedao.getAllEmployees();
			for(Employee employees:employeeList) {
				
				RetriveEmployeeModel retriveEmployeemodel=new RetriveEmployeeModel();
				retriveEmployeemodel.setEmployeeId(employees.getEmployeeId());
				retriveEmployeemodel.setFirstName(employees.getFirstName());
				retriveEmployeemodel.setLastName(employees.getLastName());				
				retriveEmployeemodel.setEmail(employees.getEmail());
				retriveEmployeemodel.setPhoneNumber(employees.getPhoneNumber());
				retriveEmployeemodel.setDateOfBirth(employees.getDateOfBirth());
				retriveEmployeemodel.setHireDate(employees.getHireDate());
				retriveEmployeemodel.setSalary(employees.getSalary());
				retriveEmployeemodel.setDesignation(employees.getDesignation());
				retriveEmployeemodel.setJobLocation(employees.getJobLocation());			
				retriveEmployeesModelList.add(retriveEmployeemodel);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 	retriveEmployeesModelList;
	}

	@Override
	public List<RetriveEmployeeDesignationModel> retrieveDesignation() {
		// TODO Auto-generated method stub
		List<RetriveEmployeeDesignationModel> retriveDesignationModelList=new ArrayList<>();
		try {
			List<Jobs> designationList=employeedao.getDesignation();
			for(Jobs jobs:designationList) {
				RetriveEmployeeDesignationModel retriveemployeedesignationmodel=new RetriveEmployeeDesignationModel();
				retriveemployeedesignationmodel.setDesignation(jobs.getDesignation());
				retriveDesignationModelList.add(retriveemployeedesignationmodel);
		        
	}
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		return retriveDesignationModelList;
}

}
