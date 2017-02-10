package com.ktds.lizzy.hr.dao;

import java.util.List;

import com.ktds.lizzy.hr.vo.DepartmentsVO;

public interface HRDao {
	
	public List getEmployeesInfo();
	public List getEmployeesInfoInSeattle();
	public List getEmployeesInDepartment(int departmentId);
	
}
