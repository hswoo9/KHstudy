package com.kh.mybatis.member.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.kh.mybatis.member.model.vo.Member;

@DisplayName("MemberService 테스트")
@TestMethodOrder(OrderAnnotation.class)
class MemberServiceTest {
	private MemberService service;
	
	// 각각의 테스트 메소드들이 실행되기 전에 실행되는 메소드
	@BeforeEach
	void setUp() {
		service = new MemberService();
	}

	@Test
	@Disabled
	void nothing() {
	}

	@Test
	@Disabled
	void create() {
		assertThat(service).isNotNull();
	}
	
	@Test
	@Order(1)
	@DisplayName("회원 수 조회 테스트")
	void getMemberCountTest() {
		int count = 0;
		
		count = service.getMemberCount();
		
//		System.out.println(count);
		
//		assertThat(count).isGreaterThan(0);
		assertThat(count).isPositive().isGreaterThanOrEqualTo(2);
	}
	
	@Test
	@Order(2)
	@DisplayName("모든 회원 조회 테스트")
	void findAllTest() {
		List<Member> members = null;
		
		members = service.findAll();
		
//		System.out.println(members);
		
		assertThat(members).isNotNull().isNotEmpty().extracting("id").contains("ismoon");
	}
	
	@ParameterizedTest
	@Order(3)
	@ValueSource(strings = {"admin2", "ismoon"})
	@DisplayName("회원 조회 테스트(ID로 검색)")
	void findMemberByIdTest(String id) {
		Member member = null;
		
		member = service.findMemberById(id);
		
//		System.out.println(member);
				
		assertThat(member).isNotNull();
		assertThat(member.getId()).isNotNull().isEqualTo(id);
	}
	
	@ParameterizedTest
	@CsvSource(value = {"test1, 1234, 홍길동", "test2, 4567, 임꺽정"})
	@Order(4)
	@DisplayName("회원 등록 테스트")
	void insertMemberTest(String id, String password, String name) {
		int result = 0;
		Member member = new Member(id, password, name);
		
		result = service.save(member);
		
		assertThat(result).isGreaterThan(0);
		assertThat(member.getNo()).isGreaterThan(0);
		assertThat(service.findMemberById(id)).isNotNull();
	}
	
	@ParameterizedTest
	@CsvSource({
		"test1, 0000, 이몽룡",
		"test2, 9999, 변사또"
	})
	@DisplayName("회원 정보 수정 테스트")
	@Order(5)
	void updateMemberTest(String id, String password, String name) {
		int result = 0;
		Member member = service.findMemberById(id);
		
		member.setPassword(password);
		member.setName(name);
		
		result = service.save(member);
		
		assertThat(result).isGreaterThan(0);
		assertThat(service.findMemberById(id).getName()).isEqualTo(name);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"test1", "test2"})
	@DisplayName("회원 삭제 테스트")
	@Order(6)
	void deleteTest(String id) {
		int result = 0;
		
		result = service.delete(id);
		
		assertThat(result).isEqualTo(1);
		assertThat(service.findMemberById(id)).isNull();
	}
}
