package com.kh.operator.practice;

public class F_Compound {
	public void method1() {
		int number = 12;
		String str = "Hello";
		
		number += 3; // number = number + 3;
		System.out.println(number);
		
		number -= 5; // number = number - 5;
		System.out.println(number);
		
		number *= 6; // number = number * 6;
		System.out.println(number);
		
		number /= 3; // number = number / 3;
		System.out.println(number);
		
		number %= 3; // number = number % 3;
		System.out.println(number);
		
		str += " World!"; // str = str + "World!";
		System.out.println(str);
	}
}
