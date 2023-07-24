package com.kh.chapter2.sync;

public class Storage {
	private int data;
	
	// 인스턴스의 상태를 저장하고 흐름을 제어하기 위한 필드(플래그 변수)
	private boolean empty = true;
	
	public synchronized void getData() {
		while(empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		empty = true;
		System.out.println("소비자가 " + this.data + "번 상품을 소비하였습니다.");
		notify();
	}
	
	public synchronized void setData(int data) {
		while(!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.data = data;	
		this.empty = false;
		
		System.out.println("생산자가 " + this.data + "번 상품을 생산하였습니다.");	
		notify();
	}
}
