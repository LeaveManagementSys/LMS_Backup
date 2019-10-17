package com.virtusa.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.convertor.DateConverter;
import com.virtusa.helper.FactoryHr;
import com.virtusa.model.InsertEmployeeModel;
import com.virtusa.model.RetriveEmployeeDesignationModel;
import com.virtusa.model.RetriveEmployeeModel;
import com.virtusa.service.HrService;
import com.virtusa.validation.EmployeesModelValidator;

/**
 * Servlet implementation class Hrservlet
 */
@WebServlet("/Hrservlet")
public class Hrservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HrService hrservice=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hrservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.hrservice=FactoryHr.createHrService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action=request.getParameter("action");
		if(action.contentEquals("loadform"))
		{
			List<RetriveEmployeeDesignationModel> designationList=hrservice.retrieveDesignation();
			request.setAttribute("designationList",designationList);
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("employeeform.jsp");
			dispatcher.forward(request, response);	
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String action=request.getParameter("action");
		 if(action.contentEquals("newEmployee")) 
		 {
			 int employeeId=Integer.parseInt(request.getParameter("employeeId"));
			    String firstName=request.getParameter("firstName");
	        	String lastName=request.getParameter("lastName");
	        	String email=request.getParameter("email");
	        	String phoneNumber=request.getParameter("phoneNumber");
	        	String hire_Date=request.getParameter("hireDate");
	        	LocalDate hireDate=DateConverter.convertLocaleDate(hire_Date, "-");
	        	String date_Of_Birth=request.getParameter("dateOfBirth");
	        	LocalDate dateOfBirth=DateConverter.convertLocaleDate(date_Of_Birth, "-");
	        	double salary=Double.parseDouble(request.getParameter("salary"));
	        	String designation=request.getParameter("designation");
	        	String jobLocation=request.getParameter("location");
	        	
	        	EmployeesModelValidator validator=new EmployeesModelValidator();
	        	boolean employeeIdExist=validator.employeeIdExists(employeeId);
	        	boolean emailExist=validator.emailExist(email);
	        	boolean validFirstName=validator.validString(firstName);
	        	boolean validLastName=validator.validString(lastName);
	        	boolean validEmail=validator.validEmail(email);
	        	boolean validSalary=validator.validSalary(salary);
	        	
	        	if(employeeIdExist || !validFirstName || !validLastName || !validEmail || !validSalary || emailExist) {
	        		
	        		  if(employeeIdExist) {
	                  	request.setAttribute("employeeIderror","Employee Id already exist");

	                  }
	                  if(!validFirstName) {
	              		request.setAttribute("firstnameerror", "First Name not valid");
	                  }
	                  if(!validLastName) {
	              		request.setAttribute("lastnameerror",  "Last Name not valid");
	                  }
	                  if(!validEmail) {
	              		request.setAttribute("emailerror",  "Email not valid");

	                  }
	                  if(!validSalary) {
	              		request.setAttribute("salaryerror",  "Salary not valid");

	                  }
	                  if(emailExist) {
	                		request.setAttribute("emailexisterror",  "Email already exist");

	                  }     
	                  
	                  
	          		
	                  RequestDispatcher dispatcher=
	          				request.getRequestDispatcher("employeeform.jsp");	                  
	          		List<RetriveEmployeeDesignationModel> designationList=hrservice.retrieveDesignation();
	          		request.setAttribute("designationList",designationList);
	          		dispatcher.forward(request,response);
	              	}
	        	
	        	else {
	        		InsertEmployeeModel insertEmployeeModel=new InsertEmployeeModel();
	        		insertEmployeeModel.setEmployeeId(employeeId);
	        		insertEmployeeModel.setFirstName(firstName);
	        		insertEmployeeModel.setLastName(lastName);
	        		insertEmployeeModel.setEmail(email);
	        		insertEmployeeModel.setPhoneNumber(phoneNumber);
	        		insertEmployeeModel.setHireDate(hireDate);
	        		insertEmployeeModel.setSalary(salary);
	        		insertEmployeeModel.setDateOfBirth(dateOfBirth);
	        		insertEmployeeModel.setDesignation(designation);
	        		insertEmployeeModel.setJobLocation(jobLocation);
	              		String outcome=hrservice.employeeInsert(insertEmployeeModel);
	              		if(outcome.contentEquals("success")) {
	              			 RequestDispatcher dispatcher=
	              	    				request.getRequestDispatcher("employeesuccess.jsp");
	              			 request.setAttribute("insertEmployeeModel",insertEmployeeModel);
	                 			 request.setAttribute("operation", "Below Employee record Registration was Successfully");

	              	    		dispatcher.forward(request,response);
	              		}else {
	              			 RequestDispatcher dispatcher=
	              	    				request.getRequestDispatcher("employeefail.jsp");
	                 			 request.setAttribute("operation", "Employee Registration Failed");

	              	    		dispatcher.forward(request,response);
	              		}
		 }
		
	}

	}
}
