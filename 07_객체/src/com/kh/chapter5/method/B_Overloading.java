package com.kh.chapter5.method;

public class B_Overloading {
	public void test() {
	}
	
	public void test(int a) {
	}
	
	public void test(int a, String b) {
	}
	
	public void test(String a, int b) {
	}
	
	public void test(int a, int b) {
	}

	/*
	 * 에러가 발생
	 *   - 매개변수 이름과 상관없이 자료형의 개수와 순서가 같아서 에러가 발생한다.
	 */
//	public void test(int c, int d) {
//	}
	
	public void test(int a, int b, String s) {
	}

	/*
	 * 에러가 발생
	 *   - 반환형이 다르다고 오버로딩이 적용되지 않는다.
	 *   - 메소드를 호출하는 시점에 매개변수가 동일하기 때문에 에러가 발생합니다.
	 */
//	public int test(int a, int b, String s) {
//	}
	
	/*
	 * 에러가 발생
	 *   - 접근 제한자가 다르다고 오버로딩이 적용되지 않는다.
	 *   - 메소드를 호출하는 시점에 매개변수가 동일하기 때문에 에러가 발생합니다.
	 */
//	private void test(int a, int b, String s) {
//	}
}
