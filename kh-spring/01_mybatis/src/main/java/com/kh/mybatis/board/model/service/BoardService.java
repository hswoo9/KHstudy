package com.kh.mybatis.board.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.util.PageInfo;

import lombok.extern.slf4j.Slf4j;

import static com.kh.mybatis.common.template.SqlSessionTemplate.getSession;

import java.util.List;

@Slf4j
public class BoardService {

	public int getBoardCount() {
		int count = 0;
		SqlSession session = getSession();
		
		count = new BoardDao().getBoardCount(session);
		
		log.info("getBoardCount() 메소드 호출");
		log.debug("getBoardCount() 메소드 호출 - " + count);
		
		session.close();
		
		return count;
	}

	public List<Board> findAll(PageInfo pageInfo) {
		List<Board> list = null;
		SqlSession session = getSession();
		
		list = new BoardDao().findAll(session, pageInfo);
		
		session.close();
		
		return list;
	}

	public int getBoardCount(String writer, String title, String content) {
		int count = 0;
		SqlSession session = getSession();
		
		count = new BoardDao().getBoardCount(session, writer, title, content);
		
		session.close();
		
		return count;
	}
	
	public List<Board> findAll(PageInfo pageInfo, String writer, String title, String content) {
		List<Board> list = null;
		SqlSession session = getSession();
		
		list = new BoardDao().findAll(session, pageInfo, writer, title, content);
		
		session.close();
		
		return list;
	}

	public int getBoardCount(String type, String keyWord) {
		int count = 0;
		SqlSession session = getSession();
		
		count = new BoardDao().getBoardCount(session, type, keyWord);
		
		session.close();
		
		return count;
	}
	
	public List<Board> findAll(PageInfo pageInfo, String type, String keyWord) {
		List<Board> list = null;
		SqlSession session = getSession();
		
		list = new BoardDao().findAll(session, pageInfo, type, keyWord);
		
		session.close();
		
		return list;
	}

	public int getBoardCount(String[] filters) {
		int count = 0;
		SqlSession session = getSession();
		
		count = new BoardDao().getBoardCount(session, filters);
		
		session.close();
		
		return count;
	}
	
	public List<Board> findAll(PageInfo pageInfo, String[] filters) {
		List<Board> list = null;
		SqlSession session = getSession();
		
		list = new BoardDao().findAll(session, pageInfo, filters);
		
		session.close();
		
		return list;
	}

	public Board findBoardByNo(int no) {
		Board board = null;
		SqlSession session = getSession();
		
		board = new BoardDao().findBoardByNo(session, no);
		
		session.close();
		
		return board;
	}

	public int save(Board board) {
		int result = 0;
		SqlSession session = getSession();
		
		if(board.getNo() > 0) {
			// update
			result = new BoardDao().updateBoard(session, board);
		} else {
			// insert
			result = new BoardDao().insertBoard(session, board);
		}
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

	public int delete(int no) {
		int result = 0;
		SqlSession session = getSession();
		
		result = new BoardDao().updateStatus(session, no, "N");
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
}
