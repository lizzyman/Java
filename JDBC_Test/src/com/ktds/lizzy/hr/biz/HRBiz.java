package com.ktds.lizzy.hr.biz;

import java.util.List;

import com.ktds.lizzy.hr.vo.CountriesVO;

public interface HRBiz {
	
	public void printAllDepartments();
	public void printAllEmployees();
	public void printAllEmployeesWithDepartments();
	public void printAllDepartmentsWithLocations();
	public void printAllCountriesWithRegions();
	public void printOneEmployee();
}
