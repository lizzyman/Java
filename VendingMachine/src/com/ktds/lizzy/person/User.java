package com.ktds.lizzy.person;

import com.ktds.lizzy.machine.VendingMachine;

public class User {
	
	private int money;
	
	/**
	 * User 생성자 
	 * @param money
	 */
	public User(int money){
		this.setMoney(money);
		
		System.out.println(this);
	}
	
	/**
	 * initialize User's Money
	 * @param money
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void buy(VendingMachine vendingMachine, String product, int inputMoney) {
		vendingMachine.sell(this, product, inputMoney);
	}
	
	public void pay(int inputMoney) {
		this.money -= inputMoney;
	}
	
	public void getChange(int change) {
		this.money += change;
	}
	
	@Override
	public String toString() {
		String message = String.format("User's money : %d", this.money);
		return message;
	}

}
