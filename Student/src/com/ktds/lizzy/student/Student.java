
package com.ktds.lizzy.student;

import java.util.Scanner;

public class Student {
	
	Scanner input = new Scanner(System.in);
	
	private String name;
	private int age;
	private String gender;
	
	public void setName() {
		System.out.println("What is your Name?");
		name = input.next();
	}
	
	public void changeName(String name) {
		if (name.length() >= 3) {
			this.name = name;
			System.out.println("Change your name successfully!");
		}
		else {
			System.out.println("Could not change your name...");
		}
	}
	
	public void setAge() {
		System.out.println("What is your Age?");
		age = input.nextInt();
	}
	
	public void setGender() {
		System.out.println("What is your gender?");
		gender = input.next();
	}
	
	public void showStudentInfo() {
		System.out.printf("Name : %s\n", name);
		System.out.printf("Age : %d\n", age);
		System.out.printf("Name : %s\n", gender);
	}
	
}
