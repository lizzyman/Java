package com.ktds.lizzy;

import java.util.Scanner;
import com.ktds.lizzy.person.*;
import com.ktds.lizzy.machine.VendingMachine;

public class Transaction {
	
	public void start() {
		Scanner input = new Scanner(System.in);
		 
		System.out.println("<User's info>");
		User lizzy = new User(2000);
		
		System.out.println("\n<Vending machine's info>");
		int[] productQuantity = {10, 5, 3};
		VendingMachine vendingMachine = new VendingMachine(10000, productQuantity);
		
		int inputMoney = 0; 
		String productName;
		String stopSign;
		
		while(true) {
			
			System.out.println("\n=====Transaction Start!=====");
			
			System.out.println("Put your Money to the Vending Machine.");
			inputMoney = input.nextInt();
			
			System.out.println("What do you want to drink? [Coke, Soda, MilkTea]");
			productName = input.next();
			
			lizzy.buy(vendingMachine, productName, inputMoney);
			
			System.out.println("Do you want to Continue? (y/n)");
			stopSign = input.next();
			
			if (stopSign.equals("n")) {
				System.out.println("=====Transaction Finish!=====\n");
				break;		
			}
			else if (stopSign.equals("y"))
				System.out.println("=====Transaction Continue!=====\n");
			else 
				System.out.println("You answered WRONG!!! Try Again.");
			
		}

		System.out.println("<User's info>");
		System.out.println(lizzy);
		
		System.out.println("\n<Vending machine's info>");
		System.out.println(vendingMachine);
	}

	public static void main(String[] args) {
		
		new Transaction().start();
		
	}

}
