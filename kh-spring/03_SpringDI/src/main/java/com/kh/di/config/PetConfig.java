package com.kh.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.kh.di.pet.Cat;
import com.kh.di.pet.Dog;

@Configuration
public class PetConfig {
	@Bean // 별도로 빈 ID를 지정해주지 않으면 메소드명으로 ID를 지정한다.
	public Dog dog() {
		return new Dog("보리");
	}
	
	@Bean
	@Primary
	public Cat cat() {
		Cat cat = new Cat();
		
		cat.setName("콜리");
		
		return cat;
	}
}
