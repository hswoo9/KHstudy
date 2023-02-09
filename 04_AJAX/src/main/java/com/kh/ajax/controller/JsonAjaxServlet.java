package com.kh.ajax.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.ajax.model.vo.User;

@WebServlet("/jsonAjax.do")
public class JsonAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JsonAjaxServlet() {
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 사용자 정보가 저장되어 있는 List 객체 생성
    	List<User> list = new ArrayList<>();
    	
    	list.add(new User(1, "한상우", 29, "남자"));
    	list.add(new User(2, "김철수", 16, "남자"));
    	list.add(new User(3, "김영희", 16, "여자"));
    	list.add(new User(4, "홍길동", 20, "남자"));
    	list.add(new User(5, "영심이", 15, "여자"));
    	list.add(new User(6, "왕경태", 15, "남자"));
    	
    	int userNo = Integer.parseInt(request.getParameter("userNo"));
    	
    	User findUser = list.stream()
				    		.filter(user -> user.getNo() == userNo)
				    		.findFirst()
				    		.orElse(null); 
    	
    	System.out.println(findUser);
    	System.out.println(new Gson().toJson(findUser));
//    	System.out.println(new Gson().fromJson("{\"no\":4,\"name\":\"홍길동\",\"age\":20,\"gender\":\"남자\"}", User.class));
    	
    	response.setContentType("application/json;charset=UTF-8");
    	
//		response.getWriter().write("{\"no\": 1, \"name\": \"한상우\"}");
//		response.getWriter().printf("{\"no\": %d, \"name\": \"%s\"}", findUser.getNo(), findUser.getName());
    	new Gson().toJson(findUser, response.getWriter());
	}


    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 사용자 정보가 저장되어 있는 List 객체 생성
    	List<User> list = new ArrayList<>();
    	
    	list.add(new User(1, "한상우", 29, "남자"));
    	list.add(new User(2, "김철수", 16, "남자"));
    	list.add(new User(3, "김영희", 16, "여자"));
    	list.add(new User(4, "홍길동", 20, "남자"));
    	list.add(new User(5, "영심이", 15, "여자"));
    	list.add(new User(6, "왕경태", 15, "남자"));
    	
    	String gender = request.getParameter("gender");
    	
    	List<User> findUsers = list.stream()
				    			   .filter(user -> user.getGender().equals(gender))
				    			   .collect(Collectors.toList());
    	
    	System.out.println(findUsers);
    	System.out.println(new Gson().toJson(findUsers));
    	
    	response.setContentType("application/json;charset=UTF-8");
    	new Gson().toJson(findUsers, response.getWriter());
	}

}
