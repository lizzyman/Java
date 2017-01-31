package com.ktds.lizzy.pccafe;

import com.ktds.lizzy.AppleComputer;
import com.ktds.lizzy.Computer;
import com.ktds.lizzy.LgComputer;
import com.ktds.lizzy.SamsungComputer;

public class HiMart {
	
	public static void main(String[] args) {
		
		Computer[] computers = new Computer[5]; // Computer interface를 객체로 구현할 수 있다.
		
		computers[0] = new SamsungComputer();
		computers[1] = new LgComputer();
		computers[2] = new AppleComputer();
		computers[3] = new SamsungComputer();
		computers[4] = new LgComputer();
		
		for (Computer computer : computers) {
			computer.input();
			computer.compute();
			computer.store();
			computer.output();
			
			if (computer instanceof AppleComputer) {
				((AppleComputer) computer).faceTime();
			}
		}
		
	}
	
}
