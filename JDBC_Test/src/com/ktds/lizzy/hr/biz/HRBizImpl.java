package com.ktds.lizzy.hr.biz;

import com.ktds.lizzy.hr.dao.HRDao;
import com.ktds.lizzy.hr.dao.HRDaoImpl;
import com.ktds.lizzy.hr.vo.DepartmentVO;
import com.ktds.lizzy.hr.vo.EmployeesVO;

import java.util.List;

public class HRBizImpl implements HRBiz {
	
	private HRDao hrDao;
	
	public HRBizImpl() {
		hrDao = new HRDaoImpl();
	}
	
	public void printAllEmployees() {
		List<EmployeesVO> allEmployees = hrDao.getAllEmployees();
		
		for (EmployeesVO employeeVO : allEmployees) {
			System.out.printf("%d\t%20s\t%20s\t%f\t%d\t%20s\t%20s\t%20s\t%d\t%20s\t%d"
					,employeeVO.getEmployeeId()
					,employeeVO.getFirstName()
					,employeeVO.getLastName()
					,employeeVO.getCommissionPct()
					,employeeVO.getDepartmentId()
					,employeeVO.getEmail()
					,employeeVO.getHireDate()
					,employeeVO.getJobId()
					,employeeVO.getManagerId()
					,employeeVO.getPhoneNumber()
					,employeeVO.getSalary());
		}
	}
	
	public void printAllDepartments() {
		List<DepartmentVO> allDepartments = hrDao.getAllDepartments();
		
		for (DepartmentVO departmentVO : allDepartments) {
			System.out.printf("%d\t%20s\t%d\t%d",
					departmentVO.getDepartmentId(),
					departmentVO.getDepartmentName(),
					departmentVO.getManagerId(),
					departmentVO.getLocationId());
			System.out.println();
		}
		
	}

	@Override
	public void printAllEmployeesWithDepartments() {
		List<EmployeesVO> allEmployees = hrDao.getAllEmployeesWithDepartments();
		DepartmentVO departmentVO = null;
		
		for (EmployeesVO employeeVO : allEmployees) {
			departmentVO = employeeVO.getDepartments();
			System.out.printf("%d\t%20s\t%20s\t%f\t%d\t%20s\t%20s\t%20s\t%d\t%20s\t%d\t%d\t%20s\t%d\t%d"
					,employeeVO.getEmployeeId()
					,employeeVO.getFirstName()
					,employeeVO.getLastName()
					,employeeVO.getCommissionPct()
					,employeeVO.getDepartmentId()
					,employeeVO.getEmail()
					,employeeVO.getHireDate()
					,employeeVO.getJobId()
					,employeeVO.getManagerId()
					,employeeVO.getPhoneNumber()
					,employeeVO.getSalary(),
					departmentVO.getDepartmentId(),
					departmentVO.getDepartmentName(),
					departmentVO.getManagerId(),
					departmentVO.getLocationId());
			System.out.println();
					
		}
	}
	
}
