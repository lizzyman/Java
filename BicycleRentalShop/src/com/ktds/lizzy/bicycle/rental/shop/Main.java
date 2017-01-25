package com.ktds.lizzy.bicycle.rental.shop;

import java.util.Scanner;

public class Main {
	
	public void start() {
		
		Scanner input = new Scanner(System.in);
		
		Shop shop = new Shop(100, 1000000);
		
		User user = new User(45000);
		
		showShopStatus(shop);
		System.out.println();
		showUserStatus(user);
		
		int bicycleQuantity;
		System.out.println("How many bicycles do you want to rent?");
		bicycleQuantity = input.nextInt();
		
		String message = String.format("User rent %d bicycle(s).", bicycleQuantity);
		System.out.println(message);
		user.rentBicycle(shop, bicycleQuantity);
		
		showShopStatus(shop);
		System.out.println();
		showUserStatus(user);
		
	}
	
	public void showShopStatus(Shop shop) {
		System.out.println("==============================");
		System.out.println("자전거 대여점 현황");
		System.out.println("------------------------------");
		System.out.println(shop);
		System.out.println("==============================");
	}
	
	public void showUserStatus(User user) {
		System.out.println("==============================");
		System.out.println("사용자 현황");
		System.out.println("------------------------------");
		System.out.println(user);
		System.out.println("==============================");
	}

	public static void main(String[] args) {
		new Main().start();
	}
	
}
