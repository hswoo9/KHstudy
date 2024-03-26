package com.kh.exception.practice;

public class A_TryCatch {
	/*
	 *  try-catch
	 *    [표현법]
	 *      try {
	 *        // 예외가 발생할 가능성이 있는 코드가 위치한다.
	 *        ...
	 *      } catch (Exception e) {
	 *        // try 블록에서 예외가 발생하면 실행을 멈추고 catch 블록으로 이동하여 예외 처리 코드를 실행한다.
	 *        ...
	 *      } [finally {
	 *        // 예외가 발생하지 않거나 예외가 발생해 catch 블록을 실행한 후 무조건 실행되는 코드 블록이다. (생략 가능)
	 *        ...
	 *      }]
	 */
	public void method1() {
		try {
			int result = 10 / 0;
			
			System.out.println(result);
		} catch (ClassCastException | ArithmeticException e) {
			System.out.println("ClassCastException 또는 ArithmeticException 예외가 발생했습니다.");
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("예외 발생 여부와 상관없이 무조건 수행된다.");
		}
	}
}
