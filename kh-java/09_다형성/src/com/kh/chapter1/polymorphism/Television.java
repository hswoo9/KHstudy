package com.kh.chapter1.polymorphism;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Television extends Product {
	private int inch;
	
	public Television() {
	}

	public Television(String brand, String pCode, String name, int price, int inch) {
//		super();
		this.brand = brand;
		this.pCode = pCode;
		this.name = name;
		this.price = price;
		this.inch = inch;
	}

	@Override
	public String information() {
		return super.information() + ", inch : " + inch;
	}
}
