package com.kh.chapter2.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteStream {
	public void fileSave() {
		FileOutputStream fos = null;
		byte[] array = {99, 100, 101};
		
		try {
//			fos = new FileOutputStream("a_byte.dat");
			fos = new FileOutputStream("a_byte.dat", true);
			
			fos.write(97);  // 문자 a 저장
			fos.write('b');
			fos.write(10);  // 줄바꿈 문자 저장
			fos.write(97);
			fos.write(10);  // 줄바꿈 문자 저장
			fos.write(array);
			fos.write(10);  // 줄바꿈 문자 저장
			fos.write(array, 1, 2);
			fos.write(10);  // 줄바꿈 문자 저장
			fos.write('한'); // 한글은 2byte로 표현되기 때문에 바이트 단위 스트림으로는 제한이 있다.
//			fos.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void fileRead() {
		FileInputStream fis = null;
		byte[] array = new byte[100];
		
		try {
			fis = new FileInputStream("a_byte.dat");
			
			/*
			 * 파일로부터 데이터를 읽어올 때는 read() 메소드를 사용한다.
			 * read() 메소드는 더 이상 읽어올 데이터가 없으면 -1을 리턴한다. 
			 */
//			System.out.print((char)fis.read());
//			System.out.print((char)fis.read());
//			System.out.print((char)fis.read());
//			System.out.println((char)fis.read());
//			System.out.println(fis.read(array));
////			System.out.println(fis.read(array, 10, 10));
//			System.out.println(Arrays.toString(array));
//			System.out.println(fis.read());
			
//			while(fis.read() != -1) {
//				System.out.print((char) fis.read());
//			}
			
			int value = 0;
			
			while((value = fis.read()) != -1) {
				System.out.print((char) value);
			}
			
			System.out.println();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
