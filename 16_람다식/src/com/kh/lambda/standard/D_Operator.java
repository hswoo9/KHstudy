package com.kh.lambda.standard;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

import com.kh.lambda.standard.vo.Student;

public class D_Operator {
	/*
	 * Operator
	 *   - Operator 함수적 인터페이스는 매개값과 리턴 값이 있는 apply() 추상 메소드를 가지고 있다.
	 *   - apply() 추상 메소드는 주로 매개값을 이용해서 연산을 하고 동일한 타입으로 결과를 리턴하는 역할을 한다. 
	 * 
	 */
	public void method1() {
		Student student1 = new Student("문인수", 19, "남자", 70, 80);
		Student student2 = new Student("홍길동", 30, "남자", 100, 100);
		
//		IntBinaryOperator intBinaryOperator = (int a, int b) -> {
//			return a + b;
//		};
		IntBinaryOperator intBinaryOperator = (a, b) -> a + b;
		
		System.out.println(intBinaryOperator.applyAsInt(10, 20));
		
//		IntUnaryOperator intUnaryOperator = (int a) -> {
//			return a * a;
//		};
		IntUnaryOperator intUnaryOperator = a -> a * a;
		
		System.out.println(intUnaryOperator.applyAsInt(3));
		
//		BinaryOperator<Student> binaryOperator = (Student s1, Student s2) -> {
//			return s1.getMath() > s2.getMath() ? s1 : s2;
//		};
		BinaryOperator<Student> binaryOperator = (s1, s2) -> s1.getMath() > s2.getMath() ? s1 : s2;
		
		System.out.println(binaryOperator.apply(student1, student2));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
