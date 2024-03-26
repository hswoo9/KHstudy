package com.kh.chapter2;

import com.kh.chapter2._class.Person;

public class Application {

	public static void main(String[] args) {
		Person ismoon = new Person();
		
//		Phone 클래스는 접근 제한이 default 클래스로 패키지 외부에서 접근이 불가능하다.
//		Phone phone = new Phone();
		
		ismoon.setName("문인수");
		ismoon.setAge(17);
		ismoon.setPhone("애플", "아이폰12미니", "화이트");
		
		ismoon.whoAreYou();
	}

}
