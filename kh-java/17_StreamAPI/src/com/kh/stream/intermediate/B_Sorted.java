package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.kh.stream.vo.Student;

public class B_Sorted {
	/*
	 * 정렬
	 *   - 스트림의 요소들이 최종 처리가 되기 전에 중간 단계에서 요소들을 정렬해서 최종 처리 순서를 변경할 수 있다.
	 *   - IntStream, LongStream, DoubleStream은 요소를 오름차순으로 정렬한다.
	 *   - Stream<T>은 요소가 Comparable 인터페이스를 구현해야 정렬할 수 있다. (구현하지 않은 경우 예외가 발생한다.)
	 */
	
	public void method1() {
		List<Student> students = Arrays.asList(
			new Student("홍길동", 30, "남자", 50, 80),
			new Student("성춘향", 20, "여자", 90, 90),
			new Student("문인수", 19, "남자", 80, 50),
			new Student("이몽룡", 24, "남자", 80, 80)
		);
		List<String> names = Arrays.asList("문인수", "이몽룡", "성춘향", "문인수", "성춘향", "이순신", "변사또");
		
		// Comparable 인터페이스 구현 내용 따라서 정렬 (오름차순 정렬)
		names.stream()
				.distinct()
				.sorted()
				.forEach(name -> System.out.print(name + " "));
		
		System.out.println();
		
		// Comparable 인터페이스 구현 내용에 반대로 정렬 (내림차순 정렬)
		names.stream()
				.distinct()
//				.sorted((String name1, String name2) -> {
//					return name2.compareTo(name1);
//				})
				.sorted(Comparator.reverseOrder())
				.forEach(name -> System.out.print(name + " "));
		
		System.out.println();
		
		// students 정렬
		students.stream()
//				.sorted()
				.sorted(Comparator.reverseOrder())
//				.sorted((Student s1, Student s2) -> {return s1.getAge() - s2.getAge();})
//				.sorted((s1, s2) -> s2.getAge() - s1.getAge())
				.forEach(student -> System.out.println(student));
	}
	
	public void method2() {
//		int[] array = {3, 5, 1, 4, 2};
//		int[] array;
//		
//		array = new int[] {3, 5, 1, 4, 2};
		
		// 오름차순 정렬
		Arrays.stream(new int[] {3, 5, 1, 4, 2})
			  .sorted()
			  .forEach(value -> System.out.print(value + " "));
		
		System.out.println();
		
		// 내림차순 정렬
		Arrays.stream(new int[] {3, 5, 1, 4, 2})
			  .boxed()
			  .sorted(Comparator.reverseOrder())
			  .forEach(value -> System.out.print(value + " "));
	}

}
