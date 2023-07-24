package com.kh.inherit;

import com.kh.inherit.after.Desktop;
import com.kh.inherit.after.SmartPhone;
import com.kh.inherit.after.Television;
import com.kh.inherit.override.Book;

public class Application {

	public static void main(String[] args) {
		// Desktop 인스턴스 생성
		Desktop desktop = new Desktop("애플", "a1111", "아이맥 24인치", 1500000, true);
	
//		Desktop desktop = new Desktop();
//		
//		desktop.setBrand("애플");
//		desktop.setpCode("a1111");
//		desktop.setName("아이맥 24인치");
//		desktop.setPrice(1500000);
//		desktop.setAllInOne(true);
		
		// SmartPhone 인스턴스 생성
		SmartPhone smartPhone = new SmartPhone("애플", "a2222", "아이폰12 미니", 900000, "KT");
		
		// Television 인스턴스 생성
		Television television = new Television("엘지", "t-01", "벽걸이 TV", 2000000, 40);
		
		// 출력
		System.out.println(desktop.information());		
		System.out.println(smartPhone.information());
		System.out.println(television.information());
		
		
		System.out.println("=====================================");
		// 오버라이딩 테스트
		
		Book book1 = new Book("자바의 정석", "남궁성", 3000);
		Book book2 = new Book("자바의 정석", "남궁성", 3000);
		Book book3 = new Book("자바 너무 어려워", "문인수", 3000);
		
		System.out.println(book1.information());
		System.out.println(book2.information());
		System.out.println(book3.information());
		
		System.out.println();
		
		// 1. toString() 테스트
//		System.out.println(book1.toString());
		System.out.println(book1);
		System.out.println(book2);
		System.out.println(book3);
		
		System.out.println();
		
		// 2. equals() 테스트
		System.out.println(book1 == book2);
		System.out.println(book1.equals(book2));
		System.out.println(book1.equals(book3));
		
		// 3. hashCode() 테스트
		System.out.println("문인수".hashCode());
		System.out.println(new String("문인수").hashCode());
		
		System.out.println(book1.hashCode());
		System.out.println(book2.hashCode());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
