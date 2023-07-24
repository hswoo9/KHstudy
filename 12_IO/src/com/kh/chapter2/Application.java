package com.kh.chapter2;

import com.kh.chapter2.charstream.FileCharStream;

public class Application {

	public static void main(String[] args) {
		System.out.println("프로그램 실행");
		
//		new FileByteStream().fileSave();
//		new FileByteStream().fileRead();
		
		new FileCharStream().fileSave();
		new FileCharStream().fileRead();
		
		System.out.println("프로그램 종료");
	}
}
