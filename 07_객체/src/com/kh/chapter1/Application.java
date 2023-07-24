package com.kh.chapter1;

import com.kh.chapter1.object.Student;

public class Application {
	/*
	 * 추상화와 캡슐화
	 * 
	 * 1. 추상화
	 *   - 프로그램에서 사용할 객체들이 가진 공통적인 특성들을 파악하고 불필요한 특성들을 제거하는 과정을 말한다.
	 *   - 최종적으로 선정된 속성들을 가지고 어떠한 자료형으로, 어떠한 변수명으로 사용할지 정리해서 코드로 작성한다.
	 *   
	 * 2. 캡슐화
	 *   - 추상화를 통해서 정의된 속성들과 기능을 하나로 묶어서 관리하는 기법을 말한다.
	 *   - 객체의 데이터에 직접 접근을 막고, 데이터를 간접적으로 처리하는 메소드들을 클래스 내부에 작성하여 제공한다.
	 */

	public static void main(String[] args) {
		// 문인수 학생 객체 만들기
		int sNum = 1001;
		String name = "문인수";
		int age = 18;
		int math = 90;
		int eng = 70;
		int sum = math + eng;
		double avg = sum / 2.0;
		
		// 홍길동 학생 객체 만들기
		int sNum2 = 1002;
		String name2 = "홍길동";
		int age2 = 30;
		int math2 = 90;
		int eng2 = 60;
		int sum2 = math2 + eng2;
		double avg2 = sum2 / 2.0;
		
		// Student 클래스를 new 연산자를 통해서 Heap 영역에 인스턴스로 생성한다.
//		Student moon = new Student();
//		Student hong = new Student();
		
		// 필드에 직접 접근해서 값을 초기화
//		moon.sNum = 1001;
//		moon.name ="문인수";
//		moon.age = 120;
//		moon.math = 90;
//		moon.eng = 70;
//		
//		hong.sNum = 1002;
//		hong.name = "홍길동";
//		hong.age = 30;
//		hong.math = 90;
//		hong.eng = 60;
		
		// 필드에 직접 접근해서 값을 출력
//		System.out.printf("%s님의 수학 점수는 %d, 영어 점수는 %d, 총점은 %d, 평균은 %.2f 입니다.\n", 
//				moon.name, moon.math, moon.eng, moon.sum(), moon.avg());
//		System.out.printf("%s님의 수학 점수는 %d, 영어 점수는 %d, 총점은 %d, 평균은 %.2f 입니다.\n", 
//				hong.name, hong.math, hong.eng, hong.sum(), hong.avg());
		
		Student moon = new Student();
		Student hong = new Student();
		
		moon.setSNum(1001);
		moon.setName("문인수");
		moon.setAge(-20);
		moon.setMath(900);
		moon.setEng(-650);
		
		hong.setSNum(1002);
		hong.setName("홍길동");
		hong.setAge(30);
		hong.setMath(80);
		hong.setEng(75);

		moon.information();
		hong.information();
//		System.out.printf("%s님의 나이는 %d, 수학 점수는 %d, 영어 점수는 %d, 총점은 %d, 평균은 %.2f 입니다.\n", 
//				moon.getName(), moon.getAge(), moon.getMath(), moon.getEng(), moon.sum(), moon.avg());
//		System.out.printf("%s님의 나이는 %d, 수학 점수는 %d, 영어 점수는 %d, 총점은 %d, 평균은 %.2f 입니다.\n", 
//				hong.getName(), hong.getAge(), hong.getMath(), hong.getEng(), hong.sum(), hong.avg());
		
		
		
		
		
		
		
		
	}

}
