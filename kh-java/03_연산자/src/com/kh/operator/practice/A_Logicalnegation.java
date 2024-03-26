package com.kh.operator.practice;

public class A_Logicalnegation {
	/*
	 * 논리 부정 연산자
	 *   [표현법]
	 *     !논리값(true, false)
	 *     
	 *     - 논리 값을 반대로 바꾸는 연산자이다. (true -> false, false -> true)
	 */
	
	public void method1() {
		boolean b1 = true;
		boolean b2 = false;
		
		System.out.println("b1 : " + b1);
		System.out.println("b1의 부정 : " + !b1);
		System.out.println("b1 : " + b1);
		
		System.out.println();
		
		System.out.println("b2 : " + b2);
		System.out.println("b2의 부정 : " + !b2);
		System.out.println("b2 : " + b2);
	}
}
