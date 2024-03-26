package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.List;

import com.kh.stream.vo.Student;

public class A_Match {
	/*
	 * 매칭
	 *   - 최종 처리 단계에서 요소들이 특정 조건을 만족하는지 조사하는 역할을 한다.
	 *   	- allMatch(Predicate)
	 *   	  - 모든 요소들이 매개값으로 주어진 Predicate의 조건을 만족하는 조사한다.
	 *   	- anyMatch(Predicate)
	 *   	  - 최소한 한 개의 요소가 매개값으로 주어진 Predicate의 조건을 만족하는 조사한다.
	 *   	- noneMatch(Predicate)
	 *        - 모든 요소들이 매개값으로 주어진 Predicate의 조건을 만족하지 않는지 조사한다.
	 */
	
	public void method1() {
		boolean result = false;
		int[] array = {2, 4, 6};
		
		result = Arrays.stream(array).allMatch((int i) -> {return i % 2 == 0;});
		
		System.out.println(result);
		
		result = Arrays.stream(array).anyMatch(i -> i % 3 == 0);
		
		System.out.println(result);
		
		result = Arrays.stream(array).noneMatch(i -> i % 5 == 0);
		
		System.out.println(result);
	}
	
	public void method2() {
		boolean result = false;
		List<Student> students = Arrays.asList(
			new Student("홍길동", 30, "남자", 50, 80),
			new Student("성춘향", 19, "여자", 90, 90),
			new Student("문인수", 19, "남자", 80, 50),
			new Student("이몽룡", 24, "남자", 80, 80)
		);
		
		// 나이가 20살 이상인 학생들이 모두 남자인지 확인하시오.
		result = students.stream()
		//				.filter((Student student) -> {return student.getAge() >= 20;})
						.filter(student -> student.getAge() >= 20)
						.peek(student -> System.out.println(student))
//						.allMatch((Student student) -> {return student.getGender().equals("남자");});
						.allMatch(student -> student.getGender().equals("남자"));
			
		System.out.println(result);
		
		System.out.println();
		
		// 남학생들 중에 평균이 70점 이상인 학생이 한 명이라도 존재하는지 확인하시오.
		result = students.stream()
//					.filter((Student student) -> {return student.getGender().equals("남자");})
//					.anyMatch((Student student) -> {return ((student.getMath() + student.getEnglish()) / 2) >= 70;});
					.filter(student -> student.getGender().equals("남자"))
					.anyMatch(student -> ((student.getMath() + student.getEnglish()) / 2) >= 70);
		
		System.out.println(result);
	}
}
