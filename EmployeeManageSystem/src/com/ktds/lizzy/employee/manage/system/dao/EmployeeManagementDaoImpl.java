package com.ktds.lizzy.employee.manage.system.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktds.lizzy.employee.manage.system.vo.EmployeeVo;

public class EmployeeManagementDaoImpl implements EmployeeManagementDao {

	List<EmployeeVo> employeeList;
	
	public EmployeeManagementDaoImpl() {
		employeeList = new ArrayList<EmployeeVo>();
	}
	
	@Override
	public List<EmployeeVo> queryAllEmployee() {
		return employeeList;
	}

	@Override
	public void addEmployee(EmployeeVo newEmployee) {
		employeeList.add(newEmployee);
	}

	@Override
	public void removeEmployee(int index) {
		employeeList.remove(index);
	}

	@Override
	public void updateEmployee(int index, EmployeeVo updatedEmployee) {
		employeeList.set(index, updatedEmployee);
	}

}
