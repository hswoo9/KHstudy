package com.kh.operator.practice;

import java.util.Scanner;

public class D_Comparison {
	/*
	 * 비교 연산자
	 *   a < b : a가 b보다 작은가?
	 *   a > b : a가 b보다 큰가?
	 *   a <= b : a가 b보다 작거나 같은가?
	 *   a >= b : a가 b보다 크거나 같은가?
	 *   a == b : a와 b가 같은가?
	 *   a != b : a와 b가 같지 않은가?
	 *   
	 *   - 비교 연산의 조건을 만족하면 true, 만족하지 않으면 false를 반환한다.
	 */
	
	public void method1() {
		// 관례상 잘 사용하지 않는다.
		int num1 = 10, num2 = 25, num3 = 0;
		
		System.out.println("num1 == num2 : " + (num1 == num2));
		System.out.println("num1 != num2 : " + (num1 != num2));
		System.out.println("num1 <= num2 : " + (num1 <= num2));
		System.out.println("num1 > num2 : " + (num1 > num2));
		
		System.out.println();
		
		System.out.println('A' == 65); // 65 == 65
		System.out.println(3 == 3.0); // 3.0 == 3.0
		// 단, 예외가 있다.
		// 부동 소수점 방식은 오차가 생길 수 있기 때문에 대부분의 비교 연산에서는 정수 타입을 사용한다.
		System.out.println(0.1 == 0.1f);		
	}

	public void method2() {
		// 산술 연산 + 비교 연산
		// 사용자에게 입력받은 값이 짝수인지, 홀수인지 판단
		int number = 0;
		boolean result = false;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("임의의 정수를 입력해 주세요. > ");
		number = scanner.nextInt();
		
		result = ((number % 2) == 0);
		
		System.out.printf("%d는 짝수인가요? %b\n", number, result);
		
		scanner.close();
	}


}
