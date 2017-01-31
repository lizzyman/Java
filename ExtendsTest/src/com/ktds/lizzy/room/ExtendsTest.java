package com.ktds.lizzy.room;

public class ExtendsTest {
	
	public void start(){
		String str = "Extends Test";
		
		Object obj = new String(str);
		
		System.out.println(obj);
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		ExtendsTest extendsTest = new ExtendsTest();
		extendsTest.start();
		extendsTest.equals("");
	}
}
