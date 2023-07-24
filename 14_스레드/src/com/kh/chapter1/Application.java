package com.kh.chapter1;

import com.kh.chapter1.thread.Thread1;
import com.kh.chapter1.thread.Thread2;

public class Application {

	public static void main(String[] args) {
		System.out.println("메인스레드 실행");
		System.out.println(Thread.currentThread().getName() + " : " + Thread.currentThread().getPriority());
		
		Thread1 th1 = new Thread1();
		
//		th1.setPriority(10);
		th1.setPriority(Thread.MAX_PRIORITY);
//		th1.run();
		th1.start();
		
		System.out.println("th1.getPriority() : " + th1.getPriority());
		
		Thread th2 = new Thread(new Thread2());
		
		th2.setPriority(1);
//		th2.setPriority(Thread.MIN_PRIORITY);
//		th2.run();
		th2.start();
		
		System.out.println("th2.getPriority() : " + th2.getPriority());
		
		/*
		 * 2-1) 익명 구현 객체
		 *   [표현법]
		 *     new 인터페이스() {.. 구현 내용 ..};
		 *     
		 *     - 자바에서 소스 파일을 만들지 않고도 구현 인스턴스를 만들 수 있는 방법을 제공하는데 그 방법을 익명 구현 객체라고 한다.
		 *     - 인스턴스를 생성할 때 인터페이스를 직접 구현해서 인스턴스를 생성할 수 있다.
		 *     - 중괄호({ ... })에는 인터페이스에 선언된 모든 추상 메소드들을 재정의해야 한다.
		 */
		Thread th3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// 작업하고자 하는 코드를 작성한다. 
				for (int i = 1; i <= 100; i++) {
					System.out.println(Thread.currentThread().getName() + "[" + i + "]");
				}
			}
		});
		
		th3.start();
		
		/*
		 * 2-2) 람다식을 통한 익명 구현 객체 (참고)
		 */
		Thread th4 = new Thread(() -> {
			// 작업하고자 하는 코드를 작성한다. 
			for (int i = 1; i <= 100; i++) {
				System.out.println(Thread.currentThread().getName() + "[" + i + "]");
			}
		});
		
		th4.start();		
		
		try {
			/*
			 * join() 메소드를 호출한 스레드(main 스레드)는 아래의 스레드가 종료될 때까지 기다렸다가
			 * 아래의 스레드가 종료되면 join() 메소드를 호출한 스레드(main 스레드)를 다시 실행한다.
			 */
			th1.join();
			th2.join();
			th3.join();
			th4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("메인스레드 종료");
	}
}
