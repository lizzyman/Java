package com.ktds.lizzy;

public class AppleComputer implements Computer, FaceTime{

	@Override
	public void input() {
		System.out.println("Input with Apple mouse and Apple keyboard");
	}

	@Override
	public void output() {
		System.out.println("Output with Apple monitor");
	}

	@Override
	public void compute() {
		System.out.println("Compute with Apple CPU");
	}

	@Override
	public void store() {
		System.out.println("Store with Samsung SSD");
	}
	
	public void faceTime() {
		System.out.println("Face Time with Apple Computer");
	}

}
