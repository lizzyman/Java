package com.ktds.lizzy.bank;

import java.util.Scanner;

import com.ktds.lizzy.bank.biz.*;

public class BankController {

	private Scanner input = new Scanner(System.in);

	private BankBizImpl bankBizImpl = new BankBizImpl();

	public void start() {

		System.out.println("=====은행 프로그램=====");
		int chooseManu = 0;
		int number = 0;
		String name = null;
		while (true) {
			System.out.println("1.예금 , 2.출금 , 3.신규등록 ,4, 종료");
			chooseManu = input.nextInt();
			number = chooseManu;
			if( chooseManu == 1 ){
				System.out.println("이름을 입력해 주세요.");
				name = input.next();
				bankBizImpl.searchUser(name, number);
			}
			else if ( chooseManu == 2 ){
				System.out.println("이름을 입력해 주세요.");
				name = input.next();
				bankBizImpl.searchUser(name, number);
			}
			else if ( chooseManu == 3 ){
				bankBizImpl.addUser();
			}
			else if ( chooseManu == 4 ){
				System.out.println("종료합니다.");
				break;
			}
			
		}
	}

	public static void main(String[] args) {

		new BankController().start();

	}

}
