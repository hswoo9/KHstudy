package com.kh.chapter3.map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;

public class B_Properties {
	// Properties를 생성하고 저장, 출력 테스트
	public void method1() {
		/*
		 * Properties
		 *   - Map 계열이다.
		 *   - Key, Value 세트로 저장된다.
		 *   - Key, Value는 String으로 제한되어 있다.
		 */
		Properties prop = new Properties();
		
		// 순서 유지 X, 키값 중복 X
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Set", "TreeSet");
		prop.setProperty("Map", "HashMap");
		
		System.out.println(prop);
		System.out.println();
		
		// value 값을 읽어오기
		System.out.println(prop.getProperty("Set"));
		System.out.println(prop.getProperty("Music", "뉴진스"));
		System.out.println();
		
		for(Entry<Object, Object> entry : prop.entrySet()) {
			System.out.printf("key : %s, value : %s\n", entry.getKey(), entry.getValue());
		}
	}

	// Properties 파일 생성 및 저장
	public void fileSave() {

		// Properties 파일 생성 및 저장
		Properties prop = new Properties();
		
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		
		try {
//			prop.store(new FileOutputStream("test1.properties"), "Properties Test 1");
//			prop.store(new FileWriter("test2.properties"), "Properties Test 2");
			prop.storeToXML(new FileOutputStream("test3.xml"), "XML Test");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	// Properties 파일에서 데이터 읽기
	public void fileRead() {
		Properties prop = new Properties();
		
		try {
//			prop.load(new FileInputStream("test1.properties"));
//			prop.load(new FileReader("test2.properties"));
			prop.loadFromXML(new FileInputStream("test3.xml"));
			
			System.out.println(prop);
			System.out.println();
			
			System.out.println(prop.getProperty("List"));
			System.out.println(prop.getProperty("Set"));
			System.out.println(prop.getProperty("Map"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
