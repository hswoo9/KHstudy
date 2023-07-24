package com.kh.stream.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class A_Create {
	/*
	 * 스트림의 종류
	 *   - java.util.stream 패키지에 존재하고 BaseStream 인터페이스를 부모로 해서 자식 인터페이스들이 상속 관계를 이루고 있다.
	 *   - Stream<T>, IntStream, LongStream, DoubleStream
	 *   
	 * 스트림의 생성
	 *   - 숫자 범위로 스트림을 생성하는 방법
	 *     - IntStream, LongStream의 range(), rangeClosed() 메소드를 이용해서 생성한다.
	 *   - 배열로부터 스트림을 생성하는 방법
	 *     - Arrays.stream(배열) 메소드로 스트림을 생성한다.
	 *     - 각 스트림(Stream<T>, IntStream, ...)에 of(배열) 메소드로 스트림을 생성한다.
	 *   - 컬렉션으로부터 스트림을 생성하는 방법 
	 *     - 컬렉션의 stream() 메소드를 이용해서 생성한다. (java.util.Collection.stream())
	 */
	
	// 숫자 범위로 스트림을 생성하는 방법
	public void method1() {
		// 첫 번째 매개값 ~ 두 번째 매개값 이전까지의 값을 요소로 가지는 스트림 객체를 생성
		IntStream stream = IntStream.range(1, 10);
		
//		int sum = stream.sum();
		int sum = stream.peek(value -> System.out.print(value + " ")).sum();
		
		System.out.println("\nsum : " + sum);
		
		System.out.println();
		
		// 첫 번째 매개값 ~ 두 번째 매개값까지 값을 요소로 가지는 스트림 객체를 생성
		stream = IntStream.rangeClosed(1, 10);
		
		sum = stream.peek(value -> System.out.print(value + " ")).sum();
		
		System.out.println("\nsum : " + sum);
		
	}
	
	// 배열로부터 스트림을 생성하는 방법
	public void method2() {
		String[] names = {"문인수", "홍길동", "이몽룡", "성춘향", "문인수", "성춘향"};
		
		// for 문을 사용하여 출력
		for (String name : names) {
			System.out.print(name + " ");
		}
		
		System.out.println();
		
		// 스트림을 사용하여 출력
//		Arrays.<String>stream(names);
//		Stream<String> stream = Arrays.stream(names);
//		Stream<String> stream = Stream.<String>of(names);
//		Stream<String> stream = Stream.of(names);
		Stream<String> stream = Stream.of("문인수", "홍길동", "이몽룡", "성춘향", "문인수", "성춘향");
		
//		stream.parallel().forEach((String name) -> {System.out.print(name + " ");}); // 병렬 처리
		stream.distinct().forEach(name -> System.out.print(name + " "));
	}
	
	// 컬렉션으로부터 스트림을 생성하는 방법 
	public void method3() {
		List<String> names = Arrays.asList("문인수", "홍길동", "이몽룡", "성춘향", "문인수", "성춘향");
		
		// for 문을 사용하여 출력
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		System.out.println();
		
		// 스트림을 사용하여 출력
		Stream<String> stream = names.stream();
//		Stream<String> stream = names.parallelStream();
		
//		stream.forEach(name -> System.out.println(name));
		stream.distinct().forEach(System.out::println);
	}
}
