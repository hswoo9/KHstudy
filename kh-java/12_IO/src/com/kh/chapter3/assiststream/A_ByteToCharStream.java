package com.kh.chapter3.assiststream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A_ByteToCharStream {
	public void input() {
//		char[] array = new char[10];
//		
//		try (InputStreamReader isr = new InputStreamReader(System.in)) {
//			System.out.print("문자열 입력 > ");
//			
//			isr.read(array);
//			
//			for (char c : array) {
//				System.out.print(c + " ");
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		String value = null;
		
		// 아래와 같이 보조 스트림 여러 개를 사용하는 것도 가능하다.
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.print("문자열 입력 > ");

			value = br.readLine();
			
			System.out.println(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void output() {
//		try (OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
//			osw.write("아직도 IO가 어려우신가요..?ㅠㅠ\n");
//			osw.write("앞으로 Oracle, JDBC, HTML, CSS, ... 남아있습니다..\n");
//			osw.write("힘내세요..^^");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			
			bw.write("아직도 IO가 어려우신가요..?ㅠㅠ");
			bw.newLine();
			bw.write("앞으로 Oracle, JDBC, HTML, CSS, ... 남아있습니다..");
			bw.newLine();
			bw.write("힘내세요..^^");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
