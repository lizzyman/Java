package com.ktds.lizzy;

public class Barista {

	public void coffee(CoffeeMachine coffeeMachine) {
		
		if ( coffeeMachine instanceof EspressoMachine ) {
			System.out.println("=====EspressoMachine=====");
		}
		else if ( coffeeMachine instanceof LatteMachine ) {
			System.out.println("=====LatteMachine=====");
		}
		else if ( coffeeMachine instanceof ChocoLatteMachine ) {
			System.out.println("=====ChocoLatteMachine=====");
		}
		
		coffeeMachine.espresso();
		coffeeMachine.latte();

	}
	
}