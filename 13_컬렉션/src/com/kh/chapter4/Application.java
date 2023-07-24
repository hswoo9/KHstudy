package com.kh.chapter4;

import java.util.List;

import com.kh.chapter4.generics.MyGenerics;

public class Application {

	public static void main(String[] args) {
//		String[] array = {"문인수", "이정준", "이정환", "정주리", "김세희"};
//		Integer[] array = {11, 22, 33, 44, 55};
		Double[] array = {11.1, 22.2, 33.3, 44.4, 55.5};
		
//		MyGenerics<String> generics = new MyGenerics<>(array);
//		MyGenerics<Integer> generics = new MyGenerics<>(array);
		MyGenerics<Double> generics = new MyGenerics<>(array);
		
		generics.print();
		System.out.println();
		
//		List<String> list = generics.toList();
//		List<Integer> list = generics.toList();
		List<Double> list = generics.toList();
		
		System.out.println(list);
	}

}
