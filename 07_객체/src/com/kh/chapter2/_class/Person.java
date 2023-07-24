package com.kh.chapter2._class;

/*
 * 클래스에서 사용 가능한 접근 제한자
 *  1. public
 *    - public으로 선언된 클래스를 아무런 제약없이 사용할 수 있다.
 *  
 *  2. default
 *    - 클래스를 선언할 때 접근 제한자를 생략했다면 default 접근 제한을 갖는다.
 *    - 동일한 패키지에는 아무런 제약없이 사용할 수 있지만 다른 패키지에서는 사용할 수 없도록 접근이 제한된다.
 * 
 * 클래스의 구조
 *   [표현법]
 *   
 *     [접근 제한자] [예약어] class 클래스명 {
 *       1. 필드 정의
 *       [접근 제한자] [예약어] 자료형 필드명 [= 초기값];
 *       ...
 *       
 *       2. 생성자 정의 (필드를 초기화하거나, 객체를 사용할 준비를 한다.)
 *       [접근 제한자] 클래스명([매개변수, ... ]) {
 *         ...
 *       }
 *       ...
 *       
 *       3. 메소드 정의
 *       [접근 제한자] [예약어] 반환형 메소드명([매개변수, ... ]) {
 *         ...
 *         
 *         [return] [반환값];
 *       }
 *       ...
 *       
 *     }
 */
public class Person {
	// 1. 필드 정의
	private String name;
	
	private int age;
	
	private Phone phone = new Phone();
	
	// 2. 생성자 정의
	public Person() {
	}	

	// 3. 메소드 정의
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setPhone(String brand ,String name, String color) {
//		this.phone = new Phone();
		
		this.phone.setBrand(brand);
		this.phone.setName(name);
		this.phone.setColor(color);
	}
	
	public void whoAreYou() {
		System.out.printf("안녕하세요. 저는 %s입니다. 나이는 %d세입니다.\n", name, age);
		System.out.printf("저는 %s의 %s을(를) 가지고 있습니다.", phone.getBrand(), phone.getName());
	}
}
