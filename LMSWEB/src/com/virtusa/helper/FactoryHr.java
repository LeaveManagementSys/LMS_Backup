package com.virtusa.helper;

import com.virtusa.DAO.EmployeeDao;
import com.virtusa.DAO.EmployeeDaoImpl;
import com.virtusa.service.HrService;
import com.virtusa.service.HrServiceImpl;

public class FactoryHr {

	public static HrService createHrService()
	{
		HrService hrservice=new HrServiceImpl();
		return hrservice;	
	}
	
	public static EmployeeDao createEmployeeDao()
	{
		EmployeeDao	employeedao=new EmployeeDaoImpl();
		return employeedao;
	}
}
