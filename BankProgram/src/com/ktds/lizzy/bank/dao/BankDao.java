package com.ktds.lizzy.bank.dao;

import java.util.List;

import com.ktds.lizzy.bank.vo.UserVo;

public interface BankDao {
	
	public List<UserVo> searchUser();
	
	public void addUser(UserVo user);
	
	public void depositMoney(UserVo user, int money);
	
	public int withdrawMoney(UserVo user, int money);
	
}
