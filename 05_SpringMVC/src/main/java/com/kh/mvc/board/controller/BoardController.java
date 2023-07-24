package com.kh.mvc.board.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.common.util.MultipartFileUtil;
import com.kh.mvc.common.util.PageInfo;
import com.kh.mvc.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;
	
	@Autowired
	private ResourceLoader resourceLoader;

//	메소드의 리턴 타입이 void 일 경우 Mapping URL을 유추해서 View를 찾는다.
//	@GetMapping("/list")
//	public void list() {
//	}
	
	@GetMapping("/list")
	public ModelAndView list(ModelAndView modelAndView, @RequestParam(defaultValue = "1") int page) {
		int listCount = service.getBoardCount();
				
		log.info("Page : {}", page);
		log.info("ListCount : {}", listCount);
		
		PageInfo pageInfo = new PageInfo(page, 10, listCount, 10); 	
		List<Board> list = service.getBoardList(pageInfo);
		
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("board/list");
		
		return modelAndView;
	}
	
	@GetMapping("/view")
	public ModelAndView view(ModelAndView modelAndView, @RequestParam int no) {
		Board board = null;
		
		log.info("no : {}", no);
		
		board = service.findBoardByNo(no);
		
		modelAndView.addObject("board", board);
		modelAndView.setViewName("board/view");
		
		return modelAndView;
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(ModelAndView modelAndView, @RequestParam int no,
				@SessionAttribute("loginMember") Member loginMember) {		
		int result = 0;
		Board board = null;
		
		board = service.findBoardByNo(no);
		
		if(board != null && board.getWriterId().equals(loginMember.getId())) {
			result = service.delete(no);
			
			if(result > 0) {
				modelAndView.addObject("msg", "게시글이 정상적으로 삭제되었습니다.");
				modelAndView.addObject("location", "/board/list");
			} else {
				modelAndView.addObject("msg", "게시글이 삭제를 실패하였습니다.");
				modelAndView.addObject("location", "/board/view?no=" + no);
			}
		} else {			
			modelAndView.addObject("msg", "잘못된 접근입니다.");
			modelAndView.addObject("location", "/board/list");		
		}
		
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
	@GetMapping("/write")
	public String write() {
		log.info("게시글 작성 페이지 요청");
		
		return "board/write";
	}
	
	@PostMapping("/write")
	public ModelAndView write(
			ModelAndView modelAndView,
			@ModelAttribute Board board,
			@RequestParam("upfile") MultipartFile upfile,
			@SessionAttribute("loginMember") Member loginMember) {
		
		int result = 0;
		
		// 파일을 업로드하지 않으면 true, 파일을 업로드하면 false
		log.info("upfile.isEmpty() : {}", upfile.isEmpty());
		// 파일을 업로드하지 않으면 "", 파일을 업로드하면 "파일명"
		log.info("upfile.getOriginalFilename() : {}", upfile.getOriginalFilename());
		
		// 1. 파일을 업로드 했는지 확인 후 파일을 저장
		if(upfile != null && !upfile.isEmpty()) {
			String location = null;
			String renamedFileName = null;
			
			try {
				location = resourceLoader.getResource("resources/upload/board").getFile().getPath();
				
				renamedFileName = MultipartFileUtil.save(upfile, location);
				
				System.out.println(renamedFileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(renamedFileName != null) {
				board.setOriginalFileName(upfile.getOriginalFilename());
				board.setRenamedFileName(renamedFileName);
			}
		}
		
		// 2. 작성한 게시글 데이터를 데이터 베이스에 저장 
		board.setWriterNo(loginMember.getNo());
		
		result = service.save(board);
		
		if(result > 0) {
			modelAndView.addObject("msg", "게시글이 정상적으로 등록되었습니다.");
			modelAndView.addObject("location", "/board/view?no=" + board.getNo());
		} else {
			modelAndView.addObject("msg", "게시글 등록을 실패하였습니다.");
			modelAndView.addObject("location", "/board/write");
		}
		
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
	@GetMapping("/fileDown")
	public ResponseEntity<Resource> fileDown(
			@RequestParam String oname, @RequestParam String rname,
			@RequestHeader("user-agent") String userAgent) {
		Resource resource = null;
		String downName = null;
		
		log.info("oname : {}, rname : {}", oname, rname);
		
		try {
			// 1. 클라이언트로 전송할 파일을 가져온다.
			resource = resourceLoader.getResource("resources/upload/board/"+ rname);		
			
			// 2. 브라우저별 인코딩 처리
			boolean isMSIE = userAgent.indexOf("MSIE") != -1 || userAgent.indexOf("Trident") != -1;
			
			if(isMSIE) {
				downName = URLEncoder.encode(oname, "UTF-8").replaceAll("\\+", "%20");
			} else {
				downName = new String(oname.getBytes("UTF-8"), "ISO-8859-1");			
			}
			
			// 3. 응답 메시지 작성 & 클라이언트로 출력(전송)하기
			return ResponseEntity.ok()
								 .header(HttpHeaders.CONTENT_TYPE, "application/octet-stream")
								 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + downName)
								 .body(resource);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/update")
	public ModelAndView update(
			ModelAndView modelAndView, @RequestParam int no,
			@SessionAttribute("loginMember") Member loginMember) {
		Board board = null;
		
		log.info("no : {}", no);
		log.info(loginMember.toString());
		
		board = service.findBoardByNo(no);
		
		if(board != null && board.getWriterId().equals(loginMember.getId())) {
			modelAndView.addObject("board", board);
			modelAndView.setViewName("board/update");			
		} else {
			modelAndView.addObject("msg", "잘못된 접근입니다.");
			modelAndView.addObject("location", "/board/list");
			modelAndView.setViewName("common/msg");						
		}
		
		return modelAndView;
	}
	
	@PostMapping("/update")
	public ModelAndView update(
			ModelAndView modelAndView,
			@RequestParam("upfile") MultipartFile upfile,
			@RequestParam int no, @RequestParam String title, @RequestParam String content,
			@SessionAttribute("loginMember") Member loginMember) {
		int result = 0;
		Board board = null;
		
		log.info("{}, {}, {}", new Object[] {no, title, content});
		
		board = service.findBoardByNo(no);
		
		if(board != null && board.getWriterId().equals(loginMember.getId())) {
			if(upfile != null && !upfile.isEmpty()) {
				String location = null;
				String renamedFileName = null;
				
				try {
					location = resourceLoader.getResource("resources/upload/board").getFile().getPath();
					
					// 이전에 업로드된 첨부파일 삭제
					if(board.getRenamedFileName() != null) {
						MultipartFileUtil.delete(location + "/" + board.getRenamedFileName());
					}
					
					renamedFileName = MultipartFileUtil.save(upfile, location);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				if(renamedFileName != null) {
					board.setOriginalFileName(upfile.getOriginalFilename());
					board.setRenamedFileName(renamedFileName);
				}
			}
			
			board.setTitle(title);
			board.setContent(content);
			
			result = service.save(board);
			
			if(result > 0) {
				modelAndView.addObject("msg", "게시글이 정상적으로 수정되었습니다.");
				modelAndView.addObject("location", "/board/view?no=" + board.getNo());				
			} else {
				modelAndView.addObject("msg", "게시글 수정을 실패하였습니다.");
				modelAndView.addObject("location", "/board/update?no=" + board.getNo());								
			}
		} else {
			modelAndView.addObject("msg", "잘못된 접근입니다.");
			modelAndView.addObject("location", "/board/list");
		}
		
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
