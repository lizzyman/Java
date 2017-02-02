package com.ktds.lizzy;

import java.util.Scanner;

public class EXCEPTION {

	public static void main(String[] args) {
		
			try {
				convertStringToNumber(null);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("문자를 다시 생성합니다.");
			}
	}
	
	public static void convertStringToNumber(String str) throws Exception{
		if (str == null) {
			throw new Exception("파라미터를 작성해주세요.");
		}
		int convertedNumber = Integer.parseInt("NUMBER");
	}

}
