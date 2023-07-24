package com.kh.chapter3._interface;

public abstract class Product implements Basic, Basic2 {
	protected String brand; // 브랜드
	
	protected String pCode; // 상품번호
	
	protected String name; // 상품명
	
	protected int price; // 가격
	
	public Product() {
	}

	public Product(String brand, String pCode, String name, int price) {
		this.brand = brand;
		this.pCode = pCode;
		this.name = name;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String information() {
		return "brand : " + brand + ", pCode : " + pCode + ", price : " + price 
				+ ", name : " + name;
	}
}
