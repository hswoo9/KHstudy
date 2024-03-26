package com.kh.security;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.security.member.model.vo.Member;

@Controller
public class HomeController {	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	// 2. Authentication를 매개변수로 얻어오는 방법
//	public String home(Locale locale, Model model, Authentication authentication) {
	// 3. @AuthenticationPrincipal 어노테이션을 사용하는 방법
	public String home(Locale locale, Model model, @AuthenticationPrincipal Member loginMember) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		// 1. SecurityContextHolder를 사용하는 방법
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
//		Member loginMember = (Member) authentication.getPrincipal();
		
		System.out.println(loginMember);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
}
