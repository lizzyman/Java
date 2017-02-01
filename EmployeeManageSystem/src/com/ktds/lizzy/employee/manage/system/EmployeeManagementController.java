package com.ktds.lizzy.employee.manage.system;

import java.util.Scanner;

import com.ktds.lizzy.employee.manage.system.biz.EmployeeManagementBiz;
import com.ktds.lizzy.employee.manage.system.biz.EmployeeManagementBizImpl;

public class EmployeeManagementController {
	
	EmployeeManagementBiz employeeManagementBiz = new EmployeeManagementBizImpl();
	
	private Scanner input = new Scanner(System.in);
	private int chooseMenu;
	
	public void start() {
		while (true) {
			System.out.println("\n==========Employee Management System==========");
			System.out.println("1. Check all Employee");
			System.out.println("2. Add new Employee");
			System.out.println("3. Remove Employee");
			System.out.println("4. Update Employee");
			System.out.println("5. Exit Program");
			System.out.println("==============================================");
			
			chooseMenu = input.nextInt();
			if (chooseMenu == 1) {
				employeeManagementBiz.queryAllEmployee();
			}
			else if (chooseMenu == 2) {
				employeeManagementBiz.addEmployee();
			}
			else if (chooseMenu == 3) {
				employeeManagementBiz.removeEmployee();
			}
			else if (chooseMenu == 4) {
				employeeManagementBiz.updateEmployee();
			}
			else if (chooseMenu == 5) {
				System.out.println("Exit Program...");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new EmployeeManagementController().start();
	}
	
}
