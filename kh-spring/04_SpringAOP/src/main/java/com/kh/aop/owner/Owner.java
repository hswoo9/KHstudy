package com.kh.aop.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kh.aop.pet.Pet;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@Component
public class Owner {
	@Value("문인수")
	private String name;
	
	@Value("20")
	private int age;
	
	@Autowired
//	@Qualifier("cat")
	private Pet pet;
}
