package com.kh.chapter2._abstract;

public class FootBall extends Sports {	

	public FootBall(int numberOfPlayers) {
		super(numberOfPlayers);
	}
	
	@Override
	public void rule() {
		System.out.println("FootBall의 선수는 " + this.numberOfPlayers + "명, 손이 아닌 발로 공을 차야한다.");
	}
}
