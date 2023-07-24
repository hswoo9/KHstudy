package com.kh.control.practice;

import java.util.Scanner;

public class C_For {
	/*
	 * for 문
	 *   [표기법]
	 *     for(초기식; 조건식; 증감식) {
	 *       .. 실행 코드 ..
	 *     }
	 *     
	 *   - 초기식은 반복문이 수행될 때 단 한 번만 실행되는 구문으로 반복문 안에서 사용할게 될 변수를 선언하고 초기값을 대입한다.
	 *   - 조건식은 반복문이 수행되는 조건을 작성하는 구문으로 조건식의 결과가 true이면 실행 코드를 수행하고, 
	 *     조건식의 결과가 false이면 실행 코드를 수행하지 않고 반복문을 빠져나온다.
	 *   - 증감식은 반복문을 제어하는 변수의 값을 증감시키는 구문으로 주로 초기식에 제시한 변수를 가지고 증감 연산자를 사용한다.
	 */
	public void method1() {
		// 반복문을 사용하지 않을 때
//		System.out.println(1);
//		System.out.println(2);
//		System.out.println(3);
//		System.out.println(4);
//		System.out.println(5);
//		System.out.println(6);
//		System.out.println(7);
//		System.out.println(8);
//		System.out.println(9);
//		System.out.println(10);
//		
//		System.out.println(1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10);
		
		// 반복문을 사용할 때
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}

		System.out.println();
		
		for(int i = 10; i >= 1; i--) {
			System.out.println(i);
		}
	}

	public void method2() {
		// 1부터 10까지의 정수들의 합계를 출력
		// 1 + 2 + 3 + 4 + ... + 10
		// sum += 1; // sum = sum + 1;
		// sum += 2;
		// sum += 3;
		// ...
		// sum += 10;
		
		int sum = 0;
		
		for(int i = 1; i <= 10; i++) {
//		for(int i = 1; i <= 10; i += 2) {
			sum += i; // sum = sum + i;
		}
		
		System.out.println("합계 : " + sum);
	}

	public void method3() {
		/*
		 * 1부터 랜덤값(1 ~ 10)까지의 합계를 구하시오.
		 * 
		 * java.lang.Math 클래스에서 제공하는 random() 메소드를 사용해서 랜덤값을 발생시킬 수 있다.
		 * java.lang.Math.random() 호출 시 -> 0.0 ~ 0.99999.. 사이의 값을 발생
		 */
		
//		int random = Math.random(); // double 타입
//		int random = (int) (Math.random() * 10); // 0.0 ~ 9.999999..
		int random = (int) (Math.random() * 10 + 1); // 1.0 ~ 10.999999.. -> 1 ~ 10
		int sum = 0;

		for(int i = 1; i <= random; i++) {
			sum += i;
		}		
		
		System.out.printf("1부터 %d까지의 합 : %d\n", random, sum);
	}
	
	/*
	 * 중첩 for 문
	 *   [표현법]
	 *     for(초기식; 조건식; 증감식) {
	 *       .. 실행 코드 ..
	 *       
	 *       for(초기식; 조건식; 증감식) {
	 *         .. 실행 코드 ..
	 *       }
	 *       
	 *       .. 실행 코드 ..
	 *     }
	 */
	
	public void method4() {
		/*
		 * 2단 ~ 9단 출력
		 *   단은 2 ~ 9까지 1씩 증가 (바깥쪽 for 문을 통해 해결)
		 *   곱해지는 수는 1 ~ 9까지 1씩 증가 (안쪽 for문을 통해 해결)
		 *   
		 * 예시)
		 *   == 2단 ==
		 *   2 X 1 = 2
		 *   2 X 2 = 4
		 *   ...
		 *   == 9단 ==
		 *   9 X 1 = 9
		 *   9 X 2 = 18
		 *   9 X 3 = 27
		 *   ...
		 *   9 X 9 = 81
		 */
		
		for (int i = 2; i <= 9; i++) {
			System.out.printf("== %d단 ==\n", i);
			
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d X %d = %d\n", i, j, (i * j));
			}
		}
	}
	
	public void method5() {
		/*
		 	*****
		 	*****
		 	*****
		 	*****
		 	
		 	행이 1 ~ 4까지 반복 (바깥쪽 for 문)
		 	열이 1 ~ 5까지 반복 (안쪽 for 문)
		 */
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	/*
	 * 실습 문제 1
	 * 1부터 사용자가 입력한 수까지의 합계를 구하시오.
	 * 예시)
	 *   정수 > 10
	 *   총 합계 > 55
	 */
	public void practice1() {
		int num = 0;
		int sum = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수 > ");
		num = scanner.nextInt();
		
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		
		System.out.println("총 합계 > " + sum);
		scanner.close();
	}
	
	/*
	 * 실습 문제 2
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
	public void practice2() {
		int num = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("단 수(2 ~ 9)를 입력해 주세요. > ");
		num = scanner.nextInt();
		
		if(num >= 2 && num < 10) {
			for(int i = 1; i < 10; i++) {
				System.out.printf("%d X %d = %d\n", num, i, (num * i));
			}
		} else {
			System.out.println("1 ~ 9 사이의 양수를 입력하여야 합니다.");
		}
		
		scanner.close();
	}
	
	/*
	 * 실습 문제 3
	 * 
	 * 아래와 같이 출력 되도록 중첩 for 문을 작성하시오.
	 * 
	 * 예시)
	 *   1***
	 *   *2**
	 *   **3*
	 *   ***4
	 */
	public void practice3() {
		// 행이 1 ~ 4까지 반복, 열이 1 ~ 4까지 반복
		// 행과 열의 값이 같으면 숫자를 출력, 이외에는 * 출력
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if(i == j) {
					System.out.print(i);
				} else {					
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
	}
	
	/*
	 * 실습 문제 4
	 * 
	 * 아래와 같이 출력 되도록 중첩 for 문을 작성하시오.
	 * 
	 * 예시)
	 *   *
	 *   **
	 *   ***
	 *   ****
	 *   *****
	 */
	public void practice4() {
		// 행이 1 ~ 5까지 반복, 열이 1 ~ 5까지 반복
		// 열의 값이 행보다 작거나 같을 때까지 * 출력
		for (int i = 1; i <= 5; i++) {
//			for (int j = 1; j <= i; j++) {
			for (int j = 1; j <= 5; j++) {
				if(j <= i) {					
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
