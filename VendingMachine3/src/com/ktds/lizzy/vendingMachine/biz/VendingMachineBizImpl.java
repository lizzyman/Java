package com.ktds.lizzy.vendingMachine.biz;

import java.util.List;
import java.util.Scanner;

import com.ktds.lizzy.vendingMachine.cons.DrinksPriceConstant;
import com.ktds.lizzy.vendingMachine.dao.*;
import com.ktds.lizzy.vendingMachine.vo.UserVo;

public class VendingMachineBizImpl implements VendingMachineBiz {
	
	private Scanner input = new Scanner(System.in);
	
	private VendingMachineDao vendingMachineDao;

	public VendingMachineBizImpl() {
		vendingMachineDao = new VendingMachineDaoImpl();
	}

	public void setUser() {
		int money = input.nextInt();
		vendingMachineDao.setUser(money);
		this.showMenu();
	}
	
	public void showMenu() {
		List<Integer> drinksQuantity = null;
		
		while(true) {
			if (vendingMachineDao.getFund() > 0) {
				drinksQuantity = vendingMachineDao.showStatus().getDrinksQuantity();
				
				for (int drinkQuantity : drinksQuantity) {
					if (drinkQuantity == 0) {
						System.out.println("Not enough drinks in the Machine!");
						System.out.println("Exit Program. Bye.");
						return;
					}
				}
				
				System.out.println(vendingMachineDao.showStatus());
				
				if (vendingMachineDao.getMoney() < DrinksPriceConstant.CIDER) {
					
					System.out.println("Not enough money to buy a drink!");
					System.out.println("Exit Program. Bye.");
					vendingMachineDao.addMoney(vendingMachineDao.getMoney());
					break;
				}
				else if (vendingMachineDao.getMoney() < DrinksPriceConstant.COKE) {
					System.out.println("2. Cider");
				}
				else if (vendingMachineDao.getMoney() < DrinksPriceConstant.FANTA) {
					System.out.println("0. Coke, 2. Cider");
				}
				else {
					System.out.println("0. Coke, 1. Fanta, 2. Cider");
				}
				
				this.selectMenu();
			}
			else {
				System.out.println("Not enough money exists in Machine. Sorry...");
				System.out.println("Exit Program. Bye.");
				return ;
			}
			
		}
	}
	
	private void selectMenu() {
		int selectedMenu = input.nextInt();
		if (selectedMenu == 0) {
			this.goProcess(DrinksPriceConstant.COKE, 0);
			System.out.println();
		}
		else if (selectedMenu == 1) {
			this.goProcess(DrinksPriceConstant.FANTA, 1);
			System.out.println();
		}
		else if (selectedMenu == 2) {
			this.goProcess(DrinksPriceConstant.CIDER, 2);
			System.out.println();
		}
		else {
			System.out.println("Wrong Input... Please enter, again!");
			System.out.println();
		}
	}

	public void goProcess(int drinkPrice, int index) {
		vendingMachineDao.addFund(drinkPrice);
		vendingMachineDao.substractMoney(drinkPrice);
		vendingMachineDao.substractQuantity(index);
	}
	
}
