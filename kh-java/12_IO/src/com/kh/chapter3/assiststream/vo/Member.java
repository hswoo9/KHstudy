package com.kh.chapter3.assiststream.vo;

import java.io.Serializable;

public class Member implements Serializable {
	private static final long serialVersionUID = -2373099422823930486L;

	private String id;
	
	private String pwd;
	
	private String name;
	
	private String email;
	
	private int age;
	
	private char gender;
	
	private transient double point;
	
	public Member() {
	}

	public Member(String id, String pwd, String name, String email, int age, char gender, double point) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.point = point;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", age=" + age
				+ ", gender=" + gender + ", point=" + point + "]";
	}
}
