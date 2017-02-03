package com.ktds.lizzy.bank.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktds.lizzy.bank.vo.UserVo;

public class BankDaoImpl implements BankDao{
	
	private List<UserVo> userList;
	
	public BankDaoImpl() {
		userList = new ArrayList<UserVo>();
	}

	@Override
	public List<UserVo> searchUser() {
		return userList;
	}

	@Override
	public void addUser(UserVo user) {
		userList.add(user);
	}

	@Override
	public void depositMoney(UserVo userVo, int money) {
		userVo.setDeposit(userVo.getDeposit() + money);
		
	}

	@Override
	public int withdrawMoney(UserVo userVo, int money) {
		userVo.setDeposit(userVo.getDeposit() - money);
		return money;
	}
	
}
