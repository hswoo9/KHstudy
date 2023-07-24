package com.kh.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

// 해당 클래스가 자바 설정 파일임을 선언한다.
@Configuration
@Import(
	value = {
		OwnerConfig.class,
		PetConfig.class
	}
)
@ComponentScan("com.kh.di")
public class RootConfig {
	
	@Bean
	public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		PropertySourcesPlaceholderConfigurer configurer = null;
		Resource[] resources;
		
		configurer = new PropertySourcesPlaceholderConfigurer();
		resources= new ClassPathResource[] {
			new ClassPathResource("character.properties"),
			new ClassPathResource("driver.properties")
		};
		
		configurer.setLocations(resources);
		
		return configurer;
	}
}
