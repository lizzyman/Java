package com.ktds.lizzy.room;

public class Room {
	public static void main(String[] args) {
		
		AirConditioner airConditioner = new AirConditioner();
		airConditioner.powerOn();
		airConditioner.cooling();
		
		AirCleaner aircCleaner = new AirCleaner();
		aircCleaner.powerOn();
		
	}
}
