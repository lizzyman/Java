package com.ktds.lizzy.coffee;

public class Cafe2 {
	
	public static void main(String[] args) {
		
		CoffeeMachine coffeMachine = new CoffeeMachine();
		LatteMachine latteMachine = new LatteMachine();
		
		Barista barista = new Barista();
		barista.coffee(coffeMachine);
		barista.coffee(latteMachine);
		
	}

}
