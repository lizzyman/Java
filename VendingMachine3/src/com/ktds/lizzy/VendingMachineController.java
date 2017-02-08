package com.ktds.lizzy;

import com.ktds.lizzy.vendingMachine.vo.UserVo;
import com.ktds.lizzy.vendingMachine.biz.*;
import com.ktds.lizzy.vendingMachine.cons.*;

public class VendingMachineController {

	private UserVo user;
	private VendingMachineBiz vendingMachineBiz = new VendingMachineBizImpl();
	
	public void start() {
		System.out.println("Put your money into the VendingMachine.");

		vendingMachineBiz.setUser();
	}

//	private void setUser(int money) {
//		user = new UserVo();
//		user.setMoney(money);
//		//System.out.println(user);
//	}
	
//	private void showMenu() {
//		VendingMachineBiz vendingMachineBiz = new VendingMachineBizImpl();
//		
//		while(true) {
//			System.out.println("<< Menu >>");
//			if (user.getMoney() < DrinksPriceConstant.CIDER) {
//				System.out.println("Not enough to buy a drink!");
//				System.out.println("Exit Program. Bye.");
//				break;
//			}
//			else if (user.getMoney() < DrinksPriceConstant.COKE) {
//				System.out.println("2. Cider");
//				// 
//			}
//			else if (user.getMoney() < DrinksPriceConstant.FANTA) {
//				System.out.println("0. Coke, 2. Cider");
//				
//			}
//			else {
//				System.out.println("0. Coke, 1. Fanta, 2. Cider");
//				
//			}
//		}
//	}
	
	public static void main(String[] args) {
		new VendingMachineController().start();		
	}

}