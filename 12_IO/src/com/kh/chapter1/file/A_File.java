package com.kh.chapter1.file;

import java.io.File;
import java.io.IOException;

public class A_File {
	public void method1() {
		try {
			// 경로를 지정하지 않으면 현재 프로젝트 폴더에 파일이 생성된다.
			File file = new File("test.txt"); // 메모리상에만 존재하는 인스턴스
			
			System.out.println("파일명 : " + file.getName());
			System.out.println("절대 경로 : " + file.getAbsolutePath());
			System.out.println("상대 경로 : " + file.getPath());
			System.out.println("파일 용량 : " + file.length());
			System.out.println("파일 존재 여부 : " + file.exists());
			System.out.println();
		
			file.createNewFile();
			
			// 존재하는 경로까지 지정해 주면 해당 위치에 파일을 생성한다.
			// 만약에 존재하지 않는 경로를 제시하면 IOException 발생한다.
			File file2 = new File("D:/test2.txt");
//			File file2 = new File("D:/temp/test2.txt");
			
//			file2.mkdirs();
			file2.createNewFile();
			
			// 폴더를 만들고 파일 생성하기
			File tempDir = new File("d:/temp/test");
			
//			tempDir.mkdir();
			tempDir.mkdirs();
			
			File file3 = new File("d:/temp/test/test3.txt");
			
			file3.createNewFile();
			
			System.out.println("파일명 : " + file3.getName());
			System.out.println("절대 경로 : " + file3.getAbsolutePath());
			System.out.println("상대 경로 : " + file3.getPath());
			System.out.println("파일 용량 : " + file3.length());
			System.out.println("파일 존재 여부 : " + file3.exists());
			System.out.println("파일 여부 : " + file3.isFile());
			System.out.println("디렉토리 여부 : " + file3.isDirectory());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
