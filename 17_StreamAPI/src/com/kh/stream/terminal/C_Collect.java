package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.kh.stream.vo.Student;

public class C_Collect {
	/*
	 * 수집
	 *   - 최종 처리 기능으로 필터링 또는 매핑한 요소들을 새로운 컬렉션으로 담아서 리턴 받을 수 있다.
	 */
	public void method1() {
		List<Student> students = Arrays.asList(
			new Student(1, "홍길동", 30, "남자", 50, 80),
			new Student(2, "성춘향", 19, "여자", 90, 90),
			new Student(3, "문인수", 19, "남자", 80, 50),
			new Student(4, "이몽룡", 24, "남자", 80, 80),
			new Student(5, "심청이", 16, "여자", 90, 90)
		);
		
		// List로 수집
		List<Student> list = students.stream()
					.filter((Student student) -> {return student.getGender().equals("남자");})
					.collect(Collectors.toList());
		
		list.stream().forEach(System.out::println);
		
		System.out.println();
		
		// Set으로 수집
		Set<Student> set = students.stream()
					.filter(student -> student.getGender().equals("여자"))
					.collect(Collectors.toSet());
		
		set.stream().forEach(System.out::println);
		
		System.out.println();
		
		// Map으로 수집
		Map<Integer, String> map = students.stream()
//				.collect(
//						Collectors.toMap(
//								(Student student) -> {return student.getIdx();},
//								(Student student) -> {return student.getName();}
//						)
//				);
				.collect(Collectors.toMap(student -> student.getIdx(), student -> student.getName()));
		
		System.out.println(map);
		
		Map<String, List<Student>> studentMap = students.stream()
				.collect(Collectors.groupingBy(student -> student.getGender()));
		
		System.out.println(studentMap);
	}
}
