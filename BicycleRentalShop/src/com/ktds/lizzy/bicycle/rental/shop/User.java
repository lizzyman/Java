package com.ktds.lizzy.bicycle.rental.shop;

public class User {
	
	private int money;
	private int bicycleQuantity = 0;
	
	public User(int money) {
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getBicycleQuantity() {
		return bicycleQuantity;
	}
	
	public void setBicycleQuantity(int bicycleQuantity) {
		this.bicycleQuantity = bicycleQuantity;
	}
	
	public void rentBicycle(Shop shop, int bicycleQuantity){
		shop.giveBicycle(bicycleQuantity);
		
		int rentalFee = (bicycleQuantity * shop.getRentalFee());
		this.giveMoney(shop, rentalFee);
		
		this.getBicycle();
	}
	
	public void giveMoney(Shop shop, int rentalFee) {
		shop.receiveMoney(rentalFee);
		money -= rentalFee;
	}
	
	public void getBicycle() {
		bicycleQuantity++;
	}
	
	@Override
	public String toString() {
		String message = String.format("자전거 보유 수 : %d대\n보유금액 : %d원\n", bicycleQuantity, money);
		return message;
	}
	

}
