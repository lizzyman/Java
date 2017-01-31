package com.ktds.lizzy;

public class SamsungComputer implements Computer{

	@Override
	public void input() {
		System.out.println("Input with Samsung mouse and Samsung keyboard");
	}

	@Override
	public void output() {
		System.out.println("Output with Samsung monitor");
	}

	@Override
	public void compute() {
		System.out.println("Compute with Samsung CPU");
	}

	@Override
	public void store() {
		System.out.println("Store with China SSD");
	}

}
