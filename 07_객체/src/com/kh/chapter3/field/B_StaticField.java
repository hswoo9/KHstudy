package com.kh.chapter3.field;

public class B_StaticField {
	// static 키워드가 붙은 필드는 프로그램이 실행하자마자 static 메모리 영역에 할당된다.
	public static int number = 2;
	public static String pubsta = "public static";
	private static String priSta = "private static";
	
	
	// static 필드에 대한 Getter, Setter 메소드 또한 static 키워드를 붙어야 한다.
	public static String getPriSta() {
		return priSta;
	}
	
	public static void setPriSta(String priSta) {
//		객체를 생성하지 않고 클래스명으로 접근한다. 즉 객체를 생성하지 않아서 this는 존재하지 않는다.
//		this.priSta = priSta;
		
		B_StaticField.priSta = priSta;
	}
}
