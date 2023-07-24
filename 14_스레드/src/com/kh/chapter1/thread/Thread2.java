package com.kh.chapter1.thread;

/*
 * 2. Runnable 인터페이스를 구현하는 방법
 *   - run() 추상 메소드를 오버라이딩한다.
 *   - Thread 인스턴스 생성 시 생성자의 매개값으로 Runnable 인터페이스를 구현한 인스턴스를 전달 후 start() 메소드를 호출한다.
 */
public class Thread2 implements Runnable {

	@Override
	public void run() {
		// 작업하고자 하는 코드를 작성한다. 
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + "[" + i + "]");
		}
	}
}
