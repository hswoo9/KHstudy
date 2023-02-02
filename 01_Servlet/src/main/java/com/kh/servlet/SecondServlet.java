package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿을 등록, URL 매핑
//@WebServlet("/second.do")
@WebServlet(name = "second", urlPatterns = "/second.do")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SecondServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getContextPath());
		System.out.println(request.getServletPath());
		System.out.println(request.getServerName());
		System.out.println(request.getServerPort());
		System.out.println(request.getRemoteAddr());
		
		// 한글이 깨지는 것을 방지하기 위해서 Content-Type 응답 헤더를 설정하는 메소드이다.
		response.setContentType("text/html;charset=utf-8");
		
		// 응답 화면을 출력하기 위한 출력 스트림 생성
		PrintWriter out = response.getWriter();
		
		// 자바 코드로 응답 화면을 작성
		out.write("<html>");
		out.write("<body>");
		out.write("<h1>우리가 만든 첫 번째 서블릿이 반환환 내용</h1>");
		out.write("</body>");
		out.write("</html>");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
