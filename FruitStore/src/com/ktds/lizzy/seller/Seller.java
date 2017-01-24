package com.ktds.lizzy.seller;

import com.ktds.lizzy.buyer.Buyer;

public class Seller {
	
	private final int MELON = 7000;
	private final int APPLE = 3000;
	private final int LEMON = 1500;
	
	private int[] productQuantity;
	private int money;	
	
	/**
	 * Initialized Seller (생성자)
	 * @param money
	 * @param productQuantity
	 */
	public Seller(int money, int[] productQuantity) {
		this.setMoney(money);
		this.setProductQuantity(productQuantity);
	}
	
	/**
	 * initialize Seller's money.
	 * @param money
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	/**
	 * initialize Seller's product quantity
	 * @param productQuantity
	 */
	public void setProductQuantity(int[] productQuantity) {
		this.productQuantity = new int[3];
		for (int i = 0; i < 3; i++) {
			this.productQuantity[i] = productQuantity[i];
		}
	}
	
	/**
	 * Sell Products (3 Choices)
	 * @param buyer
	 * @param fruit
	 */
	public void sell(Buyer buyer, String fruit) {
		int price = 0;
		
		if (fruit.equals("Melon")) {
			price = MELON;
			this.productQuantity[0]--;
		}
		else if (fruit.equals("Apple")) {
			price = APPLE;
			this.productQuantity[1]--;
		}
		else if (fruit.equals("Lemon")) {
			price = LEMON;
			this.productQuantity[2]--;
		}
		
		this.money += price;
		buyer.pay(price);
	}
	
	/**
	 * Seller's current Status
	 */
	public void sellerStatus() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String message = String.format("Seller's Money : %d\n"
				+ "Seller's Melon Quantity : %d\nSeller's Apple Quantity : %d\n"
				+ "Seller's Lemon Quantity : %d",this.money,this.productQuantity[0], this.productQuantity[1], this.productQuantity[2]);
		return message;
	}

}
