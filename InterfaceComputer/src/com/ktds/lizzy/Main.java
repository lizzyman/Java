package com.ktds.lizzy;

public class Main {
	
	public static void main(String[] args) {
		
		Computer samsungComputer = new SamsungComputer();
		
		samsungComputer.input();
		samsungComputer.compute();
		samsungComputer.store();
		samsungComputer.output();
		
		Computer lgComputer = new LgComputer();
		
		lgComputer.input();
		lgComputer.compute();
		lgComputer.store();
		lgComputer.output();
		
		FaceTime appleComputer = new AppleComputer();
		
		appleComputer.input();
		appleComputer.compute();
		appleComputer.store();
		appleComputer.output();
		appleComputer.faceTime();
	}
	
}
