package com.kh.chapter2.charstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharStream {
	public void fileSave() {
		
		/*
		 * try-with-resource 문을 통해서 사용한 리소스를 자동으로 close() 시킨다.
		 */
		try (FileWriter fw = new FileWriter("b_char.txt")) {
			
			fw.write("IO 재미있으신가요??......ㅋㅋㅋㅋ\n");
			fw.write("아닌가요..?ㅠㅠ", 1, 2);
			fw.write('\n');
			fw.write('A');
			fw.write('\n');
			fw.write(new char[] {'a', 'p', 'p', 'l', 'e'});
			fw.write('\n');
			fw.write(new char[] {'a', 'p', 'p', 'l', 'e'}, 1, 3);
		} catch (IOException e) {
			e.printStackTrace();
		} 	
	}
	
	public void fileRead() {
		try (FileReader fr = new FileReader("b_char.txt")) {
			int value = 0;
			
			while((value = fr.read()) != -1) {
				System.out.print((char) value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
