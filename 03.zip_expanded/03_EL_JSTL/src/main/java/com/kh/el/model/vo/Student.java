package com.kh.el.model.vo;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
	private String name;
	
	private int age;
	
	private int math;
	
	private int english;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(String name, int age, int math, int english) {
		super();
		this.name = name;
		this.age = age;
		this.math = math;
		this.english = english;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, english, math, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && english == other.english && math == other.math && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", math=" + math + ", english=" + english + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	
}
