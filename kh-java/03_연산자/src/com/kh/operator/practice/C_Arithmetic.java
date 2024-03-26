package com.kh.operator.practice;

public class C_Arithmetic {
	/*
	 * 산술 연산자
	 *   + (더하기)
	 *   - (빼기)
	 *   * (곱하기)
	 *   / (나누기)
	 *   % (나머지)
	 */
	
	public void method1() {
		// 정수의 산술 연산
		int number1 = 10;
		int number2 = 3;
		
		System.out.println("number1 + number2 = " + (number1 + number2));
		System.out.println("number1 - number2 = " + (number1 - number2));
		System.out.println("number1 * number2 = " + (number1 * number2));
		System.out.println("number1 / number2 = " + (number1 / number2));
		System.out.println("number1 % number2 = " + (number1 % number2));
		System.out.println();
		
		// 실수의 산술 연산
		double dNumber1 = 35.0;
		double dNumber2 = 10.0;
		
		System.out.println("dNumber1 + dNubmer2 = " + (dNumber1 + dNumber2));
		System.out.println("dNumber1 - dNubmer2 = " + (dNumber1 - dNumber2));
		System.out.println("dNumber1 * dNubmer2 = " + (dNumber1 * dNumber2));
		System.out.println("dNumber1 / dNubmer2 = " + (dNumber1 / dNumber2));
		System.out.println("dNumber1 % dNubmer2 = " + (dNumber1 % dNumber2));
		
		// 참고
//		System.out.println(5 / 0); // ArithmeticException
		System.out.println(5 / 0.0); // Infinity
		System.out.println(5 % 0.0); // NaN (Not a Number)
		System.out.println((5 / 0.0) + 10); // Infinity
		System.out.println(Double.isInfinite(5 / 0.0));
		System.out.println(Double.isNaN(5 % 0.0));
	}
}
