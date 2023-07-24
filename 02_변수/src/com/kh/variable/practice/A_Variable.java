package com.kh.variable.practice;

public class A_Variable {
	public void printValue() {
		// 변수를 사용하지 않으면
		System.out.println(10 * 2 * 3.141592); // 원의 둘레 
		System.out.println(10 * 10 * 3.141592); // 원의 넓이
		
		// 변수를 사용하면
		int r = 10;
		int h = 20;
		double pi = 3.141592;
		
		System.out.println(r * 2 * pi);
		System.out.println(r * r * pi);
		System.out.println(pi * r * r * h);  // 원기둥의 부피
	}
	
	public void variableTest() {
		/*
		 * 변수의 선언
		 *   [표현법]
		 *     자료형 변수명;
		 *     
		 *     - 자료형은 어떤 값을 저장할지, 어떤 크기의 메모리를 할당받을지에 대한 정보이다.
		 *     - 변수명은 변수의 이름으로 값을 읽고, 쓰고, 지우는 작업을 할 때 사용한다.
		 *     
		 * 변수의 초기화
		 *   [표현법]
		 *     변수명 = 값;
		 *     
		 *     - '='는 오른쪽 데이터를 왼쪽의 변수에 대입(저장)하는 연산자이다.
		 */
		
		// 논리형
		boolean isTrue; // 1byte의 논리 값을 담을 수 있는 변수를 선언한다.
		
		// 문자형
//		char ch = 90;
//		char ch = -90; // 0 ~ 65,535 (유니코드)
		char ch = 'a'; // 2byte의 문자(유니코드)를 담을 수 있는 변수를 선언한다.
		
		// 정수형
		byte bNum; // 1byte의 정수를 담을 수 있는 변수를 선언한다.
		short sNum; // 2byte의 정수를 담을 수 있는 변수를 선언한다.
		int iNum; // 4byte의 정수를 담을 수 있는 변수를 선언한다.
		long lNum; // 8byte의 정수를 잠을 수 있는 변수를 선언한다.
		
		// 실수형
		float fNum; // 4byte의 실수를 담을 수 있는 변수를 선언한다.
		double dNum; // 8byte의 실수를 담을 수 있는 변수를 선언한다.
		
		// 문자열
//		String name = ""; // 문자열을 가리킬 수 있는 참조형 변수를 선언한다.
//		String name = "문인수";
		String name = new String("문인수");
		
		// 지역 변수를 생성 후 초기화가 되지 않은 경우 사용하려고 하면 에러가 발생한다.
//		System.out.println(isTrue);
		
		isTrue = false; // 선언 후 초기화
//		isTrue = 1; // 에러 발생
		System.out.println("isTrue : " + isTrue);
		
//		bNum = 128; // 에러 발생
		bNum = 11;
		sNum = 12;
		iNum = 300;
//		정수형 리터럴은 기본적으로 int로 컴파일 된다.
//		long 타입 리터럴은 숫자 뒤에 L 또는 l을 입력해야 한다.
//		lNum = 92233;
		lNum = 9223372036854L;
		
		System.out.println("bNum : " + bNum);
		System.out.println("sNum : " + sNum);
		System.out.println("iNum : " + iNum);
		System.out.println("lNum : " + lNum);
		
//		실수형 리터럴은 기본적으로 double 타입으로 컴파일 된다.
//		float 타입의 리터럴은 숫자 뒤에 F 또는 f를 입력해야 한다.
		fNum = 3.14F;
		dNum = 12.34567;
		
		System.out.println("fNum : " + fNum);
		System.out.println("dNum : " + dNum);
		
		System.out.println("ch : " + ch);
		System.out.println("name : " + name);
		
//		변수의 명명 규칙
//		1) 대소문자 구분
		int number;
//		String number; // 자료형이 달라도 변수명이 같으면 에러 발생
		int NUMBER;
		int Number;
		
//		2) 숫자로 시작하면 안 된다.
		int a2g3e4;
//		int 1age;
		
//		3) 특수 문자는 '_', '$'만 사용이 가능하다.
		int _age;
		int a_g_e;
		int age$;
//		int %age;
//		int age@;
		
//		4) 예약어를 사용하면 안 된다.
//		int public;
//		int void;
//		int int;
//		int class;
	}

	public void constant() {
		/*
		 * 상수
		 *   [표현법]
		 *     final 자료형 변수명;
		 *     
		 *     - 변하지 않는 값으로 특정 변수의 값이 변경되는 걸 원하지 않을 때 사용한다.
		 *     - 초기화 이후에는 값을 변경할 수 없다.
		 */
		
		int age;
		final int AGE;
		
		age = 20;
		AGE = 30;
		
		System.out.println("age : " + age);
		System.out.println("AGE : " + AGE);
		
		age = 25;
//		AGE = 35; // 에러 발생
	}
}
