package com.kh.exception.practice;

import java.util.Scanner;

public class C_UnCheckedException {
	/*
	 * UnCheckedException
	 *   - 컴파일 시 예외 처리 코드가 있는지 검사하지 않는 예외를 말한다.
	 *   - RuntimeException 클래스를 상속하고 있는 예외를 UnCheckedException이라 한다.
	 *   - 프로그램 실행할 때 문제가 발생되는 것으로 충분히 예측이 가능하기 때문에 조건문들을 통해서 처리가 가능하다.
	 *   
	 * RuntimeException의 후손들
	 *   - NullPointerException
	 *   - ClassCastException
	 *   - ArithmeticException
	 *   - ArrayIndexOutOfBoundsException
	 *   - NegativeArraySizeException
	 */
	public void method1() {
		// ArithmeticException
		int number1 = 0;
		int number2 = 0;
		int result = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수 > ");
		number1 = scanner.nextInt();
		
		System.out.print("정수 > ");
		number2 = scanner.nextInt();
		
//		if(number2 == 0) {
//			System.out.println("0으로는 나눌 수 없습니다.");
//			
//			scanner.close();
//			return;
//		}
		
		
		try {
			result = number1 / number2;
			
			System.out.println("result : " + result);
		} catch (ArithmeticException e) {
			System.out.println("0으로는 나눌 수 없습니다.");
		} finally {
			scanner.close();			
		}
	}

	public void method2() {
		// ArrayIndexOutOfBoundsException, NegativeArraySizeException
		int size = 0;
		int[] array = null;
		Scanner scanner = new Scanner(System.in);
		
//		System.out.print("배열의 길이 > ");
//		size = scanner.nextInt();
		
//		if (size <= 0) {
//			System.out.println("양수를 입력해 주세요.");
//			scanner.close();
//			
//			return;
//		}
		
		try {
			System.out.print("배열의 길이 > ");
			size = scanner.nextInt();
			
			array = new int[size];
			
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
			}		
		} catch (NegativeArraySizeException | ArrayIndexOutOfBoundsException e) {
			System.out.println("잘못된 배열의 길이를 입력하셨거나 잘못된 인덱스에 접근하셨습니다.");
		} catch(Exception e) {
			System.out.println("오류가 발생했습니다. 관리자에게 문의해 주세요.");
		} finally {			
			scanner.close();
		}
	}
}
