package com.ktds.lizzy;

import com.ktds.lizzy.exception.*;

public class Student {
	
	public void start() throws AnotherTestException {
		try {
			registNewStudent();
		} 
		catch (MissingValueException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Finally 여기까지 왔군~~~~");
		}
		
		System.out.println("프로그램 죽지 않고 살아있따.");
	}
	
	public void registNewStudent() throws MissingValueException, AnotherTestException {
		String name = "";
		String school = "ktds";
		String test = "test";
		
		if (name == null) {
			// Exception
			throw new MissingValueException("이름은 필수 입력 값입니다.");
		}
		if (!school.equals("ktds")) {
			//RuntimeException
			throw new MismatchValueException("학교 이름이 잘못되었습니다.");
		}
		if (!test.equals("test")) {
			// Exception
			throw new AnotherTestException("Test Exception입니다.");
		}
	}

	public static void main(String[] args) {
		
		try {
			new Student().start();
		} catch (AnotherTestException e) {
			e.printStackTrace();
		}
		
	}
	
}
