package com.kh.lambda.standard;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class A_Consumer {
	/*
	 * Consumer
	 *   - Consumer 함수적 인터페이스는 리턴 값이 없는 accept() 추상 메소드를 가지고 있다.
	 *   - accept() 추상 메소드는 단지 매개값을 소비하는 역할을 한다.
	 */
	
	public void method1() {
//		Consumer<String> consumer = (String str) -> {
//			System.out.println(str);
//		};
		
		Consumer<String> consumer = str -> System.out.println(str);
		
		consumer.accept("Consumer는 한 개의 매개값을 받아서 소비한다.");
		
//		BiConsumer<String, String> biConsumer = (String str1, String str2) -> {
//			System.out.println(str1 + str2);
//		};
		
		BiConsumer<String, String> biConsumer = (str1, str2) -> System.out.println(str1 + str2);
		
		biConsumer.accept("BiConsumer는 ", "두 개의 매개값을 받아서 소비한다.");
		
//		DoubleConsumer doubleConsumer = (double value) -> {
//			System.out.println("DoubleConsumer는 하나의 double 타입의 값을 받아서 소비한다. : " + value);
//		};
		
		DoubleConsumer doubleConsumer = 
				value -> System.out.println("DoubleConsumer는 하나의 double 타입의 값을 받아서 소비한다. : " + value);
		
		doubleConsumer.accept(3.14);
		
//		ObjIntConsumer<String> objIntConsumer = (String str, int i) -> {
//			System.out.println("ObjIntConsumer는 두 개의 매개값(제네릭으로 지정된 타입, int 타입)을 받아서 소비한다.");
//			System.out.println(str + i);
//		};
		
		ObjIntConsumer<String> objIntConsumer = (str, i) -> {
			System.out.println("ObjIntConsumer는 두 개의 매개값(제네릭으로 지정된 타입, int 타입)을 받아서 소비한다.");
			System.out.println(str + i);
		};
		
		objIntConsumer.accept("Java", 11);
	}
}
