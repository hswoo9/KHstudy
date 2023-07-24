package com.kh.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CharacterAspect {
	@Pointcut("execution(* com.kh.aop.character.Character.quest(..)) && args(questName)")
	public void questPointcut(String questName) {
	}
	
//	@Before("questPointcut(questName)")
	public void beforeQuest(String questName) {
		// 퀘스트를 수행하기 전에 필요한 부가 작업들 수행
		
		System.out.println(questName + " 퀘스트 준비 중..");
	}
	
//	@After("execution(* com.kh.aop.character.Character.quest(..))")
	public void afterQuest() {
		// 퀘스트 수행 결과에 상관없이 필요한 부가 작업을 수행
		
		System.out.println("퀘스트 수행 완료..");
	}
	
//	@AfterReturning(
//		value = "questPointcut(questName)", 
//		returning = "result"
//	)
	public void questSuccess(String questName, String result) {
		// 퀘스트 수행 완료 후에 필요한 부가 작업을 수행한다.
		
		System.out.println(result);
		System.out.println(questName + " 퀘스트 수행 완료..");
	}
	
//	@AfterThrowing(
//		value = "questPointcut(questName)",
//		throwing = "exception"
//	)
	public void questFail(String questName, Exception exception) {
		// 퀘스트 수행 중에 예외를 던졌을 때 필요한 부가 작업을 수행한다.
		
		System.out.println(exception.getMessage());
		System.out.println(questName + " 퀘스트 수행 중 에러가 발생하였습니다.");
	}

	@Around("execution(* com.kh.aop.character.Character.quest(..))")
	public String aroundQuest(ProceedingJoinPoint joinPoint) {
		String result = null;
		String questName = "<" + (String) joinPoint.getArgs()[0] + ">";
		
		try {
			// before 어드바이스에 대한 기능을 수행
			System.out.println(questName + " 퀘스트 준비 중..");
			
			// 타겟 객체의 메소드를 실행시킨다.
//			joinPoint.proceed();
			
			// 타겟 객체의 메소드에 리턴값이 있는 경우
//			result = (String) joinPoint.proceed();
			
			// 타겟 객체의 메소드에 파라미터 값을 변경해서 전달하는 경우
			result = (String) joinPoint.proceed(new Object[] { questName });
			
			// after-returning 어드바이스에 대한 기능을 수행
			System.out.println(questName + " 퀘스트 수행 완료..");
		} catch (Throwable e) {
			// after-throwing 어드바이스에 대한 기능을 수행
			System.out.println(questName + " 퀘스트 수행 중 에러가 발생하였습니다.");
		}
		
		return result;
	}
	
	// 실습 문제
	// Sword, Bow의 attack 메소드 실행 시
	// @Around 어드바이스를 사용하여 코드 작성하세요.
	// 1. attack 메소드 정상 동작
	//    공격을 준비 중입니다.
	//    "검을 휘두른다." or "활을 쏜다." 출력
	//    공격을 성공했습니다.
	// 2. attack 메소드 실행 중에 예외 발생 시
	//    공격을 준비 중입니다.
	//    에러가 발생하였습니다.
	
//	@Around("execution(* com.kh.aop.weapon.*.attack())")
	@Around("execution(* com.kh.aop.weapon.Weapon.attack())")
	public String attackAdvice(ProceedingJoinPoint jp) {
		String result = null;
		
		try {
			System.out.println("공격을 준비 중입니다.");
			
			result = (String) jp.proceed();
			
			System.out.println(result);
			System.out.println("공격을 성공했습니다.");
		} catch (Throwable e) {
			
			System.out.println("에러가 발생하였습니다.");
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
