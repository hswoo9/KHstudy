package com.kh.chapter1.thread;

/*
 * 스레드 생성 방법
 * 
 * 1. Thread 클래스를 상속받는 방법 
 *   - run() 메소드를 오버라이딩한다.
 *   - Thread 클래스를 상속한 자식 클래스의 인스턴스를 생성 후 start() 메소드를 호출한다.
 */
public class Thread1 extends Thread {

	@Override
	public void run() {
		// 작업하고자 하는 코드를 작성한다. 
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + "[" + i + "]");
		}
	}
}
