package com.kh.chapter4;

import java.util.Arrays;

import com.kh.chapter4.constructor.User;

public class Application {

	public static void main(String[] args) {
		User user = null;
				
		// 기본 생성자로 인스턴스 생성
		user = new User();
		
//		System.out.println("user : " + user);
		System.out.println(user.information());
		
		user.setId("ismoon");
		user.setPassword("1234");
		user.setName("문인수");
		user.setAge(17);
		user.setGender('남');
		
		System.out.println(user.information());
		
		// 매개변수가 있는 생성자로 인스턴스 생성 (3개의 값을 생성자로 전달)
		user = new User("hong", "5678", "홍길동");
		
		System.out.println(user.information());
		
		// 매개변수가 있는 생성자로 인스턴스 생성 (5개의 값을 생성자로 전달)
		user = new User("jyp", "0000", "박진영", 50, '남');
		
		System.out.println(user.information());
	}

}
