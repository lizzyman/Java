package com.ktds.lizzy.vendingMachine.dao;

import java.util.List;

import com.ktds.lizzy.vendingMachine.vo.*;

public class VendingMachineDaoImpl implements VendingMachineDao {

	private UserVo user;
	private VendingMachineVo vendingMachine;
	
	public VendingMachineDaoImpl() {
		user = new UserVo();
		vendingMachine = new VendingMachineVo(500000);
	}
	
	@Override
	public void setUser(int money) {
		user.setMoney(money);
	}
	
	@Override
	public int getFund() {
		return vendingMachine.getFund();
	}

	@Override
	public void addFund(int money) {
		vendingMachine.setFund(vendingMachine.getFund() + money);
	}

	@Override
	public void substractFund(int money) {
		vendingMachine.setFund(vendingMachine.getFund() - money);
	}

	@Override
	public int getMoney() {
		return user.getMoney();
	}
	
	@Override
	public void addMoney(int money) {
		user.setMoney(user.getMoney() + money);
	}

	@Override
	public void substractMoney(int money) {
		user.setMoney(user.getMoney() - money);
	}

	@Override
	public void substractQuantity(int index) {
		List<Integer> drinksQuantity = vendingMachine.getDrinksQuantity();
		drinksQuantity.set(index, drinksQuantity.get(index) - 1);
	}

	@Override
	public VendingMachineVo showStatus() {
		return vendingMachine;
	}

}
