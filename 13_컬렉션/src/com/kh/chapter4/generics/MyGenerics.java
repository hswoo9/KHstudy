package com.kh.chapter4.generics;

import java.util.ArrayList;
import java.util.List;

public class MyGenerics<T extends Number> {
	private final T[] values;

	public MyGenerics(T[] values) {
		this.values = values;
	}
	
	public void print() {
		for (T t : values) {
			System.out.println(t);
		}
	}
	
	public List<T> toList() {
		List<T> list = new ArrayList<>();
		
		for (T t : values) {
			list.add(t);
		}
		
		return list;
	}
}
