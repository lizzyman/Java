package com.ktds.lizzy.news.board;

import java.util.Scanner;

import com.ktds.lizzy.news.board.biz.NewsBoardBiz;
import com.ktds.lizzy.news.board.biz.NewsBoardBizImpl;

public class NewsBoardController {
	
	private Scanner input = new Scanner(System.in);
	private int chooseMenu;
	
	public void start() {
		NewsBoardBiz newsBoradBiz = new NewsBoardBizImpl();
		
		while (true) {
			System.out.println("************News Board************");
			System.out.println("1. Show all News\n2. Add new News\n3. Exit");
			System.out.println("**********************************");
			chooseMenu = input.nextInt();
			
			if (chooseMenu == 1) {
				newsBoradBiz.queryAllNews();
			}
			else if (chooseMenu == 2) {
				newsBoradBiz.addNewNews();
			}
			else if (chooseMenu == 3) {
				System.out.println("Exit Program...");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		
		new NewsBoardController().start();
		
	}

}
