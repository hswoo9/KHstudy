package com.kh.chapter3.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class B_JavaTime {
	public void method1() {		
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime when = LocalDateTime.of(2022, 5, 25, 22, 32, 25);
		
		System.out.println(now);
		System.out.println(when);
		System.out.println(ZonedDateTime.now());
		System.out.println();
		
		System.out.println(now.getYear());
		System.out.println(now.getMonth());
		System.out.println(now.getMonthValue());
		System.out.println(now.getDayOfMonth());
		System.out.println(now.getDayOfYear());
		System.out.println(now.getDayOfWeek());
		System.out.println(now.getHour());
		System.out.println(now.getMinute());
		System.out.println(now.getSecond());
		System.out.println(now.getNano());
		System.out.println();
		
		// 날짜와 시간을 조작하기
//		LocalDateTime plusDays = now.plusDays(1);
		LocalDateTime plusDays = now.plusDays(1).plusMonths(1).plusYears(1);
		LocalDateTime minusMonths = now.minusMonths(5);
		
		System.out.println(now);
		System.out.println(plusDays);
		System.out.println(minusMonths);
		System.out.println();
		
		System.out.println(now.isAfter(plusDays));
		System.out.println(now.isBefore(plusDays));
		System.out.println(now.isEqual(minusMonths));
		System.out.println();
		
//		LocalDate localDate = LocalDate.now();
//		LocalDate localDate = LocalDate.of(2022, 12, 2);
		LocalDate localDate = now.toLocalDate();
		
//		LocalTime localTime = LocalTime.now();
//		LocalTime localTime = LocalTime.of(9, 30, 45);
		LocalTime localTime = now.toLocalTime();
		
		System.out.println(now);
		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println();
		
//		DateTimeFormatter 클래스 사용
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일(E) a hh시 mm분 ss초");
		
		System.out.println(now.toString());
		System.out.println(now.format(formatter));
		System.out.println();
		
		System.out.println(now.format(DateTimeFormatter.ISO_ORDINAL_DATE));
		System.out.println(now.format(DateTimeFormatter.ISO_WEEK_DATE));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
	}
}
