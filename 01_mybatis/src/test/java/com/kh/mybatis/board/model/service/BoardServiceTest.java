package com.kh.mybatis.board.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.util.PageInfo;

@DisplayName("BoardService 테스트")
@TestMethodOrder(OrderAnnotation.class)
class BoardServiceTest {
	private BoardService service;
	
	@BeforeEach
	void setUp() {
		service = new BoardService();
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
	@DisplayName("게시글 수 조회 테스트")
	void getBoardCountTest() {
		int count = 0;
		
		count = service.getBoardCount();
		
//		System.out.println(count);
		
		assertThat(count).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	@DisplayName("게시글 목록 조회 테스트")
	void findAllTest() {
		List<Board> list = null;
		PageInfo pageInfo = null;
		int listCount = 0;		
		
		listCount = service.getBoardCount();
		pageInfo = new PageInfo(2, 10, listCount, 10);
		list = service.findAll(pageInfo);
		
		assertThat(list).isNotNull().isNotEmpty();
		assertThat(list.size()).isEqualTo(10);
	}
	
	@ParameterizedTest
	@CsvSource(
			value = {
				"null, null, null",
				"is, null, null",
				"null, 50, null",
				"null, null, 10"
			},
			nullValues = "null"
		)
	@Order(3)
	@DisplayName("게시글 수 조회(검색 기능 적용) 테스트")
	void getBoardCountTest(String writer, String title, String content) {
		int count = 0;
		
		count = service.getBoardCount(writer, title, content);
		
		assertThat(count).isGreaterThan(0);
	}
	
	@ParameterizedTest
	@CsvSource(
		value = {
			"null, null, null",
			"is, null, null",
			"null, 50, null",
			"null, null, 10"
		},
		nullValues = "null"
	)
	@Order(4)
	@DisplayName("게시글 목록 조회(검색 기능 적용) 테스트")
	void findAllTest(String writer, String title, String content) {
		List<Board> list = null;
		PageInfo pageInfo = null;
		int listCount = 0;
		
		listCount = service.getBoardCount(writer, title, content);
		pageInfo = new PageInfo(1, 10, listCount, 10);
		list = service.findAll(pageInfo, writer, title, content);
		
//		System.out.println(list);
//		System.out.println(list.size());
				
		assertThat(list).isNotNull().isNotEmpty();
	}
	
	@ParameterizedTest
	@CsvSource(
		value = {
			"null, null",
			"writer, is",
			"title, 50",
			"content, 10"
		}
	)
	@Order(5)
	@DisplayName("게시글 수 조회(검색 기능 적용 2) 테스트")
	void getBoardCountTest(String type, String keyWord) {
		int count = 0;
		
		count = service.getBoardCount(type, keyWord);
				
		assertThat(count).isGreaterThan(0);
	}
	
	
	@ParameterizedTest
	@CsvSource(
		value = {
			"null, null",
			"writer, is",
			"title, 50",
			"content, 10"
		}
	)
	@Order(6)
	@DisplayName("게시글 목록 조회(검색 기능 적용 2) 테스트")
	void findAllTest(String type, String keyWord) {
		List<Board> list = null;
		PageInfo pageInfo = null;
		int listCount = 0;
		
		listCount = service.getBoardCount(type, keyWord);
		pageInfo = new PageInfo(1, 10, listCount, 10);
		list = service.findAll(pageInfo, type, keyWord);
				
		assertThat(list).isNotNull().isNotEmpty();
	}
	
	@ParameterizedTest
	@MethodSource("filterProvider")
	@Order(7)
	@DisplayName("게시글 수 조회(필터 기능 적용) 테스트")
	void getBoardCountTest(String[] filters) {
		int count = 0;
		
		count = service.getBoardCount(filters);
		
		assertThat(count).isGreaterThan(0);
	}
	
	@ParameterizedTest
	@MethodSource("filterProvider")
	@Order(8)
	@DisplayName("게시글 목록 조회(필터 기능 적용) 테스트")
	void findAllTest(String[] filters) {
		List<Board> list = null;
		PageInfo pageInfo = null;
		int listCount = 0;
		
		listCount = service.getBoardCount(filters);
		pageInfo = new PageInfo(2, 10, listCount, 10);
		list = service.findAll(pageInfo, filters);
				
		assertThat(list).isNotNull().isNotEmpty();
	}
	
	@Test
	@Order(9)
	@DisplayName("게시글 상세 조회(댓글 포함) 테스트")
	void findBoardByNoTest() {
		Board board = null;
		
		board = service.findBoardByNo(122);
		
		assertThat(board).isNotNull();
		assertThat(board.getNo()).isEqualTo(122);
		assertThat(board.getReplies().size()).isGreaterThan(0);
	}
	
	@Test
	@Order(10)
	@DisplayName("게시글 등록 테스트")
	public void insertBoard() {
		int result = 0;
		Board board = new Board();
		
		board.setWriterNo(9);
		board.setTitle("mybatis 게시글");
		board.setContent("mybatis로 게시글을 작성하였습니다.");
		board.setOriginalFileName("test.txt");
		board.setRenamedFileName("test.txt");
		
		result = service.save(board);
				
		assertThat(result).isGreaterThan(0);
		assertThat(board.getNo()).isGreaterThan(0);
		assertThat(service.findBoardByNo(board.getNo())).isNotNull();
	}
	
	@ParameterizedTest
	@MethodSource("boardProvider")
	@Order(11)	
	@DisplayName("게시글 수정 테스트")
	void updateBoardTest(Board board) {
		int result = 0;
		
		board.setTitle("mybatis 게시글 수정");
		board.setContent("mybatis 게시글을 수정하였습니다.");
		board.setOriginalFileName(null);
		board.setRenamedFileName(null);
		
		result = service.save(board);
		
		assertThat(result).isGreaterThan(0);
		assertThat(service.findBoardByNo(board.getNo()))
					.isNotNull()
					.extracting("title")
					.isEqualTo("mybatis 게시글 수정");
	}
	
	@ParameterizedTest
	@MethodSource("boardProvider")
	@Order(12)
	@DisplayName("게시글 삭제 테스트")
	void deleteBoardTest(Board board) {
		int result = 0;
	
		result = service.delete(board.getNo());
		
		assertThat(result).isEqualTo(1);
		assertThat(service.findBoardByNo(board.getNo())).isNull();
	}	
	
	public static Stream<Arguments> filterProvider() {
		return Stream.of(
			Arguments.arguments((Object) new String[] {"B2", "B3"}),
			Arguments.arguments((Object) new String[] {"B3"})
		);
	}
	
	public static Stream<Arguments> boardProvider() {
		BoardService service = new BoardService();
		List<Board> list = service.findAll(new PageInfo(1, 10, service.getBoardCount(), 10));
		
		return Stream.of(Arguments.arguments(list.get(0)));
	}
}
