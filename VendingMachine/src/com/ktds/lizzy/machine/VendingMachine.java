package com.ktds.lizzy.machine;

import com.ktds.lizzy.person.*;

public class VendingMachine {
	
	private final int COKE = 700;
	private final int SODA = 600; 
	private final int MILKTEA = 800;
	
	private int money;
	private int[] productQuantity;
	
	public VendingMachine(int money, int[] productQuantity) {
		this.setMoney(money);
		this.setProductQuantity(productQuantity);
		
		System.out.println(this);
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void setProductQuantity(int[] productQuantity) {
		this.productQuantity = new int[3];
		for (int i = 0; i < 3; i++) {
			this.productQuantity[i] = productQuantity[i];
		}
	}
	
	public void sell(User user, String product, int inputMoney) {
		int price = 0;
		
		System.out.println("User's input money : " + inputMoney);
		
		if (product.equals("Coke")) {
			System.out.println("User Wants Coke.");
			price = COKE;
			
			if (checkMoney(user, COKE, inputMoney)) {
				System.out.println("Here is a Coke!");
			
				user.pay(inputMoney);
				this.productQuantity[0]--;
				this.money += inputMoney;
			}
			else
				System.out.println("Not enough Money...");
		}
		else if (product.equals("Soda")) {
			System.out.println("User Wants Soda.");
			price = SODA;
			
			if (checkMoney(user, SODA, inputMoney)) {
				System.out.println("Here is a Soda!");
				
				user.pay(inputMoney);
				this.productQuantity[1]--;
				this.money += inputMoney;
			}
			else
				System.out.println("Not enough Money...");
		}
		else if (product.equals("MilkTea")) {
			System.out.println("User Wants MilkTea.");
			price = MILKTEA;
			
			if (checkMoney(user, MILKTEA, inputMoney)) {
				System.out.println("Here is a MilkTea!");
				
				user.pay(inputMoney);
				this.productQuantity[2]--;
				this.money += inputMoney;
			}
			else
				System.out.println("Not enough Money...");
		}
	
	}
	
	public boolean checkMoney(User user, int price, int inputMoney) {
		int change = 0;
		
		if (price > inputMoney) {
			return false;
		}
		else {
			change = inputMoney - price;
			this.giveChange(user, change);
			return true;
		}
	}
	
	public void giveChange(User user, int change) {
		this.money -= change;
		user.getChange(change);
		String message = String.format("Changes : %d", change);
		System.out.println(message);
	}
	
	@Override
	public String toString() {
		String message = String.format("Vending Machine's money : %d\nVending Machine's products Quantity : "
				+ "Coke = %d, Soda = %d, MilkTea = %d", this.money, this.productQuantity[0], this.productQuantity[1], this.productQuantity[2]);
		return message;
	}
}
