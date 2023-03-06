package com.kh.mvc.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import com.kh.mvc.board.model.service.BoardService;
//import com.kh.mvc.member.model.vo.Member;
import com.kh.mvc.board.model.vo.Board;
import com.kh.mvc.member.model.vo.Member;


@WebServlet(name = "boardDelete", urlPatterns = { "/board/delete" })
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardDeleteServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int result = 0;
		int no = Integer.parseInt(request.getParameter("no"));
		
		System.out.println("게시글 번호 : " + no);

		result = new BoardService().delete(no);
		
		Board board = new Board();
		
//      로그인 체크 & 본인 게시글 여부 확인(직접 적용시켜 보세요.)
     HttpSession session = request.getSession();
     Member loginMember = (session == null) ? null:(Member)session.getAttribute("loginMember");
     
     if (loginMember != null){
     
        board = new BoardService().getBoardByNo(Integer.parseInt(request.getParameter("no")), true);
     
        if (board != null && loginMember.getId().equals(board.getWriterId())) {
     
           result = new BoardService().delete(board.getNo());
           
           if (result > 0) {
              request.setAttribute("msg", "게시글 삭제 성공");
              request.setAttribute("location", "/board/list");
           } else {
              request.setAttribute("msg", "게시글 삭제 실패");
              request.setAttribute("location", "/board/view?no="+board.getNo());
           }
           request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
        } 
     }
        
	}
}
