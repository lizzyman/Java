package com.ktds.lizzy.vendingMachine.dao;

import com.ktds.lizzy.vendingMachine.vo.UserVo;
import com.ktds.lizzy.vendingMachine.vo.VendingMachineVo;

public interface VendingMachineDao {

	public void setUser(int money);
	
	public int getFund();

	public void addFund(int money);
	
	public void substractFund(int money);
	
	public int getMoney();
	
	public void addMoney(int money);
	
	public void substractMoney(int money);

	public void substractQuantity(int index);
	
	public VendingMachineVo showStatus();
	
}
