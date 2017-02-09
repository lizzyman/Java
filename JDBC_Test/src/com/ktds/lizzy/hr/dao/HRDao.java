package com.ktds.lizzy.hr.dao;
import java.util.List;
import com.ktds.lizzy.hr.vo.*;
public interface HRDao {
	public List<EmployeesVO> getAllEmployees();
	
	public List<DepartmentVO> getAllDepartments();
	
	public List<EmployeesVO> getAllEmployeesWithDepartments();
	
	public List<DepartmentVO> getAllDepartmentsWithLocations();
	
	public List<CountriesVO> getAllCountriesWithRegions();
	
	public EmployeesVO findOneEmployee(int employeeId);
}
