package com.ktds.lizzy.coffee;

public class Cafe {
	public static void main(String[] args) {
		
		System.out.println("======CoffeeMachine======");
		
		CoffeeMachine espressoMachine = new CoffeeMachine();
		
		espressoMachine.espresso();
		
		// Sub class is a Super class.
		System.out.println("======LatteMachine======");
		
		CoffeeMachine latteMachine = new LatteMachine(); // 내부적인 객체 = latteMachine
		
		((LatteMachine)latteMachine).latte(); 
		// LatteMachine latte = (LatteMachine)latteMachine; latte.latte(); 와 같은 의미
		latteMachine.espresso();
		
		System.out.println(espressoMachine);
		System.out.println(latteMachine); 
	}
}
