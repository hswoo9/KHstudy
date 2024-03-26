package com.kh.chapter3;

import com.kh.chapter3.assiststream.D_ObjectStream;

public class Application {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
//		new A_ByteToCharStream().input();
//		new A_ByteToCharStream().output();
		
//		new B_BufferedStream().fileSave();
//		new B_BufferedStream().fileRead();
		
//		new C_DataStream().fileSaveAndRead();
		
		new D_ObjectStream().fileSave();
		new D_ObjectStream().fileRead();
		
		System.out.println("프로그램 종료");
	}

}
