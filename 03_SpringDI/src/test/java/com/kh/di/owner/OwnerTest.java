package com.kh.di.owner;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.di.config.RootConfig;
import com.kh.di.pet.Cat;

/*
 * JUnit에서 스프링을 사용할 수 있도록 SpringExtension.class 사용하여 확장한다.
 * 해당 설정이 있어야 @ContextConfiguration()을 통해서 설정 파일을 읽고 애플리케이션 컨텍스트를 생성할 수 있다.
 */
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = RootConfig.class)
@ContextConfiguration(locations = "classpath:spring/root-context.xml")
class OwnerTest {
	@Autowired
	@Qualifier("hong")
	private Owner owner;

	@Test
	void nothing() {
	}

	@Test
	void create() {
		// 기존에 자바 애플리케이션에서는 다형성을 통해서 객체간의 결합도를 느슨하게 만들어준다. 
		// 생성자를 통한 의존성 주입
//		Owner owner = new Owner("문인수", 20, new Dog("보리"));
//		Owner owner = new Owner("문인수", 20, new Cat("콜리"));
		Owner owner = new Owner();
		
		owner.setName("문인수");
		owner.setAge(20);
		// 메소드를 통한 의존성 주입
//		owner.setPet(new Dog("보리"));
		owner.setPet(new Cat("콜리"));
		
//		System.out.println(owner);
//		System.out.println(owner.getPet());
//		System.out.println(owner.getPet().getName());
		
		assertThat(owner).isNotNull();
		assertThat(owner.getPet()).isNotNull();
		assertThat(owner.getPet().getName()).isNotNull().isEqualTo("콜리");
	}
	
	@Test
	void contextTest() {
		// 스프링은 애플리케이션 컨텍스트를 활용하여 객체 간의 결합을 더욱 느슨하게 만들어준다.
		ApplicationContext context = 
//				new GenericXmlApplicationContext("spring/root-context.xml"); // 기본적으로 클래스패스를 기준으로 파일을 찾는다.
//				new GenericXmlApplicationContext("classpath:spring/root-context.xml");
//				new GenericXmlApplicationContext("file:src/main/resources/spring/root-context.xml");
				new AnnotationConfigApplicationContext(RootConfig.class);
		
//		Owner owner = (Owner) context.getBean("moon");
//		Owner owner = context.getBean("moon", Owner.class);
		Owner owner = context.getBean("hong", Owner.class);
				
		assertThat(context).isNotNull();
		assertThat(owner).isNotNull();
		assertThat(owner.getPet()).isNotNull();
	}
	
	@Test
	void autoWiredTest() {
		assertThat(owner).isNotNull();
		assertThat(owner.getPet()).isNotNull();
	}
}
