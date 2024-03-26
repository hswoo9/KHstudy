package com.kh.di.pet;

public abstract class Pet {
	
	private String name;
	
	public Pet() {
	}
	
	public Pet(String name) {
		this.name = name;
	}

	public abstract String bark();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
