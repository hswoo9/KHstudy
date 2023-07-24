package com.kh.chapter5;

import com.kh.chapter4.constructor.User;
import com.kh.chapter5.method.A_Method;
import com.kh.chapter5.method.C_StaticMethod;

public class Application {

	public static void main(String[] args) {
		A_Method methodTest = new A_Method();
		
		// 1. 매개변수와 반환값이 없는 메소드 호출
		methodTest.method1();
		
		System.out.println();
		
		// 2. 매개변수가 없고 반환값이 있는 메소드 호출
		String str = methodTest.method2();
		System.out.println(str);
		
		System.out.println();

		// 3. 매개변수가 있고 반환값이 없는 메소드 호출
		methodTest.method3(10, 20);
		
		System.out.println();
		
		// 4. 매개변수가 있고 반환값이 있는 메소드 호출
		System.out.println(methodTest.method4(30, 20));
		
		System.out.println();
		
		// 5. 매개변수로 User 객체를 전달받는 메소드 호출
		User user = new User("ismoon", "1234", "문인수", 25, '남');
		
		System.out.println(user.information());
		methodTest.method5(user);
		System.out.println(user.information());
		
		System.out.println();
		
		// 6. 매개변수로 가변인자를 전달받는 메소드 호출
		int[] arr = {1, 2};
		
		methodTest.method6(arr);
//		methodTest.method6({2, 3, 4}); // 에러 발생
		methodTest.method6(new int[] {2, 3, 4});
//		methodTest.method6();

		System.out.println();
		
//		methodTest.method7(1, 2, 5);
//		methodTest.method7(); // new int[]{};
		methodTest.method7("문인수");
		methodTest.method7("문인수", 1, 2, 3);
		
		System.out.println("=====================");
		
		// 1. 매개변수와 반환값이 없는 메소드 호출
		C_StaticMethod.method1();
		System.out.println(C_StaticMethod.num1);
		System.out.println(C_StaticMethod.num2);
		
		System.out.println();
		
		// 2. 매개변수가 없고 반환값이 있는 메소드 호출
		System.out.println(C_StaticMethod.method2());
		
		System.out.println();
		
		// 3. 매개변수가 있고 반환값이 없는 메소드 호출
		C_StaticMethod.method3(30);
		
		System.out.println();
		
		// 4. 매개변수와 반환값이 있는 메소드 호출
		System.out.println(C_StaticMethod.method4());
		System.out.println(C_StaticMethod.method4(8, 9));
		System.out.println(C_StaticMethod.method4(8, 9, 10, 50, 30));
	}
}
