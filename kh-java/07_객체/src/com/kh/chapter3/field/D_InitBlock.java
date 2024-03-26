package com.kh.chapter3.field;

/*
 * 필드의 초기화 순서
 *   1. 필드
 *     1) JVM이 정한 기본값으로 초기화
 *     2) 명시적 초기화
 *     3) 인스턴스 블록을 이용한 초기화
 *     4) 생성자를 이용한 초기화
 *   
 *   2. 클래스 변수(static 필드)
 *     1) JVM이 정한 기본값으로 초기화
 *     2) 명시적 초기화
 *     3) static 블록을 이용한 초기화
 */
public class D_InitBlock {
	// 1. JVM이 정한 기본값으로 초기화
	private String name;
	
	private static int age;
	
	// 2. 명시적 초기화
	private String phoneName = "아이폰12미니";
	
	private int price = 0;
	
	private static String brand = "애플";
	
	// 3. 초기화 블록을 이용하는 방법
	// 인스턴스 블록
	//  - 필드를 초기화 시키는 블록으로 인스턴스 생성 시마다 실행되고 초기화한다.
	{
		phoneName = "아이폰15프로";
		price = 500000;
		
//		brand = "삼성";
	}
	
	// static 블록
	//  - 클래스 변수를 초기화 시키는 블록으로 프로그램 시작 시 단 한번만 실행되고 초기화 된다.
	static {
		age = 20;
		
//		name = "아이폰";
	}
	
	// 4. 생성자를 이용한 초기화
	public D_InitBlock() {
		phoneName = "아이폰16미니";
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getAge() {
		return age;
	}

	public static void setAge(int age) {
		D_InitBlock.age = age;
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static String getBrand() {
		return brand;
	}

	public static void setBrand(String brand) {
		D_InitBlock.brand = brand;
	}
}
