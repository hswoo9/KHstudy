package com.kh.chapter1.string;

import java.util.Arrays;
import java.util.StringTokenizer;

public class A_String {
	public void method1() {
		// 문자열 리터럴과 new 연산자로 생성된 문자열 비교
		String str1 = "Hello";
		String str2 = "Hello";
		String str3 = new String("Hello");
		String str4 = new String("Hello");
		
		System.out.println(str1 == str2);
		System.out.println(str1 == str4);
		System.out.println(str3 == str4);
		System.out.println();
		
		// toString() 메소드는 String 클래스에서 오버라이딩 되어있다.
		System.out.println(str1.toString());
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		
		// hashCode() 메소드는 String 클래스에서 오버라이딩 되어있다.
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		System.out.println();
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		System.out.println();
		
		// equals() 메소드
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str4));
		System.out.println(str3.equals(str4));
	}

	public void method2() {
		// String 클래스에서 제공하는 메소드 사용
		String str = "Hello World!";
		
		// 1. charAt(int) 메소드는 전달받은 index 위치의 문자만 추출해서 리턴한다.
		char ch = str.charAt(3);
		
		System.out.println("ch : " + ch);
		System.out.println();
		
		// 2. concat(String) 메소드는 전달받은 문자열과 원본 문자열을 하나로 합친 새로운 문자열을 생성해서 리턴한다.
		String str2 = str.concat("!!!!!!!!!!");
//		String str3 = str + "!!!!!!!!!!";
		String str3 = str + "!!!!!!!!!!" + "!!!!";
		
		System.out.println("str : " + str);
		System.out.println("str2 : " + str2);
		System.out.println("str3 : " + str3);
		System.out.println();
		
		// 3. substring(int) 메소드는 매개값으로 전달된 위치에서부터 끝까지의 문자열을 새로 생성해서 리턴한다.
		//    substring(int beginIndex, int endIndex) 메소드는 문자열의 beginIndex 위치에서부터
		//    endIndex - 1까지의 새로운 문자열을 새로 생성해서 리턴한다.
		String str4 = str.substring(6);
		String str5 = str.substring(2, 6);
		
		System.out.println("str : " + str);
		System.out.println("str4 : " + str4);
		System.out.println("str5 : " + str5);
		System.out.println();
		
		// 4. indexOf(String) 메소드는 전달받은 문자열의 시작 인덱스를 리턴한다. (주어진 문자열이 포함되어 있지 않으면 -1 리턴)
		//    indexOf(char) 메소드는 전달받은 문자의 시작 인덱스를 리턴한다. (주어진 문자가 포함되어 있지 않으면 -1 리턴)
//		int index = str.indexOf("World");
//		int index = str.indexOf("World", 7);
		int index = str.lastIndexOf("World");
		
		System.out.println("index : " + index);
		
//		index = str.indexOf('o');
		index = str.indexOf('o', 6);
//		index = str.lastIndexOf('o');
		
		System.out.println("index : " + index);
		System.out.println();
		
		// 5. replace(char oldChar, char newChar) 메소드는 문자열에서 oldChar를 newChar 문자로 변경된 새로운 문자열을 생성해서 리턴한다.
		String str6 = str.replace('l', 'c');
		
		System.out.println("str : " + str);
		System.out.println("str6 : " + str6);
		System.out.println();
		
		// 6. toUpperCase(), toLowerCase() 메소드는 문자열을 모두 대/소문자로 변경한 새로운 문자열을 생성해서 리턴한다.
		String str7 = str.toUpperCase();
		String str8 = str.toLowerCase();
		
		System.out.println("str : " + str);
		System.out.println("str7 : " + str7);
		System.out.println("str8 : " + str8);
		System.out.println();
		
		// 7. trim() 메소드는 문자열의 앞뒤 공백을 제거한 새로운 문자열을 생성해서 리턴한다.
		str = " JAVA ";
		String str9 = str.trim();
		
		System.out.println("str  : " + str);
		System.out.println("str9 : " + str9);
		System.out.println();
		
		// 8. toCharArray() 메소드는 문자열의 문자들을 배열에 담아서 리턴한다.
		str = "Hello";
		char[] array = str.toCharArray();
		
		System.out.println(str);
		System.out.println(Arrays.toString(array));
		System.out.println();
		
		// 9. valueOf( ... ) 정적 메소드는 매개변수로 입력받은 값들을 문자열로 변경해서 리턴한다. 
		String str10 = String.valueOf(false);
//		String str11 = String.valueOf(array);
		String str11 = String.valueOf(array, 1, 3);
		String str12 = String.valueOf(3.141592F);
		
		System.out.println("str10 : " + str10);
		System.out.println("str11 : " + str11);
		System.out.println("str12 : " + str12);
		System.out.println();
	}

	public void method3() {
		String str = "Java,Oracle,JDBC,HTML,CSS,Spring";
		
		// 1. String 클래스의 split 메소드를 이용하는 방법
		//    split(String) 메소드는 입력받은 구분자로 문자열을 분리해서 문자열의 배열로 담아서 리턴한다. 
		String[] array = str.split(",");
		
		System.out.println("array.length : " + array.length);
		System.out.println(Arrays.toString(array));
		System.out.println();
		
		// 2. StringTokenizer 인스턴스를 이용하는 방법
		//    countTokens()		: 남아있는 토큰의 수를 리턴한다.
		//    hasMoreTokens()	: 남아있는 토큰이 있는지 확인한다.
		//    nextToken()		: 토큰을 하나씩 꺼내온다.
		StringTokenizer st = new StringTokenizer(str, ",");
		
		System.out.println("st.countTokens() : " + st.countTokens());
		
		// while 문을 통한 출력 방법
//		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}
		
		// for 문을 통한 출력 방법
//		int length = st.countTokens();
		
//		for(int i = 0; i < length; i++) {
//			System.out.println(st.nextToken());
//		}
		
		for(;st.hasMoreTokens();) {
			System.out.println(st.nextToken());
		}
	}
}
