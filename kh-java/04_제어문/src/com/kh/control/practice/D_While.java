package com.kh.control.practice;

import java.util.Scanner;

public class D_While {
	/*
	 * while 문
	 *   [표현법]
	 *   
	 *     [초기식]
	 *   
	 *     while(조건식) {
	 *       ..실행 코드..
	 *       
	 *       [증감식, 분기문]
	 *     }
	 */
	
	public void method1() {
		// 1부터 랜덤값(1 ~ 10)까지의 합계
		int sum = 0;
		int random = (int) (Math.random() * 10 + 1);
		
		int i = 0;
		
		while(i <= random) {
			sum += i;
			
			i++;
		}
		
		System.out.printf("1부터 %d까지의 합 : %d\n", random, sum);
	}

	/*
	 * 사용자에게 계속 문자열을 입력 받고 그 문자열을 출력한다.
	 * 단, "exit" 문자열을 입력하면 프로그램을 종료한다.
	 */
	public void method2() {
		String str = "프로그램을 시작합니다.";
		Scanner scanner = new Scanner(System.in);
		
//		while(true) {
//			System.out.print("문자열을 입력해 주세요. > ");
//			str = scanner.nextLine();
//			
//			if(str.equals("exit")) {
//				System.out.println("프로그램을 종료합니다.");
//				scanner.close();
//				
//				break;
//			}
//			
//			System.out.println(str);
//		}
		
		while(!str.equals("exit")) {
			System.out.println(str);
			
			System.out.print("문자열을 입력해 주세요. > ");
			
			str = scanner.nextLine();
			
		}
		
		System.out.println("프로그램을 종료합니다.");
		scanner.close();
	}
	
	/*
	 * 실습 문제 1
	 * 사용자가 입력한 단을 출력하시오. 
	 *  예시)
	 *    단 수(2 ~ 9)를 입력해 주세요. > 3
	 *    3 X 1 = 3
	 *    ...
	 *    3 X 9 = 27
	 *    
	 *    단 수(2 ~ 9)를 입력해 주세요. > 12
	 *    1 ~ 9 사이의 양수를 입력하여야 합니다.
	 */
	public void practice() {
		int num = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("단 수(2 ~ 9)를 입력해 주세요. > ");
		num = scanner.nextInt();
		
		if(num >= 2 && num < 10) {
			int i = 1;
			
			while(i <= 9) {
				System.out.printf("%d X %d = %d\n", num, i, (num * i));
				
				i++;
			}
		} else {
			System.out.println("1 ~ 9 사이의 양수를 입력하여야 합니다.");
		}
		
		scanner.close();
	}

	/*
	 * do-while 문
	 *   [표현법]
	 *   
	 *     [초기식]
	 *     
	 *     do {
	 *       .. 실행 코드 ..
	 *       
	 *       [증감식, 분기문]
	 *     } while(조건식);
	 */
	public void method3() {
		// 조건에 상관없이 무조건 한 번은 출력이 되는지 확인
		int number = 1;
		
		while(number == 0) {
			System.out.println("while 문 실행");
		}
		
		do {
			System.out.println("do-while 문 실행");			
		} while(number == 0);	
	}
	
	/*
	 * 예시)
	 * ============ 메뉴 ============
	 * 1. C_For 클래스의 method1() 실행
	 * 2. C_For 클래스의 method2() 실행
	 * 3. C_For 클래스의 method3() 실행
	 * Q(q). 프로그램 종료
	 * =============================
	 * > q
	 * 
	 * 프로그램이 종료됩니다.
	 */
	public void method4() {
		char menu = '\u0000';
		Scanner scanner = new Scanner(System.in);
		C_For example = new C_For();
		
//		for(;;) { ... }
//		while(true) { ... }
		do {
			System.out.println("============ 메뉴 ============");
			System.out.println("1. C_For 클래스의 method1() 실행");
			System.out.println("2. C_For 클래스의 method2() 실행");
			System.out.println("3. C_For 클래스의 method3() 실행");
			System.out.println("Q(q). 프로그램 종료");
			System.out.println("=============================");
			System.out.print("> ");
			
			menu = scanner.nextLine().charAt(0);
			
			switch (menu) {
				case '1':
					example.method1();
					
					break;
				case '2':
					example.method2();
					
					break;
				case '3':
					example.method3();
					
					break;
				case 'Q':
				case 'q':
					System.out.println("프로그램이 종료됩니다.");
					scanner.close();
					
					return;
				default:
					System.out.println("메뉴를 잘못 입력했습니다.");
			}
		} while(true);
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	








}
