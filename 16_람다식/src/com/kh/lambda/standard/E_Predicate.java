package com.kh.lambda.standard;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.kh.lambda.standard.vo.Student;

public class E_Predicate {
	/*
	 * Predicate
	 *   - Predicate 함수적 인터페이스는 매개변수와 boolean 값을 리턴하는 test() 추상 메소드를 가지고 있다.
	 *   - test() 추상 메소드 매개값을 조사해서 true / false를 리턴하는 역할을 한다.
	 */
	
	public void method1() {
		Student student1 = new Student("문인수", 20, "남자", 80, 70);
		Student student2 = new Student("성춘향", 20, "여자", 100, 100);
		
//		Predicate<Student> predicate = (Student student) -> {
//			
//			return student.getGender().equals("남자");
//		};
		Predicate<Student> predicate = student -> student.getGender().equals("남자");
		
		System.out.println("문인수는 남자입니까? : " + predicate.test(student1));
		System.out.println("성춘향은 남자입니까? : " + predicate.test(student2));
		
//		BiPredicate<Student, Student> biPredicate = (Student s1, Student s2) -> {
//			
//			return s1.getGender().equals(s2.getGender());
//		};
		BiPredicate<Student, Student> biPredicate = (s1, s2) -> s1.getGender().equals(s2.getGender());
		
		System.out.println("두 학생의 성별이 동일한가요? : " + biPredicate.test(student1, student2));
		
//		IntPredicate intPredicate = (int a) -> {
//			return a > 100;
//		};
		IntPredicate intPredicate = a -> a > 100;
		
		System.out.println(intPredicate.test(100));
		System.out.println(intPredicate.test(101));
	}
}
