package com.kh.di.weapon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Primary
@Component
public class Sword implements Weapon {
	@Value("크리스탈 소드")
	private String name;

	@Override
	public String attack() {
		
		return "검을 휘두른다.";
	}

}
