package com.ktds.lizzy.coffee;

public class CoffeeMachine {
	
	protected int atm = 9;
	
	public void espresso() {
		System.out.println(atm + "기압으로 에스프레소를 추출합니다.");
	}
	
	public void latte() {
		System.out.println(atm + "기압으로 라떼를 추출합니다.");
	}

}
