package com.kh.chapter3.assiststream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class B_BufferedStream {
	public void fileSave() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt", true))) {
			
			bw.write("안녕하세요.");
			bw.newLine(); // 기반 스트림에서 제공하지 않는 메소드, 개행할 때 사용한다.
			bw.write("줄바꿈이 적용되었나요??");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		
		try (BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))) {
			String value = null;
			
//			value = br.readLine(); // 기반 스트림에서 제공하는 않는 메소드, 파일에서 한 줄을 읽어올 때 사용한다.
//			System.out.println(value);
//			
//			value = br.readLine();
//			System.out.println(value);
//			
//			value = br.readLine();
//			System.out.println(value);
			
			while ((value = br.readLine()) != null) {
				System.out.println(value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
