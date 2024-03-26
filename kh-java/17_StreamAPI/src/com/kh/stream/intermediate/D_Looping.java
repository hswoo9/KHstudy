package com.kh.stream.intermediate;

import java.util.Arrays;

public class D_Looping {
	/*
	 * 반복
	 *   - 요소 전체를 반복하는 역할을 한다.
	 *   	- peek()
	 *   	  - 중간 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용한다.
	 *   	- forEach()
	 *        - 최종 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용한다.
	 */
	public void method1() {
		int sum = 0;
		int[] array = {1, 2, 3, 4, 5};

//		최종 처리 메소드를 호출한 이후에는 다른 최종 처리 메소드를 호출할 수 없다. 
//		sum = Arrays.stream(array)
//					.filter((int i) -> {return i % 2 == 0;})
//					.forEach(System.out::println)
//					.sum();
		
//		최종 처리 메소드가 호출되어야 동작한다.
//		Arrays.stream(array)
//			  .filter(i -> i % 2 == 0)
//			  .peek(System.out::println);
		
		sum = Arrays.stream(array)
				.filter(i -> i % 2 == 0)
				.peek(System.out::println)
				.sum();
		
		System.out.println("Sum : " + sum);
	}
}
