package com.ktds.lizzy.list;

import java.util.List;
import java.util.ArrayList;

public class ArrayListTest {
	
	public void start() {
		
		// 배열 만들기 
		int[] scoreArray = new int[4];
		
		// 리스트 만드는 방법 
		List<Integer> scoreList = new ArrayList<Integer>();
		
		// 배열에 데이터를 넣는 방법 
		scoreArray[0] = 1;
		scoreArray[1] = 2; 
		scoreArray[2] = 3;
		scoreArray[3] = 4;
		
		// 리스트에 데이터를 넣는 방법 - 개수에 제한 없
		scoreList.add(1);
		scoreList.add(2);
		scoreList.add(3);
		scoreList.add(4);
		scoreList.add(5);
		scoreList.add(6);
		scoreList.add(7);
		
		// 배열 데이터를 출력하는 방법
		// 1. for
		for (int i = 0; i < scoreArray.length; i++) {
			System.out.println(scoreArray[i]);
		}
		// 2. for-each
		for (int score : scoreArray) {
			System.out.println(score);
		}
		
		// 리스트 데이터 출력하는 방법
		// 1. for
		for (int i = 0; i < scoreList.size(); i++) {
			System.out.println(scoreList.get(i));
		}
		// 2. for-each
		for (int score : scoreList) {
			System.out.println(score);
		}
		
		// 배열 데이터 수정하기 (1번 인덱스 값을 10으로 변경)
		scoreArray[1] = 10;
		
		// 리스트 데이터 수정하기 (1번 인덱스 값을 10으로 변경)
		scoreList.set(1, 10); 
		
		// 배열 데이터 삭제하기
		// 불가능...
		
		// 리스트 데이터 삭제하기 (1번 인덱스 삭제)
		scoreList.remove(1);
		
		// 배열 데이터 검색하기 (2가 있는지 확인)
		for (int i = 0; i < scoreArray.length; i++) {
			if (scoreArray[i] == 2)
				System.out.println(i +"번째에 Exist!");
		}
		
		// 리스트 데이터 검색하기 (2가 있는지 확인)
		if (scoreList.contains(2))
			System.out.println(scoreList.indexOf(2) + "번째에 Exist!");
		
	}
	
	public static void main(String[] args) {
		
		new ArrayListTest().start();
		
	}
	
}
