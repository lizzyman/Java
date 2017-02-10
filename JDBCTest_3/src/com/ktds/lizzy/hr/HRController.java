package com.ktds.lizzy.hr;

import com.ktds.lizzy.hr.biz.*;

public class HRController {
	
	private HRBiz hrBiz;
	
	public HRController() {
		hrBiz = new HRBizImpl();
	}
	
	public void start() {
		hrBiz.printEmployeesInfo();
		//hrBiz.printEmployeesInfoInSeattle();
		//hrBiz.printEmployeesInDepartment(100);
	}
	
	public static void main(String[] args) {
		new HRController().start();
	}

}
