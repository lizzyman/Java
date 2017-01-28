package com.ktds.lizzy;

import java.util.Scanner;

public class ReservationProgram {
	
	private final int ROW = 2;
	private final int COL = 12;
	private boolean trainSeat[][];
	
	Scanner input = new Scanner(System.in);
	
	public ReservationProgram() {
		this.trainSeat = new boolean[ROW][COL];
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				this.trainSeat[i][j] = false;
			}
		}
	}
	
	public void setTrainSeat(int row, int col) {
		this.trainSeat[row][col] = true;
	}
	
	public boolean getTrainSeat(int row, int col) {
		return trainSeat[row][col];
	}
	
	public void startProgram(User user) {
		while(true) {
			System.out.println("[기차 좌석 예약 관리 시스템]입니다.");
			System.out.println("필요한 서비스를 입력해주세요.");
			System.out.println("1. 예약\n2. 예약 취소\n3. 프로그램 종료");
			
			int service = input.nextInt();
			
			if (service == 1) {
				this.getReservation(user, this.trainSeat);
			}
			else if (service == 2) {
				this.cancleReservation(user, this.trainSeat);
			}
			else if (service == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
	
	public void showSeatStatus(boolean[][] trainSeat) {
		String seats = "";
		
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (trainSeat[i][j] == false)
					seats += "ㅁ";
				else
					seats += "v";
			}
			seats += "\n";
		}
		
		System.out.println(seats);
	}
	
	public void getReservation(User user, boolean trainSeat[][]) {
		System.out.println("\n예약");
		System.out.println("-----------------------");
		System.out.println("예약이 완료된 좌석은 예매 할 수 없습니다.\nㅁ: 가능 v: 불가능\n");
		
		this.showSeatStatus(this.trainSeat);
		
		user.selectSeat(this);
	}
	
	public void cancleReservation(User user, boolean trainSeat[][]) {
		System.out.println("\n예약 취소");
		System.out.println("-----------------------");
		System.out.println("<현재 예약된 좌석> 행 : " + user.getRow() + " 열 : " + user.getCol() + "\n");
		
		while (true) {
			System.out.println("취소하시겠습니까? (y/n)");
			String cancle = input.next();
			
			System.out.println(cancle);
			
			if (cancle.equals("y")) {
				trainSeat[user.getRow()-1][user.getCol()-1] = false;
				user.setRow(0);
				user.setCol(0);
				
				System.out.println("예매가 취소되었습니다.\n");
				break;
			}
			else if (cancle.equals("n")) {
				System.out.println("예매 취소가 실패했습니다.\n");
				break;
			}
			else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.\n");
			}
		}
	}

}
