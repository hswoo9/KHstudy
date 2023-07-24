package com.kh.chapter4.constructor;

/*
 * 생성자
 *   - 생성자는 클래스로부터 객체를 생성할 때 호출되어 객체의 초기화를 담당한다. (필드 초기화, 객체를 사용할 준비)
 *   - 생성자 작성 시 주의사항
 *     - 생성자의 이름은 반드시 클래스 이름과 동일해야 한다.
 *     - 반환형이 존재하지 않는다.
 *     - 매개 변수가 있는 생성자를 작성하게 되면 기본 생성자를 자동으로 만들어주지 않는다. 
 */
public class User {
	private String id;
	
	private String password;
	
	private String name;
	
	private int age;
	
	private char gender;
	
	/*
	 * 기본 생성자
	 *   - 객체 생성만을 목적으로 사용된다.
	 *   - 기본 생성자를 생략하는 경우, 자동으로 만들어줬기 때문에 항상 객체 생성이 가능했다.
	 */
	public User() {
		System.out.println("기본 생성자 호출");
	}
	
	/*
	 * 매개변수가 있는 생성자 (아이디, 패스워드, 이름)
	 * 객체 생성과 동시에 전달된 값들을 매개변수로 받아서 필드를 초기화하는 목적으로 사용된다.
	 */
	public User(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
		// 나머지 필드(age, gender)는 JVM이 초기값을 설정해준다.
	}	
	
	/*
	 * 매개변수가 있는 생성 (아이디, 패스워드, 이름, 나이, 성별)
	 */
	public User(String id, String password, String name, int age, char gender) {
//		this.id = id;
//		this.password = password;
//		this.name = name;
		this(id, password, name);
		this.age = age;
		this.gender = gender;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String information() {		
//		this(id, password, name);
//		System.out.println("this : " + this);
		
		return id + ", " + password + ", " + name + ", " + age + ", " + gender;
	}
}
