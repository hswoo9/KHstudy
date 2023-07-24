package com.kh.lambda.practice;

import com.kh.lambda.practice.functional.A_FunctionalInterface;
import com.kh.lambda.practice.functional.B_FunctionalInterface;
import com.kh.lambda.practice.functional.C_FunctionalInterface;

public class B_Functional {
	
	private int num = 100;
	
	public void method1() {
		A_FunctionalInterface fi;
		
		fi = new A_FunctionalInterface() {
			
			@Override
			public void method() {
				System.out.println("익명 구현 객체를 통한 인터페이스 구현");
			}
		};
		
		
		fi.method();
		
		fi = () -> {
			System.out.println("매개변수와 반환값이 없는 람다식 1");
		};
		
		fi.method();
		
		// 실행문이 한 줄이라면 중괄호를 생략 가능
		fi = () -> System.out.println("매개변수와 반환값이 없는 람다식 2");
		
		fi.method();
		
		
		
		
	}

	public void method2() {
		B_FunctionalInterface fi;
		
		fi = new B_FunctionalInterface() {
			
			@Override
			public void method(int a) {
				System.out.println(a * 2);
			}
		};
		
		fi.method(5);
		
		fi = (int a) -> {
			System.out.println(a * 2);
		};
		
		fi.method(10);
		
		// 매개변수의 자료형을 생략 가능
		fi = (a) -> {
			System.out.println(a * 2);
		};
		
		fi.method(20);
		
		// 매개변수가 하나이면 괄호 생략 가능
		fi = a -> System.out.println(a * 2);
		
		fi.method(40);
	}

	public void method3() {
		int result = 0;
		C_FunctionalInterface fi;
		
		fi = new C_FunctionalInterface() {
			
			@Override
			public int method(int a, int b) {
				
				return a + b;
			}
		};
		
		result = fi.method(10, 20);
		
		System.out.println(result);
		
		fi = (int x, int y) -> {
			return x + y;
		};
		
		result = fi.method(20, 30);
		
		System.out.println(result);
		
		// 매개변수의 자료형, return 문, 중괄호 생략 가능
		fi = (x, y) -> x + y;
		
		result = fi.method(50, 50);
		
		System.out.println(result);
	}

	public void method4(int arg) {
		// 람다식에서 필드와 지역 변수 사용하기
		// 람다식의 실행 블록에서는 필드와 지역 변수를 사용할 수 있다.
		// 필드는 제약없이 사용하지만, 지역변수는 제약이 따른다.
		
		int num = 200;
		A_FunctionalInterface fi;
		
		// 람다식에서 사용되는 this는 람다식을 통해서 구현되는 인스턴스의 참조가 아닌 람다식을 실행하는 인스턴스의 참조이다.
		// 람다식에서 지역변수를 이용할 때는 지역변수가 final, effectively final 이어야한다.
		//  - 지역변수는 람다식에서 읽는 것은 허용하지만, 람다식 내부에서 또는 외부에서 변경할 수 없다.
		//  - 초기화 된 이후에 값이 한번도 변경되지 않는 변수를 effectively final이라고 한다.
		
//		num = 400;
//		arg = 300;
		
		fi = () -> {
//			num = 400;
//			arg = 300;
			this.num = 300;
			
			System.out.println(num);
			System.out.println(arg);
			System.out.println(this.num);
		};
		
		fi.method();
		
		// 익명 구현 객체에서 사용되는 this는 익명 구현 객체로 생성된 인스턴스의 참조이다.
//		num = 200;
//		arg = 300;
		fi = new A_FunctionalInterface() {
			
			@Override
			public void method() {
//				num = 200;
//				arg = 300;
				
				System.out.println(num);				
				System.out.println(arg);				
			}
		};
		
		
		System.out.println(this.num);
	}

}
