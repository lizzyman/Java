package com.ktds.lizzy.hr;

import com.ktds.lizzy.hr.biz.HRBiz;
import com.ktds.lizzy.hr.biz.HRBizImpl;

public class HRController {
	
	private HRBiz hrBiz;
	
	public HRController() {
		hrBiz = new HRBizImpl();
	}

	public void start() {
		hrBiz.printAllDepartments();
	}
	
	public static void main(String[] args) {
		
		new HRController().start();
		
	}
	
}
