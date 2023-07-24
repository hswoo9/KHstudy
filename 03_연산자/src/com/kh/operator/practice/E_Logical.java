package com.kh.operator.practice;

import java.util.Scanner;

public class E_Logical {
	public void method1() {
		// 사용자가 입력한 정수값이 1 부터 100 사이의 값인지 확인
		int number = 0;
		boolean result = false;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("임의의 정수를 입력해 주세요. > ");
		number = scanner.nextInt();
		
		// 1 <= number <= 100
//		result = 1 <= number <= 100;
		result = (number >= 1) && (number <= 100);
		
		System.out.printf("%d은(는) 1 부터 100 사이의 값인가요? : %b\n", number, result);
		
		scanner.close();
	}
	
	public void method2() {
		// Short Cut Evaluation
		int number = 10;
		boolean result = false;
		
//		&& 연산자를 기준으로 앞에서 이미 false가 나왔기 때문에 굳이 뒤쪽의 연산은 수행하지 않는다.
		result = (number < 5) && (++number > 0);
		
		System.out.println(result);
		System.out.println(number);
		
//		|| 연산자를 기준으로 앞에서 이미 true가 나왔기 때문에 굳이 뒤쪽의 연산은 수행하지 않는다.
		result = (number < 20) || (++number > 0);
		
		System.out.println(result);
		System.out.println(number);
	}
	
	/*
	 * 실습 문제 
	 * 
	 * 사용자가 입력한 문자 값이 알파벳 대문자인지 확인하기
	 * 'A' ~ 'Z' 까지가 코드값으로 65 ~ 90까지의 숫자로 나열되어 있다.
	 */
	public void practice() {
		char ch = '\u0000';
		boolean result = false;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("문자 하나 입력 > ");
		ch = scanner.nextLine().charAt(0);
		
		// 'A' <= ch <='Z'
		result = (ch >= 'A') && (ch <='Z');
		
		System.out.println("사용자가 입력한 값이 대문자입니까? : " + result);		
		
		scanner.close();
	}
}
