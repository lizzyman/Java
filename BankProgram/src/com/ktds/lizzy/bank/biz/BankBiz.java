package com.ktds.lizzy.bank.biz;

import java.util.List;

import com.ktds.lizzy.bank.vo.UserVo;

public interface BankBiz {
	
	public void searchUser(String name, int number);
	
	public void addUser();
	
	public void depositMoney(UserVo userVo);
	
	public void withdrawMoney(UserVo userVo);
	
}
