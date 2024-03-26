package com.kh.chapter3.assiststream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chapter3.assiststream.vo.Member;

public class D_ObjectStream {
	public void fileSave() {
		Member member = new Member("ismoon", "1234", "문인수", "ismoon@iei.or.kr", 20, 'M', 12500);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("e_object.dat"))) {

			oos.writeObject(member);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("e_object.dat"))) {
			
			Member member = (Member)ois.readObject();
			
			System.out.println(member);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
