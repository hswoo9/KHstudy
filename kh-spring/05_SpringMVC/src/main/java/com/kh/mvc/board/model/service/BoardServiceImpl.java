package com.kh.mvc.board.model.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.mvc.board.model.mapper.BoardMapper;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.common.util.PageInfo;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper mapper;

	@Override
	public int getBoardCount() {		
		
		return mapper.selectBoardCount();
	}

	@Override
	public List<Board> getBoardList(PageInfo pageInfo) {
		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);		
		
		return mapper.selectAll(rowBounds);
	}

	@Override
	public Board findBoardByNo(int no) {
		
		return mapper.selectBoardByNo(no);
	}

	@Override
	@Transactional
	public int delete(int no) {
		
		return mapper.updateStatus(no, "N");
	}

	@Override
	@Transactional
	public int save(Board board) {
		int result = 0;
		
		if(board.getNo() > 0) {
			// update
			result = mapper.updateBoard(board);
		} else {
			// insert
			result = mapper.insertBoard(board);
		}
		
		return result;
	}
}
