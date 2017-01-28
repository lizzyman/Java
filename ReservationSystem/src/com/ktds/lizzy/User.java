package com.ktds.lizzy;

import java.util.Scanner;

public class User {

	private String name;
	private int age;
	private String phoneNumber;
	private int row;
	private int col;
	
	Scanner input = new Scanner(System.in);
	
	public User(String name, int age, String phoneNumber) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public void selectSeat(ReservationProgram reservationProgram) {
		System.out.println("원하는 좌석을 입력해주세요.");
		
		System.out.println("1. 행을 입력해주세요.");
		int row = input.nextInt();
		
		System.out.println("열을 입력해주세요.");
		int col = input.nextInt();
		
		this.pay(row, col, reservationProgram);
	}
	
	public void pay(int row, int col, ReservationProgram reservationProgram) {
		System.out.println("결제를 시도중입니다.");
		System.out.println("결제를 완료하였습니다.");
		
		reservationProgram.setTrainSeat(row-1, col-1);
		this.setRow(row);
		this.setCol(col);
		
		System.out.println("좌석 예매를 완료하였습니다.\n");
	}
	
}
