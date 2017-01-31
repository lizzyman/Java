package com.ktds.lizzy;

public class LgComputer implements Computer{

	@Override
	public void input() {
		System.out.println("Input with LG mouse and LG keyboard");
	}

	@Override
	public void output() {
		System.out.println("Output with LG monitor");
	}

	@Override
	public void compute() {
		System.out.println("Compute with Taiwan CPU");
	}

	@Override
	public void store() {
		System.out.println("Store with LG SSD");
	}

}
