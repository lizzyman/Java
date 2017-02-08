package com.ktds.lizzy.vendingMachine.vo;

public class UserVo {
	
	private int money;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		String msg = String.format("[User's left Money] %d(won)", this.money);
		return msg;
	}
	
}
