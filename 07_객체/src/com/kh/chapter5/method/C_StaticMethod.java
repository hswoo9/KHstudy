package com.kh.chapter5.method;

public class C_StaticMethod {
	public static int num1 = 10;
	public static int num2 = 20;
	
	// 1. 매개변수와 반환값이 없는 메소드
	public static void method1() {
		System.out.println(num1 + num2);
		
		C_StaticMethod.num2++;
	}
	
	// 2. 매개변수가 없고 반환값이 있는 메소드
	public static int method2() {
//		int num1 = 30;
//		int num2 = 40;
		
		return C_StaticMethod.num1 + C_StaticMethod.num2;
	}
	
	// 3. 매개변수가 있고 반환값이 없는 메소드
	public static void method3(int num3) { 
		System.out.println(num1 + num2 + num3);
	}
	
	// 4. 매개변수가 있고 반환값도 있는 메소드
	public static int method4(int ... numbers) {
		int sum = 0;
		
		for (int number : numbers) {
			sum += number; // sum = sum + number;
		}
		
		return sum;
	}
}
