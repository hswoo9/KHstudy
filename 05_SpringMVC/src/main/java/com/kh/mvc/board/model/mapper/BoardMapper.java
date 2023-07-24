package com.kh.mvc.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.kh.mvc.board.model.vo.Board;

@Mapper
public interface BoardMapper {
	int selectBoardCount();
	
	List<Board> selectAll(RowBounds bounds);
	
	Board selectBoardByNo(@Param("no") int no);
	
	int updateStatus(@Param("no") int no, @Param("status") String status);
	
	int insertBoard(Board board);
	
	int updateBoard(Board board);
}
