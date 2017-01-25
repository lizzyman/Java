package com.ktds.lizzy.bicycle.rental.shop;

public class Shop {
	private final int RENTAL_FEE = 5000;
	
	private int bicycleQuantity;
	private int fund;
	
	public Shop(int bicycleQuantity, int fund) {
		this.bicycleQuantity = bicycleQuantity;
		this.fund = fund;
	}
	
	public int getBicycleQuantity() {
		return bicycleQuantity;
	}
	
	public void setBicycleQuantity(int bicycleQuantity) {
		this.bicycleQuantity = bicycleQuantity;
	}
	
	public int getFund() {
		return fund;
	}
	
	public void setFund(int fund) {
		this.fund = fund;
	}
	
	public int getRentalFee() {
		return RENTAL_FEE;
	}
	
	public void giveBicycle(int bicycleQuantity) {
		this.bicycleQuantity -= bicycleQuantity;
	}
	
	public void receiveMoney(int rentalFee) {
		fund += rentalFee;
	}
	
	@Override
	public String toString() {
		String message = String.format("자전거 보유 수 : %d\n대여료 총 합 : %d\n", bicycleQuantity, fund);
		return message;
	}

}
