package com.kh.di.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kh.di.weapon.Weapon;

import lombok.Getter;
import lombok.ToString;

/*
 * properties 파일의 값을 읽어오는 방법
 * 
 * 1. @PropertySource()을 사용하는 방법
 *   - Environment 객체를 사용해서 character.properties에 설정된 값을 읽어온다.
 *   - 스프링 프로퍼티 플레이스 홀더를 사용해서 character.properties에 설정된 값을 읽어온다. (${키:기본값})
 *   
 * 2. @PropertySource()을 생략하는 방법
 *   - xml 설정 파일을 사용하는 경우 <context:property-placeholder/>를 추가한다.
 *   - java 설정 파일을 사용하는 경우 PropertySourcesPlaceholderConfigurer 빈을 등록한다.
 */

// 빈 생성 시 별도의 ID를 지정하지 않으면 클래스 이름에서 앞 글자를 소문자로 바꾼 ID를 갖는다.
@Component
@Getter
@ToString
//@PropertySource("classpath:character.properties")
public class Character {
	@Value("${character.name:홍길동}")
	private String name;
	
	@Value("${character.level:99}")
	private int level;
	
	@Autowired
	@Qualifier("windForce")
	private Weapon weapon;

//	@Autowired
//	public void setWeapon(Weapon weapon) {
//		this.weapon = weapon;
//	}
	
//	public Character(@Value("홍길동") String name, @Value("99") int level, /* @Autowired */ Weapon weapon) {
//		this.name = name;
//		this.level = level;
//		this.weapon = weapon;
//	}
	
//	public Character(/* @Autowired */ Environment env) {
//		this.name = env.getProperty("character.name");
//		this.level = Integer.parseInt(env.getProperty("character.level"));
//	}
}
