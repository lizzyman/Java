package com.ktds.lizzy.vo;

public class BasketVO {
	
	private int money;
	private int productQuantity;
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	public void minusProductQuantity() {
		this.productQuantity--;
	}

}
