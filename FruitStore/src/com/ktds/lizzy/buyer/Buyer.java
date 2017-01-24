package com.ktds.lizzy.buyer;

import com.ktds.lizzy.seller.Seller;

public class Buyer {
	
	private int money;
	private int productQuantity;
	
	/**
	 * Initialized Buyer (생성자)
	 * @param money
	 * @param productQuantity
	 */
	public Buyer(int money, int productQuantity) {
		this.setMoney(money);
		this.setProductQuantity(productQuantity);
	}
	
	/**
	 * initialize Buyer's money
	 * @param money
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	/**
	 * initialize Buyer's product quantity
	 * @param productQuantity
	 */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	/**
	 * buy Fruits (3 Choices)
	 * @param seller
	 * @param fruit
	 */
	public void buy(Seller seller ,String fruit) {
		if (fruit.equals("Melon")) {
			seller.sell(this, "Melon");
			
			this.productQuantity++;
		}
		else if (fruit.equals("Apple")) {
			seller.sell(this, "Apple");
			
			this.productQuantity++;
		}
		else if (fruit.equals("Lemon")) {
			seller.sell(this, "Lemon");
			
			this.productQuantity++;
		}
	}
	
	/**
	 * Pay Fruits'price
	 * @param price
	 */
	public void pay(int price) {
		this.money -= price;
	}
	
	/**
	 * Buyer's current Status
	 */
	public void buyerStatus() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String message = String.format("Buyer's Money : %d\nBuyer's Product Quantity : %d", this.money, this.productQuantity);
		return message;
	}

}
