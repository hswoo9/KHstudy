package com.kh.chapter3._interface;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Television extends Product {
	private int inch;
	
	public Television() {
	}

	public Television(String brand, String pCode, String name, int price, int inch) {
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

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}
}
