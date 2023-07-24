package com.kh.security.common.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.kh.security.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
				
		Member loginMember = (Member) authentication.getPrincipal();
		
		log.info("ROLE : {}", loginMember.getRole());
		
		if(loginMember.getRole().equals("ROLE_ADMIN")) {			
			response.sendRedirect(request.getContextPath() + "/admin/view");
		} else {			
			response.sendRedirect(request.getContextPath() + "/");
		}
	}
}
