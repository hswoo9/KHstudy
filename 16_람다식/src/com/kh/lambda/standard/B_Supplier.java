package com.kh.lambda.standard;

import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class B_Supplier {
	/*
	 * Supplier
	 *   - Supplier 함수적 인터페이스는 매개변수가 없고 리턴 값이 있는 get() 추상 메소드를 가지고 있다.
	 *   - get() 추상 메소드는 실행 후 호출한 곳으로 데이터를 공급(리턴)하는 역할을 한다.
	 */
	
	public void method1() {
//		Supplier<String> supplier = () -> {
//			return "Supplier는 제네릭으로 지정된 타입의 인스턴스를 리턴한다.";
//		};
		
		Supplier<String> supplier = () -> "Supplier는 제네릭으로 지정된 타입의 인스턴스를 리턴한다.";
		
		System.out.println(supplier.get());
		
//		LongSupplier longSupplier = () -> {
//			return 23456789034567L;
//		};
		
		LongSupplier longSupplier = () -> 23456789034567L;
		
		System.out.println(longSupplier.getAsLong());
	}
}
