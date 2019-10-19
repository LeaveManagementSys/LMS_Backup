package com.virtusa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.DAO.UserDAOImp;
import com.virtusa.DAO.UserDao;
import com.virtusa.helper.UserData;
import com.virtusa.model.UserModel;
import com.virtusa.service.UserService;
import com.virtusa.service.UserServiceImp;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "UserLogin", urlPatterns = { "/UserLogin" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = null;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.userService = UserData.createUserService();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action=request.getParameter("action");
		if(action.contentEquals("view")) {
		List<UserModel> employeesModelList=UserService.getuserList();
		request.setAttribute("employeesModelList", employeesModelList);
		
		if(!employeesModelList.isEmpty()) {
			
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("employeedetails.jsp");
			dispatcher.forward(request,response);
		}else {
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("noemployeedetails.jsp");
			dispatcher.forward(request,response);
		}
		}
		
		if(action.contentEquals("loadform")) {
			
			List<DepartmentsModel> departmentsList=
					departmentService.retrieveDepartments();
			List<JobsModel> jobsList=jobsService.retrieveJobs();
			List<ManagersModel> managersList=employeeService.getManagers();
			request.setAttribute("departmentsList", departmentsList);
			request.setAttribute("jobsList", jobsList);
			request.setAttribute("managersList", managersList);
			
			
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("employeeform.jsp");
			dispatcher.forward(request, response);
		}
		
           if(action.contentEquals("viewEmployee")) {
			
			
        	List<AllEmployeesModel> allemployeesList=employeeService.retrieveAllEmployees();
			request.setAttribute("allemployeesList", allemployeesList);
			
			
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("allemployees.jsp");
			dispatcher.forward(request, response);
		}		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Logger logger = Logger.getLogger(UserController.class);
		BasicConfigurator.configure();
		
		/*String EmployeeId = request.getParameter("EmployeeId");
		String Password = request.getParameter("Password");*/

		String action = request.getParameter("action");

		if (action.contentEquals("login")) {
			List<UserModel> userModelList = UserServiceImp.getuserList();
			int empId = Integer.parseInt(request.getParameter("emp_id"));
			String password = request.getParameter("pass");
			HttpSession session = request.getSession();
			session.setAttribute("emp_id", emp_id);
			String empType = null;
			UserDao userDao = new UserDAOImp();
			UserServiceImp serviceImp = new UserServiceImp();
			UserModel userModel;
			empType = serviceImp.authenticateService(userModel);
			logger.info(empType);

			if (empType != null) {
				logger.info("Employee Type is " + empType);
				if (empType.equals("HR")) {
					session.setAttribute("emp_id", empId);
					response.sendRedirect("hrpage.jsp");
				} else if (empType.equals("EMPLOYEE")) {
					session.setAttribute("emp_id", empId);
					response.sendRedirect("employeePage.jsp");
				} else if (empType.equals("MANAGER")) {
					session.setAttribute("emp_id", empId);
					response.sendRedirect("managerPage.jsp");
				}
			}

			else {
				logger.info("Employee Not Found Authentication Failed Please try again");
				((HttpServletResponse) session).sendRedirect("Login.jsp");
			}
		}
	}

}
