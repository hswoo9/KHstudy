package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.kh.stream.vo.Student;

public class A_Filtering {
	/*
	 * 필터링
	 *   - 필터링 중간 처리 기능으로 요소를 걸러내는 역할을 한다.
	 *   - distinct()는 중복을 제거하는 메소드이다.
	 *   - filter(Predicate)는 매개값으로 전달되는 Predicate가 false를 리턴하는 요소를 제거한다.
	 */
	
	// 중복 제거
	public void method1() {
		List<Student> students = Arrays.asList(
			new Student("문인수", 20, "남자", 80, 70),
			new Student("문인수", 20, "남자", 80, 70),
			new Student("문인수", 20, "남자", 80, 70),
			new Student("이몽룡", 24, "남자", 80, 80),
			new Student("홍길동", 30, "남자", 90, 80)
		);
		List<String> names = Arrays.asList("문인수", "이몽룡", "문인수", "홍길동");
		Stream<String> stream = names.stream();
		
		stream.forEach(System.out::println);
		
//		이미 최종 처리 메소드까지 호출된 스트림은 다시 사용할 수 없다. (다시 스트림을 얻어와야 한다.)
//		stream.distinct().forEach(System.out::println);
		
		System.out.println();
		
		names.stream().distinct().forEach(System.out::println);
		
		System.out.println();
		
//		students.stream().forEach((Student student) -> {System.out.println(student);});
		students.stream().distinct().forEach(student -> System.out.println(student));
	}
	
	// 필터 메소드
	public void method2() {
		List<Student> students = Arrays.asList(
			new Student("문인수", 20, "남자", 80, 50),
			new Student("문인수", 20, "남자", 80, 50),
			new Student("문인수", 20, "남자", 80, 50),
			new Student("이몽룡", 24, "남자", 80, 80),
			new Student("성춘향", 20, "여자", 90, 90),
			new Student("홍길동", 30, "남자", 50, 80)
		);
		List<String> names = Arrays.asList("문인수", "이몽룡", "성춘향", "문인수", "성춘향", "이순신", "변사또");
		
		names.stream()
//				.filter((String name) -> { return name.startsWith("이");})
				.filter(name -> name.startsWith("이"))
				.forEach(name -> System.out.println(name));
		
		System.out.println();
		
		names.stream()
//				.distinct()
				.filter(name -> name.startsWith("성"))
				.distinct()
				.forEach(name -> System.out.println(name));
		
		System.out.println();
		
		// 성별이 여자인 학생만 출력
		students.stream()
				.filter((Student student) -> {
					return student.getGender().equals("여자");
				})
				.forEach((Student student) -> {
					System.out.println(student);
				});
		
		System.out.println();
		
		// 수학 점수, 영어 점수 둘다 60점 이상인 학생만 출력
		students.stream()
				.distinct()
				.filter((Student student) -> {
					return student.getMath() >= 60 && student.getEnglish() >= 60;
				})
				.forEach(System.out::println);
	}
}
