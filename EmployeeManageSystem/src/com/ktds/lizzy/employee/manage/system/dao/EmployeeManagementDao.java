package com.ktds.lizzy.employee.manage.system.dao;

import com.ktds.lizzy.employee.manage.system.vo.*;
import java.util.List;

public interface EmployeeManagementDao {
	
	public List<EmployeeVo> queryAllEmployee();
	
	public void addEmployee(EmployeeVo newEmployee);
	
	public void removeEmployee(int index);
	
	public void updateEmployee(int index, EmployeeVo updatedEmployee);
	
}
