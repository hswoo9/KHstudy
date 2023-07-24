package com.kh.chapter2;

import com.kh.chapter2._abstract.BasketBall;
import com.kh.chapter2._abstract.FootBall;
import com.kh.chapter2._abstract.Sports;

public class Application {

	public static void main(String[] args) {
		// 추상 클래스는 인스턴스 생성이 불가능하다.
		// 추상 클래스는 상속받는 자식 클래스를 만들어서 인스턴스를 생성해야 한다. 
//		Sports sports = new Sports(0);
		
		// 추상 클래스는 참조변수로 사용이 가능하다.
		// 즉, 다형성을 적용해서 자식 인스턴스를 참조할 수 있다.
//		Sports basketBall = new BasketBall(5);
//		Sports footBall = new FootBall(11);

		// 다형성을 이용해서 BasketBall, FootBall 인스턴스의 룰을 출력한다.
		Sports[] sports = {
			new BasketBall(5),
			new FootBall(11)
		};
		
//		Sports[] sports = new Sports[2]; 
//		
//		sports[0] = new BasketBall(5);
//		sports[1] = new FootBall(11);
		
		for(Sports s : sports) {
			s.rule();
		}
	}
}
