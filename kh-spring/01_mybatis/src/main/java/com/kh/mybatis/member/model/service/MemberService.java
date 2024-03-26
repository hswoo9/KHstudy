package com.kh.mybatis.member.model.service;

import static com.kh.mybatis.common.template.SqlSessionTemplate.getSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemberService {

	public int getMemberCount() {
		int count = 0;
		SqlSession session = getSession();
		
		count = new MemberDao().getMemberCount(session);
		
		log.info("getMemberCount() 메소드 호출");
		log.debug("getMemberCount() 메소드 호출 - " + count);
		
		session.close();
		
		return count;
	}

	public List<Member> findAll() {
		List<Member> members = null;
		SqlSession session = getSession();
		
		members = new MemberDao().findAll(session);
		
		session.close();
		
		return members;
	}

	public Member findMemberById(String id) {
		Member member = null;
		SqlSession session = getSession();
		
		member = new MemberDao().findMemberById(session, id);
		
		session.close();
		
		return member;
	}

	public int save(Member member) {
		int result = 0;
		SqlSession session = getSession();
		
		if(member.getNo() > 0) {
			result = new MemberDao().updateMember(session, member);
		} else {
			result = new MemberDao().insertMember(session, member);
		}
				
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

	public int delete(String id) {
		int result = 0;
		SqlSession session = getSession();
		
		result = new MemberDao().delete(session, id);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
}
