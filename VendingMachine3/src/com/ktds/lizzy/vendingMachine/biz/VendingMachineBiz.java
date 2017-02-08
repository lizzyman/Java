package com.ktds.lizzy.vendingMachine.biz;

public interface VendingMachineBiz {

	public void setUser();
	public void showMenu();
	//public void selectMenu();
	public void goProcess(int price, int index);
}
