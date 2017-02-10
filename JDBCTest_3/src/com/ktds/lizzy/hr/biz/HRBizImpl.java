package com.ktds.lizzy.hr.biz;

import java.util.List;

import com.ktds.lizzy.hr.dao.*;
import com.ktds.lizzy.hr.vo.EmployeesVO;

public class HRBizImpl implements HRBiz {

	private HRDao hrDao = new HRDaoImpl();
	
	@Override
	public void printEmployeesInfo() {
		List<EmployeesVO> employeesVO = hrDao.getEmployeesInfo();
		for (EmployeesVO employeeVO : employeesVO) {
			System.out.printf("%d\t%20s\t%30s\t%20s",
					employeeVO.getEmployeeId(),
					employeeVO.getDepartmentsVO().getDepartmentName(),
					employeeVO.getJobsVO().getJobTitle(),
					employeeVO.getDepartmentsVO().getLocationVo().getCity());
			System.out.println();
		}
	}
	
	@Override
	public void printEmployeesInfoInSeattle() {
		List<EmployeesVO> employeesVO = hrDao.getEmployeesInfoInSeattle();
		for (EmployeesVO employeeVO : employeesVO) {
			System.out.printf("%d\t%20s\t%30s",
					employeeVO.getEmployeeId(),
					employeeVO.getDepartmentsVO().getDepartmentName(),
					employeeVO.getJobsVO().getJobTitle());
			System.out.println();
		}
	}

	@Override
	public void printEmployeesInDepartment(int departmentId) {
		List<EmployeesVO> employeesVO = hrDao.getEmployeesInDepartment(departmentId);
		for (EmployeesVO employeeVO : employeesVO) {
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
			System.out.println();
		}
	}
	@Override
	public void printAllEmployeesInDepartments() {
		
		
	}
	
}
