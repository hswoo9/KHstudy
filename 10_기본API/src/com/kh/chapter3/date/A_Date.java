package com.kh.chapter3.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class A_Date {
	public void method1() {
		// 기본 생성자로 인스턴스를 생성하면 현재 시스템의 시간에 대한 정보를 가지고 인스턴스를 생성한다.
		Date today = new Date();
		
		System.out.println(today);
		
		// 1970년 1월 1일 00시를 기준으로 밀리 세컨드 단위로 표기된다.
		// 한국 표준 시간(KST)으로 출력될 땐 그리니치 평균시(GMT)보다 +9 증가된 시간으로 표시된다.
		Date when = new Date(1);
		
		System.out.println(when);
		
		// Deprecated 된 생성자를 사용한 인스턴스 생성
		when = new Date((2022 - 1900), (12 - 1), 2);
		
		System.out.println(when);
		System.out.println();
		
		System.out.println(today.getTime());
		System.out.println((today.getYear() + 1900) + "년");
		System.out.println((today.getMonth() + 1) + "월");
		System.out.println(today.getDate() + "일");
		System.out.println(today.getHours() + "시");
		System.out.println(today.getMinutes() + "분");
		System.out.println(today.getSeconds() + "초");
		System.out.println();
		
		// SimpleDateFormat 클래스 사용
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일(E) a hh시 mm분 ss초");
		String formatDate = sdf.format(when);
		
		System.out.println(formatDate);
	}
}
