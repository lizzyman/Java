package com.ktds.lizzy.test;

import java.io.File;

public class FileTest {
	
	public static void main(String[] args) {
		String folderPath = "/Users/Lizzyman/Languages"; // '\' = Escape 문자, '\\' = Drive를 나타냄 (자바는 /,\ 둘 다 사용 가능)
		
		//파일 경로(folderPath)를 읽어온다.
		File languagesFolder = new File(folderPath);
		
		//languagesFolder의 경로가 폴더(디렉토리)인지 파일인지 구분한다.
		if (languagesFolder.isDirectory()) {
			System.out.println(languagesFolder.getAbsolutePath() + "는 폴더(디렉토리)입니다.");
		}
		else {
			System.out.println(languagesFolder.getAbsolutePath() + "는 폴더(디렉토리)가 아닙니다.");
		}
		
		File javaFolder = new File(languagesFolder.getAbsolutePath() + File.separator + "Java");
		
		if (javaFolder.isDirectory()) {
			System.out.println(javaFolder.getAbsolutePath() + "는 폴더(디렉토리)입니다.");
		}
		else {
			System.out.println(javaFolder.getAbsolutePath() + "는 폴더(디렉토리)가 아닙니다.");
		}
		
		//javaFolder 안에 있는 내용물들을 가져온다.
		String[] contents = javaFolder.list();
		for (String content : contents){
			System.out.println(content);
		}
	}
	
}
