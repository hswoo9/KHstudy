package com.kh.mybatis.board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.util.PageInfo;

public class BoardDao {

	public int getBoardCount(SqlSession session) {
		
		return session.selectOne("boardMapper.selectBoardCount");
	}

	public List<Board> findAll(SqlSession session, PageInfo pageInfo) {
		/*
		 * mybatis에서 페이징 처리
		 * 
		 * mybatis에서는 페이징 처리를 위해 RowBounds라는 클래스를 제공해 준다.
		 * RowBounds의 인스턴스 생성할 때 offset과 limit 값을 전달해서 페이징 처리를 구현한다.
		 * (offset 만큼 건너뛰고 limit 만큼 가져온다.)
		 * 
		 * offset = 0, limit = 10
		 *  - 0개를 건너뛰고 10개를 가져온다. (1 ~ 10)
		 *  
		 * offset = 10, limit = 10
		 *  - 10개를 건너뛰고 10개를 가져온다. (11 ~ 20)
		 *  
		 * offset = 20, limit = 10
		 *  - 20개를 건너뛰고 10개를 가져온다. (21 ~ 30)
		 */
		
		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return session.selectList("boardMapper.selectAll", null, rowBounds);
	}

	public int getBoardCount(SqlSession session, String writer, String title, String content) {
		Map<String, String> map = new HashMap<>();
		
		map.put("writer", writer);
		map.put("title", title);
		map.put("content", content);
		
		return session.selectOne("boardMapper.selectBoardCountByKeyWord", map);
	}
	
	public List<Board> findAll(SqlSession session, PageInfo pageInfo, String writer, String title, String content) {
		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		Map<String, String> map = new HashMap<>();
		
		map.put("writer", writer);
		map.put("title", title);
		map.put("content", content);
		
		return session.selectList("boardMapper.selectAllByKeyWord", map, rowBounds);
	}

	public int getBoardCount(SqlSession session, String type, String keyWord) {
		Map<String, String> map = new HashMap<>();
		
		map.put("type", type);
		map.put("keyWord", keyWord);
		
		return session.selectOne("boardMapper.selectBoardCountByKeyWord2", map);
	}
	
	public List<Board> findAll(SqlSession session, PageInfo pageInfo, String type, String keyWord) {
		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		Map<String, String> map = new HashMap<>();
		
		map.put("type", type);
		map.put("keyWord", keyWord);
		
		return session.selectList("boardMapper.selectAllByKeyWord2", map, rowBounds);
	}
	
	public int getBoardCount(SqlSession session, String[] filters) {

		return session.selectOne("boardMapper.selectBoardCountByFilters", filters);
	}

	public List<Board> findAll(SqlSession session, PageInfo pageInfo, String[] filters) {
		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		/*
		 * List나 Array 타입의 데이터를 파라미터로 전달하면 Mapper.xml에서는 list, array라는 이름으로 파라미터에 접근해야 한다.
		 * 
		 * 만약에 Mapper.xml에서 filters라는 이름으로 사용하고 싶으면 Map에 담아서 파라미터로 전달한다.
		 * 
		 */
		Map<String, Object> map = new HashMap<>();
		
		map.put("filters", filters);
		
//		return session.selectList("boardMapper.selectAllByFilters", filters);
//		return session.selectList("boardMapper.selectAllByFilters", Arrays.asList(filters));
		return session.selectList("boardMapper.selectAllByFilters", map, rowBounds);
	}

	public Board findBoardByNo(SqlSession session, int no) {
		
		return session.selectOne("boardMapper.selectBoardByNo", no);
	}

	public int insertBoard(SqlSession session, Board board) {
		
		return session.insert("boardMapper.insertBoard", board);
	}

	public int updateBoard(SqlSession session, Board board) {
		
		return session.update("boardMapper.updateBoard", board);
	}

	public int updateStatus(SqlSession session, int no, String status) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("no", no);
		map.put("status", status);
		
		return session.update("boardMapper.updateStatus", map);
	}
}
