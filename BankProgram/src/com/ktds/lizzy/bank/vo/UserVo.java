package com.ktds.lizzy.bank.vo;

public class UserVo {

	private String name;
	private int deposit;

	public UserVo(String name, int money) {
		this.name = name;
		this.deposit = money;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

}
