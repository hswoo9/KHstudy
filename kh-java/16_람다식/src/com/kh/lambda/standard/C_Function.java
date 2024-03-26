package com.kh.lambda.standard;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntFunction;

import com.kh.lambda.standard.vo.Student;

public class C_Function {
	/*
	 * Function
	 *   - Function 함수적 인터페이스는 매개값과 리턴 값이 있는 apply() 추상 메소드를 가지고 있다.
	 *   - apply() 추상 메소드 주로 매개값을 리턴값으로 매핑(타입 변환)하는 역할을 한다.
	 */
	
	public void method1() {
		Student student = new Student("문인수", 19, "남자", 70, 80);
//		Function<Student, String> function = (Student s) -> {
//			return s.getName();
//		};
		Function<Student, String> function = (s) -> s.getName();
		
		System.out.println("너의 이름은? : " + function.apply(student));
		
		BiFunction<String, Integer, Student> biFunction = (String name, Integer age) -> {
			return new Student(name, age);
		};
		
		System.out.println(biFunction.apply("홍길동", 30));		
		
		System.out.print("[수학 점수] : ");
		printValue(s -> s.getMath(), student);
		
		System.out.print("[영어 점수] : ");
		printValue(s -> s.getEnglish(), student);
		
		System.out.print("[합계] : ");
		printValue(s -> s.getMath() + s.getEnglish(), student);
		
		System.out.print("[합계] : ");
		printValue(s -> (s.getMath() + s.getEnglish()) / 2, student);
		
	}
	
	
	public void printValue(ToIntFunction<Student> function, Student student) {
		
		System.out.println(function.applyAsInt(student));
	}
	
	
	
	
	
	
	
	
	
}
