package com.ktds.lizzy.hr;

import com.ktds.lizzy.hr.biz.*;

public class HRController {
	
	private HRBiz hrBiz;
	
	public HRController() {
		hrBiz = new HRBizImpl();
	}
	
	public void start() {
		hrBiz.printAllCountriesWithRegions();
	}
	
	public static void main(String[] args) {
		
		new HRController().start();
		
	}

}
