package com.kh.operator.practice;

public class B_InDecrease {
	/*
	 * 증감 연산자
	 *   [표현법]
	 *     (증감 연산자)값; 또는 값(증감 연산자);
	 *     
	 *   - 증감 연산자는 피연산자의 값을 1 증가시키거나 1 감소시키는 연산자이다.
	 *   - ++ : 피연산자의 값을 1 증가시키는 연산자
	 *   - -- : 피연산자의 값을 1 감소시키는 연산자
	 *   - (증감 연산자)값 : 전위 연산으로 먼저 증감 연산을 수행하고 다른 연산을 수행한다.
	 *   - 값(증감 연산자) : 후위 연산으로 먼저 다른 연산을 수행하고 증감 연산을 수행한다.
	 */
	
	public void method1() {
		int number = 10;
		
		// 전위 연산자 테스트
		System.out.println("전위 연산자 적용 전 number의 값 : " + number); // 10
		System.out.println("1회 수행 후 값 : " + ++number); // 11, number = number + 1; 과 같은 결과를 만들어낸다.
		System.out.println("2회 수행 후 값 : " + ++number); // 12
		System.out.println("3회 수행 후 값 : " + ++number); // 13
		System.out.println("전위 연산자 적용 후 number의 값 : " + number); // 13
		System.out.println();
		
		// 후위 연산자 테스트
		System.out.println("후위 연산자 적용 전 number 값 : " + number); // 13
		System.out.println("1회 수행 후 값 : " + number++); // 13
		System.out.println("2회 수행 후 값 : " + number++); // 14
		System.out.println("3회 수행 후 값 : " + number++); // 15
		System.out.println("후위 연산자 적용 후 number 값 : " + number); //16
	}

	public void method2() {
		int number = 20;
		int result = number++ * 3; // 20 * 3 = 60
		
		System.out.println("number : " + number); // 21
		System.out.println("result : " + result); // 60
		
		int number1 = 10;
		int number2 = 20;
		int number3 = 30;
		
		System.out.println(number1++); // 10(11)
		System.out.println((++number1) + (number2++)); // 12 + 20(21) = 32
		System.out.println((number1++) + (--number2) + (--number3)); // 12(13) + 20 + 29 = 61
		
		System.out.println("number1 : " + number1); // 13
		System.out.println("number2 : " + number2); // 20
		System.out.println("number3 : " + number3); // 29
	}
}
