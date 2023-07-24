package com.kh.chapter1.string;

public class B_StringBuilder {
	public void method1() {
		// StringBuilder 클래스의 기본 생성자를 통해서 인스턴스를 생성하면 16개의 문자를 저장할 수 있는 버퍼가 생성된다.
		StringBuilder sb1 = new StringBuilder();
		// StringBuilder 클래스의 생성자에 정수값을 전달해주면 해당 크기 만큼의 버퍼가 생성된다.
		StringBuilder sb2 = new StringBuilder(30);
		// StringBuilder 클래스의 생성자에 문자열을 전달해주면 문자열 크기 + 16 만큼의 버퍼가 생성된다.
		StringBuilder sb3 = new StringBuilder("Hello");
		
		System.out.println("sb1의 문자열 길이 : " + sb1.length());
		System.out.println("sb1의 버퍼의 길이 : " + sb1.capacity());
		System.out.println("sb2의 문자열 길이 : " + sb2.length());
		System.out.println("sb2의 버퍼의 길이 : " + sb2.capacity());
		System.out.println("sb3의 문자열 길이 : " + sb3.length());
		System.out.println("sb3의 버퍼의 길이 : " + sb3.capacity());
	}

	public void method2() {
		String str = "안녕하세요.";
		StringBuilder sb = new StringBuilder("안녕하세요.");
		
		System.out.println(System.identityHashCode(str));
		System.out.println(System.identityHashCode(sb));
		System.out.println();
	
		// 1. append(String) 메소드는 기존 문자열 뒤에 문자열을 추가한다.
		str += "저는 문인수입니다.";
		sb.append("저는 문인수입니다.");
		
		System.out.println("str : " + str);
		System.out.println("sb : " + sb);
		System.out.println("sb의 문자열 길이 : " + sb.length());
		System.out.println("sb의 버퍼의 크기 : " + sb.capacity());
		System.out.println(System.identityHashCode(str));
		System.out.println(System.identityHashCode(sb));
		System.out.println();
		
		sb.append("여러분 힘내세요^^");
		System.out.println("sb : " + sb);
		System.out.println("sb의 문자열 길이 : " + sb.length());
		System.out.println("sb의 버퍼의 크기 : " + sb.capacity());
		System.out.println(System.identityHashCode(sb));
		System.out.println();
		
		// 2. insert(int offset, String str) 메소드는 문자열의 offset 위치부터 전달받은 문자열을 추가한다.
		sb.insert(1, "ㅋㅋㅋㅋ");
		System.out.println("sb : " + sb);
		System.out.println("sb의 문자열 길이 : " + sb.length());
		System.out.println("sb의 버퍼의 크기 : " + sb.capacity());
		System.out.println(System.identityHashCode(sb));
		System.out.println();
		
		// 3. delete(int start, int end) 메소드는 start에서 end - 1까지의 인덱스에 해당하는 문자열을 삭제한다.
		sb.delete(1, 5);
		System.out.println("sb : " + sb);
		System.out.println("sb의 문자열 길이 : " + sb.length());
		System.out.println("sb의 버퍼의 크기 : " + sb.capacity());
		System.out.println(System.identityHashCode(sb));
		System.out.println();
		
		// 4. reverse() 메소드는 문자열의 순서를 역으로 바꾼다.
		sb.reverse();
		System.out.println("sb : " + sb);
		System.out.println("sb의 문자열 길이 : " + sb.length());
		System.out.println("sb의 버퍼의 크기 : " + sb.capacity());
		System.out.println(System.identityHashCode(sb));
		System.out.println();
		
		// 5. 메소드 체이닝
		StringBuilder sb2 = new StringBuilder("Java Program");
		
		sb2.append("API").delete(4, 11).reverse();
		
		System.out.println("sb2 : " + sb2);
	}

}
