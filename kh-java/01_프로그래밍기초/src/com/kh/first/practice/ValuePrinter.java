package com.kh.first.practice;

public class ValuePrinter {
	public void print() {
//		1. 숫자 출력
		System.out.println(123); // 정수값을 출력
		System.out.print(3.14); // 실수값을 출력
		System.out.println();
		
//		2. 연산 결과 출력
		System.out.println(40 + 125); // 165
		System.out.println(1.23 - 0.12); // 1.11(X) => 실수값 연산은 오차가 생길 수 있다.
		
//		3. 문자 출력
		System.out.println('a');
		System.out.println('b');
//		문자와 숫자를 연산하면 문자의 코드값과 숫자의 연산 결과를 출력한다. (b: 98)
		System.out.println('b' + 1);
		System.out.println((char)('b' + 1));
		
//		4. 문자열 출력
		System.out.println("안녕하세요.");
		System.out.println("반갑습니다.");
		
//		5. 문자열과 그 외의 값들의 덧셈 연산
		System.out.println("반갑습니다." + 123);
		System.out.println(123 + "반갑습니다.");
		System.out.println("반갑습니다." + "네~~~");
		System.out.println("123" + 456);
		System.out.println("반갑습니다." + (40 + 125));
		
//		6. printf() 메소드
//		  1) %d 서식 지정자
		System.out.printf("%d + %d = %d\n", 10, 20, 30);
//		System.out.println(10 + " + " + 20 + " = " + 30);
		System.out.printf("%5d\n", 10);
		System.out.printf("%-5d\n", 10);
//		System.out.printf("%d + %d = %d\n", 10, 20); // 에러 발생 (서시 지정자에 해당하는 값들이 모두 존재해야 한다.)
		
//		  2) %f 서식 지정자
		System.out.printf("%f\t%f\n", 3.14, 3.1415927);
		System.out.printf("%.2f\t%.3f\n", 3.14, 3.1415927);
		
//		  3) %c, %s 서식 지정자
		System.out.printf("\'%c\' %s\n", 'A', "\"Hello\"");
	}
}
