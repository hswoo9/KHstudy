package com.kh.mvc.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.member.model.service.MemberService;
import com.kh.mvc.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
// Model 객체에 loginMember라는 키값으로 Attribute가 추가되면 해당 Attribute를 세션 스코프에 추가하는 어노테이션이다.
@SessionAttributes("loginMember")
public class MemberController {
	
	// 컨트롤러가 처리할 요청을 정의한다.(URL, Method 등)
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	@GetMapping("/login")
//	@PostMapping("/login")
//	public String login() {
//		log.info("login() - 호출");
//		
//		return "home";
//	}
	
//	요청 시 사용자의 파라미터를 전송받는 방법
//	1. HttpServletRequest 통해서 전송받기
//	@PostMapping("/login")
//	public String login(HttpServletRequest request) {
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		
//		log.info("login() - 호출 : {} {}", id, password);
//		
//		return "home";
//	}
	
//	2.1. @RequestParam 어노테이션을 통해서 전송받는 방법
//	  - 스프링에서는 조금 더 간편하게 파라미터를 받아올 수 있는 방법을 제공한다.
//	  - 단, 매개변수의 이름과 파라미터의 name 속성의 값이 동일하면 @RequestParam 어노테이션을 생략할 수 있다.
//	@RequestMapping(value = "/login", method = {RequestMethod.POST})
//	public String login(@RequestParam("id") String id, @RequestParam("password") String password) {
//	public String login(@RequestParam String id, @RequestParam String password) {
//	public String login(String id, String password) {
//		
//		log.info("login() - 호출 : {} {}", id, password);
//		
//		return "home";
//	}
	
//	2.2. @RequestParam 어노테이션에 defaultValue 설정
//	  - defaultValue 속성을 사용하면 파라미터 name 속성에 값이 없을 경우 기본값을 지정할 수 있다.
//	@PostMapping("/login")
//	public String login(@RequestParam("id") String id, 
//						@RequestParam(value = "password", defaultValue = "1111") String password) {
//		
//		log.info("login() - 호출 : {} {}", id, password);
//		
//		return "home";
//	}
	
//	2.3. @RequestParam 어노테이션에 실제 존재하지 않는 파라미터를 받으려고 할 때
//	  - 실제 존재하지 않는 파라미터를 받으려고 하면 에러가 발생한다. (required = true)
//	  - @RequestParam(required = false)로 지정하면 에러가 아닌 null 값을 넘겨준다.
//	  - 단, defaultValue를 설정하면 에러없이 defaultValue에 지정된 값을 받아올 수 있다.
//	@PostMapping("/login")
//	public String login(@RequestParam String id, 
//						@RequestParam String password,
////						@RequestParam(required = false) String address) {
//						@RequestParam(defaultValue = "서울특별시") String address) {
//		
//		log.info("login() - 호출 : {} {} {}", new Object[] {id, password, address});
//		
//		return "home";
//	}
	
//	3. @ModelAttribute 어노테이션을 통해서 전송받는 방법
//	  - 요청 파라미터가 많은 경우 객체 타입으로 파라미터를 넘겨받는 방법이다.
//	  - 단, 기본 생성자와 Setter 메소드가 존재해야 한다.
//	  - @ModelAttribute 어노테이션을 생략해도 객체로 매핑된다.
//	@PostMapping("/login")
//	public String login(@ModelAttribute Member member) {
//	public String login(Member member) {
//		
//		System.out.println(member);
//		
//		return "home";
//	}
	
//	4. @PathVariable 어노테이션
//	  - URL 패스상에 있는 특정 값을 가져오기 위해 사용하는 방법이다.
//	  - REST API를 사용할 때, 요청 URL 상에서 필요한 값을 가져오는 경우에 주로 사용한다.
//	@GetMapping("/member/{id}")
////	public String findMember(@PathVariable("id") int id) {
//	public String findMember(@PathVariable int id) {
//		
//		log.info("findMember() - 호출 : {}", id);
//		
//		return "home";
//	}
	
	@Autowired
	private MemberService service;
	
	/*
	 * 로그인 처리
	 * 1. HttpSession과 Model 객체 사용
	 *   - Model이라는 객체는 컨트롤러에서 데이터를 뷰로 전달하고자 할 때 사용하는 객체이다.
	 *   - 전달하고자 하는 데이터를 맵 형식(key, value)으로 담을 수 있다.
	 *   - Model 객체의 Scope는 request이다.
	 */
//	@PostMapping("/login")
//	public String login(HttpSession session, Model model,
//				@RequestParam String id, @RequestParam String password) {
//		
//		log.info("{}, {}", id, password);
//		
//		Member loginMember = service.login(id, password);
//		
//		if(loginMember != null) {
//			session.setAttribute("loginMember", loginMember);
//			
//			return "redirect:/";
//		} else {
//			model.addAttribute("msg", "아이디나 패스워드가 일치하지 않습니다.");
//			model.addAttribute("location", "/");
//			
//			return "common/msg";
//		}
//	}
	
	/*
	 * 로그아웃 처리
	 * 1. HttpSession 객체 사용
	 */
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		
//		session.invalidate();
//		
//		return "redirect:/";
//	}
	
	
	/*
	 * 로그인 처리
	 * 2. @SessionAttributes과 ModelAndView 객체를 사용
	 *   1) @SessionAttributes("키값")
	 *     - Model 객체에서 "키값"에 해당하는 Attribute를 Session 영역까지 범위를 확장시키는 어노테이션이다.
	 *     
	 *   2) ModelAndView
	 *     - 컨트롤러에서 뷰로 전달할 데이터와 포워딩하려는 뷰에 정보를 담는 객체이다.
	 */
	@PostMapping("/login")
	public ModelAndView login(ModelAndView modelAndView,
				@RequestParam String id, @RequestParam String password) {
		
		log.info("{}, {}", id, password);
		
		Member loginMember = service.login(id, password);
		
		if(loginMember != null) {
			modelAndView.addObject("loginMember", loginMember);
			modelAndView.setViewName("redirect:/");
		} else {
			modelAndView.addObject("msg", "아이디나 패스워드가 일치하지 않습니다.");
			modelAndView.addObject("location", "/");
			modelAndView.setViewName("common/msg");
		}
		
		return modelAndView;
	}
	
	/*
	 * 로그아웃 처리
	 * 2. SessionStatus 객체 사용
	 */
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		log.info("status : {}", status.isComplete());
		
		// 세션 스코프로 확장된 Attribute를 지워준다.
		status.setComplete();
		
		log.info("status : {}", status.isComplete());
		
		return "redirect:/";
	}
	
	@GetMapping("/member/enroll")
	public String enroll() {
		log.info("회원 가입 페이지 요청");
		
		return "member/enroll";
	}
	
	@PostMapping("/member/enroll")
	public ModelAndView enroll(ModelAndView modelAndView, @ModelAttribute Member member) {
		
		log.info(member.toString());
		
		int result = 0;
		
		result = service.save(member);
		
		if(result > 0) {
			modelAndView.addObject("msg", "회원가입이 정상적으로 완료되었습니다.");
			modelAndView.addObject("location", "/");
		} else {
			modelAndView.addObject("msg", "회원가입을 실패하였습니다.");
			modelAndView.addObject("location", "/member/enroll");
		}
		
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
	/*
	 * @ResponseBody
	 *   - 일반적으로 컨트롤러 메소드의 반환형이 String일 경우 뷰의 이름을 반환한다.
	 *   - @ResponseBody 붙은 메소드의 반환형이 String일 경우 해당 요청을 보낸 클라이언트에 전달할 데이터를 의미한다. 
	 * 
	 * jackson 라이브러리
	 *   - 자바 객체를 JSON 문자열 형태의 데이터로 변환하는 라이브러리이다.
	 *   - 스프링에서 jackson 라이브러리를 추가하고 @ResponseBody을 사용하면 리턴되는 객체를 자동으로 
	 *     JSON 문자열로 변경해서 반환한다.
	 *     
	 * @RestController
	 *   - 해당 어노테이션이 붙은 컨트롤러의 모든 메소드에서 데이터를 반환하는 경우에 사용한다.
	 *   - @Controller, @ResponseBody를 합쳐놓은 역할을 수행한다.
	 */
	@GetMapping("/jsonTest")
	@ResponseBody
	public Object jsonTest() {
		Map<String, Object> map = new HashMap<>();
		
		map.put("test1", null);
		map.put("test2", "hi");
		map.put("test3", 10);
		map.put("test4", false);
		
//		return new Member("ismoon", "1234", "문인수");
		
		return map;
	}
	
//	@PostMapping("/member/idCheck")
//	@ResponseBody
//	public Map<String, Boolean> idCheck(@RequestParam("userId") String id) {
//		Map<String, Boolean> map = new HashMap<>();
//		
//		map.put("duplicate", service.isDuplicateId(id));
//		
//		return map;
//	}
	
	/*
	 * @ResponseBody을 사용하지 않고 JSON 문자열을 반환하는 방법
	 * 
	 * HttpEntity
	 *   - SpringFramework에서 제공하는 클래스로 HTTP 요청 또는 응답에 해당하는 HTTP Header와 HTTP Body를 포함하는 클래스이다.
	 * 
	 * ResponseEntity
	 *   - HttpEntity를 상속하는 클래스로 HTTP 응답 데이터를 포함하는 클래스이다.
	 *   - 개발자가 직접 HTTP Body, Header, Status Code를 세팅하여 반환할 수 있다.
	 */	
	@PostMapping("/member/idCheck")	
	public ResponseEntity<Map<String, Boolean>> idCheck(@RequestParam("userId") String id) {
		Map<String, Boolean> map = new HashMap<>();
		
		map.put("duplicate", service.isDuplicateId(id));
		
		return ResponseEntity.ok()
							 .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
							 .body(map);
//		return new ResponseEntity<Map<String,Boolean>>(map, HttpStatus.OK);
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@GetMapping("/member/myPage")
	public String myPage() {
		log.info("회원 정보 수정 페이지 요청");
		
		return "member/myPage";
	}
	
	@PostMapping("/member/update")
	public ModelAndView update(
				ModelAndView modelAndView,
				@SessionAttribute("loginMember") Member loginMember,
				@ModelAttribute Member member) {
		
		int result = 0;
		
		member.setNo(loginMember.getNo());
		
		log.info(member.toString());
		
		result = service.save(member);
		
		if(result > 0) {
			modelAndView.addObject("loginMember", service.findMemberById(loginMember.getId()));
			modelAndView.addObject("msg", "회원 정보 수정을 완료했습니다.");
		} else {
			modelAndView.addObject("msg", "회원 정보 수정을 실패했습니다.");			
		}
		
		modelAndView.addObject("location", "/member/myPage");
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
	@GetMapping("/member/delete")
	public ModelAndView delete(
				ModelAndView modelAndView, 
				@SessionAttribute("loginMember") Member loginMember) {
	
		int result = 0;
		
		result = service.delete(loginMember.getNo());
		
		if(result > 0) {
			modelAndView.addObject("msg", "정상적으로 탈퇴되었습니다.");
			modelAndView.addObject("location", "/logout");
		} else {
			modelAndView.addObject("msg", "회원 탈퇴를 실패하였습니다.");
			modelAndView.addObject("location", "/member/myPage");
		}
		
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
}
