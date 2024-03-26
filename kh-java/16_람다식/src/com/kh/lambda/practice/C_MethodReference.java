package com.kh.lambda.practice;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

import com.kh.lambda.standard.vo.Student;

public class C_MethodReference {
	public void method1() {
//		IntBinaryOperator binaryOperator = (int a, int b) -> {
//			return Math.max(a, b);
//		};
//		IntBinaryOperator binaryOperator = (a, b) -> Math.max(a, b);
		
//		정적(static)메소드를 참조할 경우에는 클래스 이름 뒤에 :: 붙이고 정적 메소드 이름을 기술하면 된다.	
		IntBinaryOperator binaryOperator = Math::max;		
		
		System.out.println(binaryOperator.applyAsInt(10, 20));
		
//		인스턴스의 메소드를 참조할 경우에는 참조 변수 뒤에 :: 붙이고 메소드 이름을 기술하면 된다.
//		Consumer<String> consumer = str -> System.out.println(str);
		Consumer<String> consumer = System.out::println;
		
		consumer.accept("안녕하세요.");
		
//		매개변수의 메소드를 참조할 경우에는 매개변수의 클래스 이름 뒤에 :: 붙이고 메소드 이름을 기술하면 된다.
//		Function<Student, String> function = (s) -> s.getName();
		Function<Student, String> function = Student::getName;
		
		System.out.println(function.apply(new Student("홍길동", 30)));
		
//		생성자 참조는 클래스 이름 뒤에 :: 붙이고 new 연산자를 기술하면 된다.
//		Supplier<Student> supplier = () -> new Student();
		Supplier<Student> supplier = Student::new;
		
		System.out.println(supplier.get());
		
//		BiFunction<String, Integer, Student> biFunction = (name, age) -> new Student(name, age);
		BiFunction<String, Integer, Student> biFunction = Student::new;
		
		System.out.println(biFunction.apply("홍길동", 30));
	}
}
