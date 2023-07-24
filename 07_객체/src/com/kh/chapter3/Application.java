package com.kh.chapter3;

import com.kh.chapter3.field.A_Field;
import com.kh.chapter3.field.B_StaticField;
import com.kh.chapter3.field.C_StaticFinalField;
import com.kh.chapter3.field.D_InitBlock;

public class Application {

	public static void main(String[] args) {
		// 1. 변수 구분 테스트
		A_Field fieldTest = new A_Field();
		
		// 매개 값으로 정수형 데이터를 넘겨주어야 한다.
		fieldTest.test(10);
		System.out.println();
		
		// 2. 접근 제한자 테스트
		// public : 필드에 직접 접근이 가능하다.
		System.out.println(fieldTest.publicField);
		
		// protected : 같은 패키지 내에 존재하거나, 상속 구조에서만 접근이 가능하다.
//		System.out.println(fieldTest.protectedField);
		
		// default : 같은 패키지 내에서만 접근이 가능하다.
//		System.out.println(fieldTest.defaultField);
		
		// private : 같은 클래스 내에서만 접근이 가능하다.
//		System.out.println(fieldTest.privateField);
		
		System.out.println("===========================");
		
//		3. 클래스 변수 테스트
		// 클래스 변수는 프로그램 실행과 동시에 메모리(Static)에 생성되었기 때문에 객체를 생성하지 않아도 클래스명으로 접근이 가능하다.
		System.out.println(B_StaticField.pubsta);
		System.out.println(B_StaticField.getPriSta());		
		System.out.println(B_StaticField.number);		
		
		// 정적 멤버는 객체의 참조 변수로도 접근이 가능하지만 정적 멤버는 클래스 이름으로 접근하는 것을 지향한다.
//		B_StaticField staticField1 = new B_StaticField();
//		B_StaticField staticField2 = new B_StaticField();
//		
//		System.out.println(staticField1.number);
//		System.out.println(staticField2.number);
//		
//		staticField1.number++;
//		
//		System.out.println(staticField1.number);
//		System.out.println(staticField2.number);
		
		
		System.out.println("==================");
		
		// 4. 상수 테스트
//		Math.PI = 3.11443333;
		System.out.println(Math.PI);
		System.out.println(C_StaticFinalField.MAX_LEVEL);
		System.out.printf("byte의 표현 범위는 %d ~ %d\n", Byte.MIN_VALUE, Byte.MAX_VALUE);
		System.out.printf("int의 표현 범위는 %d ~ %d\n", Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.printf("short의 표현 범위는 %d ~ %d\n", Short.MIN_VALUE, Short.MAX_VALUE);
		System.out.printf("long의 표현 범위는 %d ~ %d\n", Long.MIN_VALUE, Long.MAX_VALUE);
		System.out.printf("char의 표현 범위는 %d ~ %d\n", (int)Character.MIN_VALUE, (int)Character.MAX_VALUE);
		System.out.printf("float의 표현 범위는 %f ~ %.6f\n", Float.MIN_VALUE, Float.MAX_VALUE);
		System.out.printf("double의 표현 범위는 %f ~ %.6f\n", Double.MIN_VALUE, Double.MAX_VALUE);
		
		System.out.println();
		
		// 5. 필드 초기화 순서 테스트
		// 필드
		D_InitBlock initBlock = new D_InitBlock();
		
		System.out.println(initBlock.getName());
		System.out.println(initBlock.getPhoneName());
		System.out.println(initBlock.getPrice());		
		
		System.out.println();
		
		// 클래스 변수
		System.out.println(D_InitBlock.getAge());
		System.out.println(D_InitBlock.getBrand());
		
		
		
		
		
		
		
		
		
		
	}

}
