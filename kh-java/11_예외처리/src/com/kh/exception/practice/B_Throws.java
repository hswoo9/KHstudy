package com.kh.exception.practice;

import java.io.IOException;

public class B_Throws {
	public void method1() throws IOException {
		System.out.println("method1() - 호출");
		
		method2();
		
		System.out.println("method1() - 종료");
	}
	
	public void method2() throws IOException {
		System.out.println("method2() - 호출");
		
		method3();
		
		System.out.println("method2() - 종료");
	}
	
	public void method3() throws IOException {
		System.out.println("method3() - 호출");
		
		int random = (int) (Math.random() * 2 + 1);

		if(random == 1) {			
			throw new IOException();		
		}
		
		System.out.println("method3() - 종료");
	}
}
