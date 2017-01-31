package com.ktds.lizzy.coffee;

public class LatteMachine extends CoffeeMachine{
	
	protected int atm = 20;
	
	public LatteMachine() {
		super.atm = 15; 
	}
	
	@Override
	public void latte() {
		System.out.println(atm + "기압으로 카페라떼를 추출합니다.");
	}

}
