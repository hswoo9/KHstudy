package com.kh.exception.practice;

import java.io.FileNotFoundException;

public class E_SubClass extends E_SuperClass {
//	@Override
//	public void method() {
//		// 오버라이딩 시 throws 작성하지 않아도 된다.
//	}
	
//	@Override
//	public void method() throws IOException {
//		// 오버라이딩 시 같은 예외를 던져주는 구문으로 작성이 가능하다.
//	}
	
//	@Override
//	public void method() throws Exception {
//		// 부모 클래스의 메소드보다 더 상위 타입의 Exception을 throws 하는 것은 불가능하다.
//	}
	
	@Override
	public void method() throws FileNotFoundException {
		// 부모 클래스의 메소드보다 더 하위 타입의 Exception을 throws 하는 것은 가능하다.		
	}
}
