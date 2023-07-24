package com.kh.chapter3.assiststream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C_DataStream {
	public void fileSaveAndRead() {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("d_data.txt"));
			 DataInputStream dis = new DataInputStream(new FileInputStream("d_data.txt"))) {
			
			// 파일에 출력하기
			dos.writeUTF("문인수");
			dos.writeInt(20);
			dos.writeChar('M');
			dos.writeBoolean(false);
			dos.writeDouble(188.4);
			
			// 파일에서 값을 읽어오기
			while(true) {
				System.out.println("이름은 " + dis.readUTF() + 
								   ", 나이는 " + dis.readInt() + 
								   ", 성별은 " + dis.readChar() + 
								   ", 결혼은 " + dis.readBoolean() + 
								   ", 키는 " + dis.readDouble());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("파일 읽기 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
