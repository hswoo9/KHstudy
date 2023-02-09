package com.kh.ajax.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jqAjax1.do")
public class jqueryAjaxServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

    public jqueryAjaxServlet() {

    }

    @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String input = request.getParameter("input");
       
       System.out.println("입력 값 : " + input);
       
       response.setContentType("text/html;charset=UTF-8");
       response.getWriter().printf("입력 값 : %s, 길이 :  %d입니다",input,input.length());

   }

    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String name = request.getParameter("name");
    	String age = request.getParameter("age");
    	
    	System.out.println(name + ", " + age);
    	response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(name + ", " + age);
   }

}
