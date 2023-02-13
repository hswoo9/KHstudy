package com.kh.mvc.member.model.service;

import static com.kh.mvc.common.jdbc.JDBCTemplate.close;
import static com.kh.mvc.common.jdbc.JDBCTemplate.commit;
import static com.kh.mvc.common.jdbc.JDBCTemplate.getConnection;
import static com.kh.mvc.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.mvc.member.model.dao.MemberDao;
import com.kh.mvc.member.model.vo.Member;

public class MemberService {

	public Member login(String userId, String userPwd) {
		Member member = this.findMemberById(userId); 
		
		if(member == null || !member.getPassword().equals(userPwd)) {
			return null;
		}
		
		return member;
	}

	public int save(Member member) {
		int result = 0;
		Connection connection = getConnection();
		
		if(member.getNo() != 0) {
			// update 작업
			result = new MemberDao().updateMember(connection, member);
		} else {
			// insert 작업
			result = new MemberDao().insertMember(connection, member);
		}
		
	
		
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}

	   public boolean isDuplicateId(String userId) {
		      return this.findMemberById(userId) != null;
		   }

	   public Member findMemberById(String userId) {
		      Connection connection = getConnection();
		      
		      Member member = new MemberDao().findMemberById(connection, userId);
		      
		      close(connection);

		      return member;
		   }

	public int updatePassword(int no, String userPwd) {
		int result = 0;
		Connection connection = getConnection();
		
		result = new MemberDao().updateMemberPassword(connection, no, userPwd);
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		close(connection);
		
		return result;
	}

	public int delete(int no) {
		int result = 0;
		Connection connection = getConnection();
		
		result = new MemberDao().updateMemberStatus(connection, no, "N");
		
		if(result > 0) {
			commit(connection);
		} else {
			rollback(connection);
		}
		
		return result;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
