package com.kh.lambda;

import com.kh.lambda.practice.C_MethodReference;

public class Application {

	public static void main(String[] args) {
		/*
		 * 람다식(Lambda Expressions)
		 *   - 자바에서 함수적 프로그래밍을 위해서 자바 8부터 람다식을 지원한다.
		 *   - 람다식은 매개변수를 가지는 함수와 같은 코드 블록이지만 런타임 시에는 인터페이스의 익명 구현 객체를 생성한다.
		 *   - 람다식을 사용하면 코드가 간결해지고, 컬렉션의 요소들을 필터링하거나 매핑해서 원하는 결과를 쉽게 가져올 수 있다.
		 * 
		 * 	 [표현법]
		 * 		([자료형 매개변수, ... ]) -> {
		 * 			// 실행 코드
		 * 
		 * 			[return 반환값;]
		 * 		};
		 * 
		 * 		예시)
		 * 			- (int a) -> { System.out.println(a); };
		 * 			- (a) -> { System.out.println(a); }; // 매개변수의 자료형을 생략 가능
		 * 			- a -> System.out.println(a);  // 매개변수가 하나일 때, 실행문이 하나일 때 소괄호(), 중괄호{} 생략 가능
		 * 			- () -> { ... };  // 매개변수가 없다면 매개변수 자리에 반드시 빈 괄호()를 사용해야 한다.
		 * 			- (a, b) -> { return a + b; };  // 결과값을 리턴해야한다면 return 문으로 결과값을 지정해야 한다.
		 * 			- (a, b) -> a + b;  // return 문 하나만 있으면 return 문과 중괄호{}를 생략할 수 있다.
		 */

//		new A_Lambda().method1();
		
		/*
		 * 타겟 타입(Target Type)
		 *   - 람다식은 단순히 메소드를 선언하는 것이 아니라 람다식으로 선언된 메소드를 가지고 있는 인스턴스를 생성한다.
		 *   - 람다식은 인터페이스 타입의 변수에 대입되고 람다식은 인터페이스의 익명 구현 객체를 생성한다.
		 *   - 람다식은 대입될 인터페이스의 종류에 따라서 작성 방법이 달라지기 때문에 람다식이 대입될 인터페이스를 타겟 타입이라고 한다.
		 *   
		 * 함수적 인터페이스(Functional Interface)
		 *   - 모든 인터페이스가 타겟 타입으로 사용할 수 없다.
		 *   - 하나의 추상 메소드가 선언된 인터페이스만 람다식의 타겟이 될 수 있는데 이러한 인터페이스를 함수적 인터페이스라고 한다.
		 *   - 함수적 인터페이스를 선언할 때 @FunctionalInterface 어노테이션을 붙이면 두 개 이상의 추상 메소드가 선언되지 않도록
		 *     컴파일러가 체크해 준다.
		 */
		
//		new B_Functional().method1();
//		new B_Functional().method2();
//		new B_Functional().method3();
//		new B_Functional().method4(100);
		
		
		/*
		 * 표준 함수적 인터페이스
		 *   - 자바 8부터 빈번히 사용되는 함수적 인터페이스는 java.util.function 패키지에 표준 API로 제공된다.
		 *   - 자바 8부터 추가되거나 변경된 API는 이 표준 함수적 인터페이스들을 매개 타입으로 많이 사용한다.
		 *   - 표준 함수적 인터페이스는 용도에 따라 크게 Consumer, Supplier, Function, Operator, Predicate로 구분된다.
		 */
//		new A_Consumer().method1();
//		new B_Supplier().method1();
//		new C_Function().method1();
//		new D_Operator().method1();
//		new E_Predicate().method1();
		
		/*
		 * 메소드 참조(Method Reference)
		 *   - 메소드 참조는 메소드를 참조해서 매개변수의 정보 및 리턴 타입을 내고,
		 *     람다식에서 불필요한 매개변수를 제거하는 것이 목적이다.
		 *   - 참조하는 메소드, 생성자가 존재하지 않으면 오류가 발생한다.
		 */
		new C_MethodReference().method1();
	}
}
