package com.virtusa.service;

import java.util.List;

import com.virtusa.model.InsertEmployeeModel;
import com.virtusa.model.RetriveEmployeeDesignationModel;
import com.virtusa.model.RetriveEmployeeModel;
import com.virtusa.model.UpdateEmpPhoneNumberModel;
import com.virtusa.model.UpdateEmployeeDesignationModel;
import com.virtusa.model.UpdateEmployeeSalaryModel;

public interface HrService {
	 List<RetriveEmployeeModel> retrieveEmployees();
	 String employeeInsert(InsertEmployeeModel insertemployeemodel);
	 String salaryupdate(UpdateEmployeeSalaryModel updateempsalarymodel);
	 String deleteEmployee(RetriveEmployeeModel retriveemployeemodel);
	 String phoneNumberUpdate(UpdateEmpPhoneNumberModel updateempphonenumbermodel);
	 String designationUpdate(UpdateEmployeeDesignationModel updateemployeedesgmodel);
     List<RetriveEmployeeDesignationModel> retrieveDesignation();
}
