package com.kh.chapter3;

import com.kh.chapter3._interface.Basic;
import com.kh.chapter3._interface.Desktop;
import com.kh.chapter3._interface.Television;

public class Application {

	public static void main(String[] args) {
		// 인터페이스는 인스턴스 생성이 불가능하다. 
//		Basic basic = new Basic();
		
//		Basic.NUM = 20;
		System.out.println(Basic.NUM);
		
		// 인터페이스는 참조변수로 사용이 가능하다.
		// 다형성을 적용해서 인터페이스를 구현하는 인스턴스를 참조할 수 있다.
		Basic desktop = new Desktop("애플", "a1111", "아이맥", 1500000, true);
		Basic television = new Television("엘지", "T-01", "스마트 TV", 2000000, 60);

		desktop.turnOn();
		desktop.turnOff();
		
		television.turnOn();
		television.turnOff();
	}

}
