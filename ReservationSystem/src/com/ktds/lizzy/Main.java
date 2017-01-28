package com.ktds.lizzy;

public class Main {

	public void start() {
		ReservationProgram reservationProgram = new ReservationProgram();
		User lizzy = new User("lizzy", 24, "010-4629-2678");
		
		reservationProgram.startProgram(lizzy);
	}
	
	public static void main(String[] args) {
		new Main().start();
	}
	
}
