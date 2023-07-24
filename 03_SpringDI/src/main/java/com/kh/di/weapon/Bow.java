package com.kh.di.weapon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Component("windForce")
public class Bow implements Weapon {
	@Value("${character.weapon.name:활}")
	private String name;

	@Override
	public String attack() {
		
		return "활을 쏜다.";
	}
}
