package com.ktds.lizzy;

import com.ktds.lizzy.person.*;
import com.ktds.lizzy.machine.VendingMachine;

public class Transaction {
	
	public void start() {
		System.out.println("<User's info>");
		User lizzy = new User(2000);
		
		System.out.println("\n<Vending machine's info>");
		int[] productQuantity = {10, 5, 3};
		VendingMachine vendingMachine = new VendingMachine(10000, productQuantity);
		
		System.out.println("\n=====Transaction Start!=====");
		lizzy.buy(vendingMachine, "Soda", 700);
		System.out.println("=====Transaction Finish!=====\n");
		
		System.out.println("<User's info>");
		System.out.println(lizzy);
		
		System.out.println("\n<Vending machine's info>");
		System.out.println(vendingMachine);
	}

	public static void main(String[] args) {
		
		new Transaction().start();
		
	}

}
