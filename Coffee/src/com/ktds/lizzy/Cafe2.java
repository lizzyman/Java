package com.ktds.lizzy;

public class Cafe2 {
	
	public static void main(String[] args) {
		
		CoffeeMachine espressoMachine = new EspressoMachine();
		CoffeeMachine latteMachine = new LatteMachine();
		CoffeeMachine chocoLatteMachine = new ChocoLatteMachine();
		
		Barista barista = new Barista();
		
		barista.coffee(espressoMachine);
		barista.coffee(latteMachine);
		barista.coffee(chocoLatteMachine);
		
	}

}
