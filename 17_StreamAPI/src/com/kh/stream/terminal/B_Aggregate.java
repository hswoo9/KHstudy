package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class B_Aggregate {
	/*
	 * 기본 집계
	 *   - 최종 처리 기능으로 요소들의 개수, 합계, 평균값, 최대값, 최소값 등과 같이 하나의 값으로 산출하는 역할을 한다.
	 *     - count() : 요소들의 개수를 리턴한다.
	 *     - sum() : 요소들의 합계를 리턴한다.
	 *     - average() : 요소들의 평균을 리턴한다.
	 *     - max() : 최대 요소를 리턴한다.
	 *     - min() : 최소 요소를 리턴한다.
	 *     - findFirst() : 첫 번째 요소를 리턴한다.
	 * 커스텀 집계
	 *   - 스트림에서 기본 집계 메소드를 제공하지만 다양한 집계 결과물을 만들 수 있도록 reduce() 메소드를 제공한다.
	 */
	
	public void method1() {
		int[] array = {1, 2, 3, 4, 5, 6};
//		int[] array = {1, 3, 5};
		
		// 2의 배수의 개수
		long count = Arrays.stream(array).filter(value -> value % 2 == 0).count();
		
		System.out.println(count);
		
		
		// 2의 배수의 합
		int sum = Arrays.stream(array).filter(value -> value % 2 == 0).sum();
		
		System.out.println(sum);
		
		// 2의 배수의 평균
		/*
		 * Optional 클래스
		 *   - 스트림의 결과 값을 저장하는 인스턴스이다.
		 *   - 단순히 값만 저장하는 것이 아니라, 값의 존재 여부를 확인하고 값이 존재하지 않을 경우 디폴트 값을 설정할 수 있는 인스턴스이다.
		 */
		OptionalDouble average = Arrays.stream(array).filter(value -> value % 2 == 0).average();
		
//		Optional 인스턴스에서 저장된 값을 가져온다.
//		System.out.println(average.getAsDouble());
		
//		값의 존재 여부를 확인하고 Optional 인스턴스에서 값을 가져온다.
//		if(average.isPresent()) {
//			System.out.println(average.getAsDouble());
//		} else {
//			System.out.println("데이터가 없음");
//		}
		
//		집계 값을 처리하는 Consumer를 등록한다. (Consumer는 값이 존재해야 실행된다.)
//		average.ifPresent(d -> System.out.println(d));
		
//		get() 메소드와 동일하게 저장되어 있는 값을 얻어오는 메소드로
//		값이 저장되어 있지 않을 경우 디폴트 값을 지정한다.
		System.out.println(average.orElse(0.0));
		
//		2의 배수의 최대값
		OptionalInt max = Arrays.stream(array).filter(value -> value % 2 == 0).max();
		
		System.out.println(max.orElse(0));
		
//		2의 배수의 최소값
		OptionalInt min = Arrays.stream(array).filter(value -> value % 2 == 0).min();
		
		System.out.println(min.orElse(0));
		
//		2의 배수의 첫 번째 요소
		OptionalInt findFirst = Arrays.stream(array).filter(value -> value % 2 == 0).findFirst();
		
		System.out.println(findFirst.orElse(0));
		
		
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
		
		sum = stream.mapToInt(i -> i.intValue()).sum();
		
		System.out.println(sum);
	}

	public void method2() {
		int[] array = {1, 2, 3, 4, 5, 6};
		
		OptionalInt reduce = Arrays.stream(array).reduce((int left, int right) -> {return left * right;});
		
		System.out.println(reduce.getAsInt());
		
		int result = Arrays.stream(array).reduce(2, (left, right) -> left * right);
		
		System.out.println(result);
	}


	
	
	
	
	
	
	
	
	
	
	

}
