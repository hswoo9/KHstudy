package com.kh.array.practice;

import java.util.Arrays;

public class B_ArrayCopy {
	/*
	 * 배열의 복사
	 * 
	 * 1. 얕은 복사
	 *   - 배열의 주소만 복사한다.
	 *   
	 * 2. 깊은 복사
	 *   - 동일한 새로운 배열을 하나 생성해서 내부의 값들도 함께 복사한다.
	 */
	
	// 얕은 복사
	public void method1() {
//		int num1 = 10;
//		int num2 = num1;
//		
//		System.out.println(num1);
//		System.out.println(num2);
//		
//		num1 = 20;
//		System.out.println(num1);
//		System.out.println(num2);
		
		int[] origin = {1, 2, 3, 4, 5};
		int[] copy = origin;
		
		System.out.println(Arrays.toString(origin));
		System.out.println(Arrays.toString(copy));
		
		copy[2] = 30;
		
		System.out.println(Arrays.toString(origin));
		System.out.println(Arrays.toString(copy));		
		
		System.out.println();
		System.out.println(origin);
		System.out.println(copy);
		System.out.println(origin.hashCode());
		System.out.println(copy.hashCode());
	}

	/*
	 * 1. for 문을 이용한 깊은 복사
	 */
	public void method2() {
		int[] origin = {1, 2, 3, 4, 5};
		int[] copy = new int[10];
		
		// 반복문을 통해서 origin에 있는 값들을 copy에 대입한다.
		for (int i = 0; i < origin.length; i++) {
			copy[i] = origin[i];
		}
		
		// 원본 배열 출력
		for (int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		
		System.out.println();
		
		// 복사본 배열 출력
		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		copy[2] = 30; // copy => 1, 2, 30, 4, 5
		System.out.println();
		
		// 원본 배열 출력
		for (int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		
		System.out.println();
		
		// 복사본 배열 출력
		for (int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println(origin);
		System.out.println(copy);
		System.out.println(origin.hashCode());
		System.out.println(copy.hashCode());
	}

	/*
	 * 2. System 클래스에서 제공하는 arraycopy() 메소드를 이용한 깊은 복사
	 *   [표현법]
	 *     System.arraycopy(원본 배열, 복사 시작 인덱스, 복사본 배열, 복사 시작위치, 복사할 길이);
	 */
	public void method3() {
		int[] origin = {1, 2, 3, 4, 5};
		int[] copy = new int[10];
		
		System.arraycopy(origin, 0, copy, 0, origin.length);
		
		// 원본 배열 출력
		for (int value : origin) {
			System.out.print(value + " ");
		}
		
		System.out.println();
		
		// 복사본 배열 출력
		for (int value : copy) {
			System.out.print(value + " ");
		}
		
		copy[2] = 77;
		System.out.println();
		
		// 원본 배열 출력
		for (int value : origin) {
			System.out.print(value + " ");
		}
		
		System.out.println();
		
		// 복사본 배열 출력
		for (int value : copy) {
			System.out.print(value + " ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println(origin);
		System.out.println(copy);
		System.out.println(origin.hashCode());
		System.out.println(copy.hashCode());
	}

	/*
	 * 3. Arrays 클래스에서 제공하는 copyOf() 메소드를 이용한 깊은 복사
	 *   [표현법]
	 *     Arrays.copyOf(원본 배열, 복사본 배열 길이);
	 */
	public void method4() {
		int[] origin = {1, 2, 3, 4, 5};
		int[] copy = null;
		
		copy = Arrays.copyOf(origin, 10);
				
		// 원본 배열 출력
		for (int value : origin) {
			System.out.print(value + " ");
		}
		
		System.out.println();
		
		// 복사본 배열 출력
		for (int value : copy) {
			System.out.print(value + " ");
		}
		
		System.out.println();
		System.out.println(origin);
		System.out.println(copy);
	}
	
	/*
	 * 4. 배열의 clone() 메소드를 이용하는 방법
	 */
	public void method5() {
		int[] origin = {1, 2, 3, 4, 5};
		int[] copy = null;
		
		copy = origin.clone();
		
		// 원본 배열 출력
		for (int value : origin) {
			System.out.print(value + " ");
		}
		
		System.out.println();
		
		// 복사본 배열 출력
		for (int value : copy) {
			System.out.print(value + " ");
		}
		
		copy[2] = 70;
		System.out.println();
		System.out.println();
		
		// 원본 배열 출력
		for (int value : origin) {
			System.out.print(value + " ");
		}
		
		System.out.println();
		
		// 복사본 배열 출력
		for (int value : copy) {
			System.out.print(value + " ");
		}
		
		System.out.println();
		System.out.println(origin);
		System.out.println(copy);
	}
}
