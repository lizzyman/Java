package com.ktds.lizzy;

import com.ktds.lizzy.student.Student;

public class Main {
	
	public static void main(String[] args){
		
		Student student = new Student();
		
		student.setName();
		student.setAge();
		student.setGender();
		
		System.out.println("================");
		
		student.showStudentInfo();
		
		System.out.println("================");

		System.out.println("** Change my name to 'ab' ");
		student.changeName("ab");
		student.showStudentInfo();
		
		System.out.println("================");
		
		System.out.println("** Change my name to 'Jisoo Lee' ");
		student.changeName("Jisoo Lee");
		student.showStudentInfo();
		
		
		
		//student.name = "lizzy"; -> private 이기에 오류 발생 
		
	}

}


