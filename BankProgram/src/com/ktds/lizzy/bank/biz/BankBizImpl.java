package com.ktds.lizzy.bank.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ktds.lizzy.bank.dao.*;
import com.ktds.lizzy.bank.vo.UserVo;

public class BankBizImpl implements BankBiz {

	Scanner input = new Scanner(System.in);
	private BankDao bankDao;

	public BankBizImpl() {
		bankDao = new BankDaoImpl();
	}

	@Override
	public void searchUser(String name, int number) {

		List<UserVo> userList = bankDao.searchUser();
		int count = 0;
		for (UserVo uservo : userList) {
			if (name.equals(uservo.getName())) {
				count++;
				if (number == 1) {
					depositMoney(uservo);
				}
				else if (number == 2) {
					withdrawMoney(uservo);
				}
				else {
					System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
					continue;
				}

			}
		}
		if (count == 0) {
			System.out.println("기존 고객이 아닙니다.");
			System.out.println("신규 고객으로 등록합니다.");
			addUser();
		}

	}

	@Override
	public void addUser() {
		System.out.println("신규 고객의 이름을 입력해주세요.");
		String userName = input.nextLine();
		System.out.println("5000원을 입급합니다.");
		UserVo userVo = new UserVo(userName, 5000);
		bankDao.addUser(userVo);

	}

	@Override
	public void depositMoney(UserVo userVo) {

		System.out.println("얼마를 예금하시겠습니까?");
		int money = input.nextInt();
		bankDao.depositMoney(userVo, money);
		System.out.printf("고객님의 현재 금액은 %d 입니다.\n", userVo.getDeposit());

	}

	@Override
	public void withdrawMoney(UserVo userVo) {

		System.out.println("얼마를 출금하시겠습니까?");
		int money = input.nextInt();
		if (userVo.getDeposit() >= money) {
			bankDao.withdrawMoney(userVo, money);
			System.out.printf("고객님의 현재 금액은 %d 입니다.\n", userVo.getDeposit());
		} else {
			System.out.println("잔고가 부족합니다.");
			System.out.printf("고객님의 현재 금액은 %d 입니다.\n", userVo.getDeposit());
		}
	}

}