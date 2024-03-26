package com.kh.chapter1;

import com.kh.chapter1.polymorphism.Desktop;
import com.kh.chapter1.polymorphism.Product;
import com.kh.chapter1.polymorphism.SmartPhone;
import com.kh.chapter1.polymorphism.Television;

public class Application {

	public static void main(String[] args) {
		// 1. 부모 타입의 참조변수로 부모 인스턴스를 다루는 경우
		Product product = new Product();
		
		// product 참조변수로 Product 클래스의 멤버만 접근 가능
		System.out.println(product.information());
		
		// 2. 자식 타입의 참조변수로 자식 인스턴스를 다루는 경우
		Desktop desktop = new Desktop();
		
		// desktop 참조변수로 Product, Desktop 클래스의 멤버에 접근 가능
		System.out.println(desktop.information());
		System.out.println(desktop.isAllInOne());
		
		// 3. 부모 타입의 참조변수로 자식 인스턴스를 다루는 경우
		Product television = /* (Product) */ new Television(); // 업 캐스팅
		
		// television 참조변수로 Product 클래스의 멤버만 접근 가능
		System.out.println(television.information());
		// 하지만 Television 클래스의 멤버에 접근하고 싶으면 형 변환을 해야 한다.
		System.out.println(((Television) television).getBrand()); // 다운 캐스팅
		
		// 4. 배열과 다형성
		// 다형성을 적용하기 전에는 Desktop, SmartPhone 인스턴스를 배열로 다뤄야 하는 경우 각각의 배열을 만들어야 한다.
		Desktop[] array1 = new Desktop[2];
		
		array1[0] = new Desktop();
		array1[1] = new Desktop();
		
		SmartPhone[] array2 = {
				new SmartPhone(), 
				new SmartPhone()
		};
		
		System.out.println();
		
		// 다형성을 적용하면 부모 클래스의 배열변수로 다양한 인스턴스들을 가리킬 수 있다.
		Product[] array3 = new Product[4];
		
		array3[0] = new Desktop("애플", "a1111", "아이맥 24인치", 1500000, true);
		array3[1] = new Desktop("삼성", "s3333", "매직스테이션", 2000000, false);
		array3[2] = new SmartPhone("애플", "a2222", "아이폰12 미니", 900000, "KT");
		array3[3] = new Television("엘지", "t-01", "벽걸이 TV", 2000000, 40);
		
		for (int i = 0; i < array3.length; i++) {
			System.out.println(array3[i].information());
		}
		
		System.out.println();
		
//		for (int i = 0; i < array3.length; i++) {
//			if( array3[i] instanceof Desktop ) {
//				Desktop d = (Desktop) array3[i];
//				
//				System.out.println(d.isAllInOne());
////				System.out.println(((Desktop)array3[i]).isAllInOne());
//			} else if( array3[i] instanceof SmartPhone ) {
//				SmartPhone s = (SmartPhone) array3[i];
//				
//				System.out.println(s.getMobileAgency());
//			} else {
//				Television t = (Television)array3[i];
//				
//				System.out.println(t.getInch());
//			}
//		}
		
		for (Product p : array3) {
			if(p instanceof Desktop) {
				System.out.println(((Desktop)p).isAllInOne());
			} else if(p instanceof SmartPhone) {
				System.out.println(((SmartPhone)p).getMobileAgency());
			} else {
				System.out.println(((Television)p).getInch());
			}
		}
		
		System.out.println();
		
		// 매개변수의 다형성
		productInfo(new Desktop());
		productInfo(new SmartPhone());
		productInfo(new Television());
	}
	
//	public static void productInfo(Desktop desktop) {
//		System.out.println(desktop.information());
//	}
//	
//	public static void productInfo(SmartPhone smartPhone) {
//		System.out.println(smartPhone.information());
//	}
//	
//	public static void productInfo(Television television) {
//		System.out.println(television.information());
//	}
	
	public static void productInfo(Product product) {
		System.out.println(product.information());
	}
}
