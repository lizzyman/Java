package com.ktds.lizzy.employee.manage.system.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ktds.lizzy.employee.manage.system.dao.*;
import com.ktds.lizzy.employee.manage.system.vo.*;

public class EmployeeManagementBizImpl implements EmployeeManagementBiz{
	
	EmployeeManagementDao employeeManagementDao = new EmployeeManagementDaoImpl();
	List<EmployeeVo> employeeList = new ArrayList<EmployeeVo>();
	
	private Scanner input = new Scanner(System.in);
	
	private String name;
	private String department;
	private String position;
	private int positionConst;
	private int salary;
	
	@Override
	public void queryAllEmployee() {
		employeeList = employeeManagementDao.queryAllEmployee();
	
		System.out.println("[Check all Employee]");
		int employeeNumber = 1;
		for (EmployeeVo employee : employeeList) {
			showEmployeeInfo(employee, employeeNumber);
			employeeNumber++;
		}
	}

	private void showEmployeeInfo(EmployeeVo employee, int employeeNumber) {
		String position;
		if (employee.getPosition() == 100) {
			position = "Employee";
		}
		else if (employee.getPosition() == 200) {
			position = "Manager";
		}
		else if (employee.getPosition() == 300) {
			position = "JuniorChief";
		}
		else if (employee.getPosition() == 400) {
			position = "SeniorChief";
		}
		else if (employee.getPosition() == 500) {
			position = "MasterChief";
		}
		else {
			position = "CEO";
		}
		
		System.out.printf("\n(%dth)\nName : %s\nDepartment : %s\nPosition : %s\nSalary : %s\n",
				employeeNumber, employee.getName(), employee.getDepartment(), 
				position, employee.getSalary());
	}

	@Override
	public void addEmployee() {
		
		EmployeeVo newEmployee = new EmployeeVo();
	
		System.out.println("[Add new Employee]");
		enterEmployeeInfo(newEmployee, input);
		
		employeeManagementDao.addEmployee(newEmployee);
	}

	private void enterEmployeeInfo(EmployeeVo newEmployee, Scanner input) {
		System.out.println("Enter a Employee's Name.");
		name = input.next();
		System.out.println("Enter a Employees's Department.");
		department = input.next();
		System.out.println("Enter a Employee's Position.");
		System.out.println("- Employee , Manager, JuniorChief, SeniorChief, MasterChief, CEO -");
		checkPositionValidity(input);
		System.out.println("Enter a Employee's Salary.");
		salary = input.nextInt();
			
		newEmployee.setName(name);
		newEmployee.setDepartment(department);
		newEmployee.setPosition(positionConst);
		newEmployee.setSalary(salary);
	}

	private void checkPositionValidity(Scanner input) {
		while (true) {
			position = input.next();
			if (position.equals("Employee")) {
				positionConst = EmployeePostionConst.EMPLOYEE;
				break;
			}
			else if (position.equals("Manager")) {
				positionConst = EmployeePostionConst.MANAGER;
				break;
			}
			else if (position.equals("JuniorChief")) {
				positionConst = EmployeePostionConst.JUNIOR_CHIEF;
				break;
			}
			else if (position.equals("SeniorChief")) {
				positionConst = EmployeePostionConst.SENIOR_CHIEF;
				break;
			}
			else if (position.equals("MasterChief")) {
				positionConst = EmployeePostionConst.MASTER_CHIEF;
				break;
			}
			else if (position.equals("CEO")) {
				positionConst = EmployeePostionConst.CEO;
				break;
			}
			else {
				System.out.println("Wrong position. Please Enter agian!");
			}
		}
	}

	@Override
	public void removeEmployee() {
		System.out.println("[Remove Employee]");
		System.out.println("Enter the employee's Number.");
		int index = input.nextInt();
		employeeManagementDao.removeEmployee(index-1);
	}

	@Override
	public void updateEmployee() {
		EmployeeVo updatedEmployee = new EmployeeVo();
		
		System.out.println("[Update Employee]");
		System.out.println("Enter the employees's Number.");
		int index = input.nextInt();
		enterEmployeeInfo(updatedEmployee, input);
		
		employeeManagementDao.updateEmployee(index-1, updatedEmployee);
	}

}
