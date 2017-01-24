package com.ktds.lizzy;

import com.ktds.lizzy.buyer.Buyer;
import com.ktds.lizzy.seller.Seller;

public class Store {
	
	public void start() {
		
		System.out.println("---------Initialize---------");
		int[] productQuantity = {10, 25, 17}; // Melon, Apple, Lemon 's Quantity
		Buyer lizzy = new Buyer(7000000, 0);
		Seller easy = new Seller(500000, productQuantity);
		
		System.out.println("<Buyer>");
		System.out.println(lizzy);
		
		System.out.println("\n<Seller>");
		System.out.println(easy);

		lizzy.buy(easy, "Melon");
		lizzy.buy(easy, "Lemon");
		
		System.out.println("\n---------Shopping Result---------");
		System.out.println("<Buyer>");
		lizzy.buyerStatus();
		System.out.println("\n<Seller>");
		easy.sellerStatus();
		
	}
	
	public static void main(String[] args) {
		new Store().start();
	}

}
