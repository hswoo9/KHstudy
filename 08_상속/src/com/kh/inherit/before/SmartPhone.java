package com.kh.inherit.before;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SmartPhone {
	private String brand; // 브랜드
	
	private String pCode; // 상품코드
	
	private String name; // 상품명
	
	private int price;  // 가격
	
	private String mobileAgency; // 통신사
	
	public String information() {
		return "brand : " + brand + ", pCode : " + pCode + ", price : " + price 
				+ ", name : " + name + ", mobileAgency : " + mobileAgency;
	}
}
