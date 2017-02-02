package com.ktds.lizzy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExam {
	
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("banana", "바나나");
		map.put("apple", "사과");
		
		String korean = map.get("apple");
		System.out.println(korean);
		
		//<String>은 key의 type
		Set<String> keySet = map.keySet();
		Iterator<String> keys = keySet.iterator();
		
		String key = "";
		while (keys.hasNext()) {
			key = keys.next();
			System.out.println(map.get(key));
		}
	
		//바나나 요소를 삭제함 (잘 사용하지 않음)
		//map.remove("banana");
		
	}
	
}
