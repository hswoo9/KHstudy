package com.kh.chapter3._interface;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmartPhone extends Product {
	
	private String mobileAgency;

	public SmartPhone() {
	}

	public SmartPhone(String brand, String pCode, String name, int price, String mobileAgency) {
		super(brand, pCode, name, price);
		
		this.mobileAgency = mobileAgency;
	}

	@Override
	public String information() {
		return super.information() + ", mobileAgency : " + mobileAgency;
	}

	@Override
	public void turnOn() {
		System.out.println("스마트폰을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("스마트폰을 끕니다.");
	}
}
