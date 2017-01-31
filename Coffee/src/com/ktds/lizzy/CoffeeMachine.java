package com.ktds.lizzy;

public abstract class CoffeeMachine { //abstract가 붙으면 객체화 시킬 수 없다. 그러므로 상속시킨다.
	
	protected int atm = 9;
	
	public void espresso() {
		System.out.println(atm + "기압으로 에스프레소를 추출합니다.");
	}

	public abstract void latte();
	
}
