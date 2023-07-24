package com.ismoon.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
@Controller
public class HomeController {
	
//	@GetMapping("/")
//	public Map<String, Object> home() {
//		Map<String , Object> map = new HashMap<>();
//		
//		map.put("test1", null);
//		map.put("test2", "Hi");
//		map.put("test3", 1);
//		map.put("test4", true);
//		
//		return map;
//	}
	
	@GetMapping("/")
	public String home() {
		
		return "home";
	}
	
	
	
	
	
	
	
	
}
