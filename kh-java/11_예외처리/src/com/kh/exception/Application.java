package com.kh.exception;

import java.io.IOException;

import com.kh.exception.practice.C_UnCheckedException;

public class Application {

	public static void main(String[] args) throws IOException {
		System.out.println("프로그램 시작");
		
//		new A_TryCatch().method1();
//		new B_Throws().method1();
//		new C_UnCheckedException().method1();
		new C_UnCheckedException().method2();
		
		
		System.out.println("프로그램 종료");
		
		
	}

}
