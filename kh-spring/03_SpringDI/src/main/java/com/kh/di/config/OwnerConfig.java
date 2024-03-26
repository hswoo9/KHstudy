package com.kh.di.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kh.di.owner.Owner;
import com.kh.di.pet.Pet;

@Configuration
public class OwnerConfig {
//	@Bean("moon")
//	public Owner owner() {
//		// dog() 메소드는 빈으로 등록되어있기 때문에 호출 시 마다 빈을 생성하는 것이 아닌
//		// 애플리케이션 컨텍스트에서 등록된 빈을 얻어온다.
//		return new Owner("문인수", 19, dog());
//	}
	
	@Bean("moon")
	public Owner owner(@Autowired @Qualifier("dog") Pet pet) {

		return new Owner("문인수", 19, pet);
	}
	
	@Bean
	public Owner hong(/* @Autowired */ Pet pet) {
		Owner owner = new Owner();
		
		owner.setName("홍길동");
		owner.setAge(30);
		owner.setPet(pet);
		
		return owner;
	}
}
