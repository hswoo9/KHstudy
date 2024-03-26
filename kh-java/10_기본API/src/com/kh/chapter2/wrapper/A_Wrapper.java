package com.kh.chapter2.wrapper;

public class A_Wrapper {
	public void method1() {
		// Boxing
		int iNum = 10;
		double dNum = 3.14;
		
		// 1. 인스턴스 생성을 통한 방법 (Deprecated)
		Integer integer = new Integer(iNum);
		Double double1 = new Double(dNum);
		Double double2 = new Double(3.14);
		
		System.out.println(integer);
		System.out.println(double1);
		System.out.println(double2);
		System.out.println(double1 == double2);
		System.out.println(double1.equals(double2));
		System.out.println();
		
		// 2. 인스턴스를 직접 생성하지 않고 정적 메소드를 통한 방법
		Integer integer2 = Integer.valueOf(3);
		Double double3 = Double.valueOf(1.11);
		Double double4 = Double.valueOf("2.22");
		
		System.out.println(integer2);
		System.out.println(double3);
		System.out.println(double4);
		System.out.println();
		
		// 3. Auto Boxing
		Integer integer3 = 5;
		Double double5 = 180.5;
		
		System.out.println(integer3);
		System.out.println(double5);
		System.out.println();
		
		
		// UnBoxing
		// 1. Wrapper 인스턴스의 메소드를 통한 방법
		int iNum2 = integer.intValue();
		int iNum3 = integer2.intValue();
		
		System.out.println(iNum2 + iNum3);
		System.out.println();
		
		// 2. Wrapper 클래스의 정적 메소드를 통한 방법
		int iNum4 = Integer.parseInt("19");
		double dNum3 = Double.parseDouble("34.78");
		
		System.out.println(iNum4 + dNum3);
		System.out.println();
		
		// 3. Auto UnBoxing
		double dNum4 = double1;
		double dNum5 = double3;
		
		System.out.println(dNum4 + dNum5);
		System.out.println(integer + integer2);
		System.out.println(double4 + double5 + dNum4);
	}
}
