package com.kh.practice.subject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.practice.department.model.service.DepartmentService;
import com.kh.practice.department.model.vo.Department;
import com.kh.practice.subject.model.service.SubjectService;
import com.kh.practice.subject.model.vo.Subject;

@Controller
public class SubjectController {
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private SubjectService subjectService; 
	
	@GetMapping("/subject/enroll")
	public ModelAndView enroll(ModelAndView modelAndView) {
		List<Department> departments = departmentService.findAll();
		
		modelAndView.addObject("departments", departments);
		modelAndView.setViewName("subject/enroll");
		
		return modelAndView;
	}
	
	@ResponseBody
	@GetMapping("/subjects/{deptNo}")
	public List<Subject> subjects(@PathVariable String deptNo) {
		
		return subjectService.findAllByDeptNo(deptNo);
	}
	
	@PostMapping("/subject/enroll")
	public ModelAndView enroll(ModelAndView modelAndView, @ModelAttribute Subject subject) {
		int result = 0;
		
		result = subjectService.save(subject);
		
		if(result > 0) {
			modelAndView.addObject("msg", "과목이 정상적으로 등록되었습니다.");
		} else {
			modelAndView.addObject("msg", "과목 등록을 실패하였습니다.");
		}
		
		modelAndView.addObject("location", "/subject/enroll");
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
	@GetMapping("/subject/join")
	public ModelAndView join(ModelAndView modelAndView) {
		
		List<Department> departments = departmentService.findAll();
		
		modelAndView.addObject("departments", departments);
		modelAndView.setViewName("subject/join");
		
		return modelAndView;
	}
	
	@PostMapping("/subject/join")
	public ModelAndView join(ModelAndView modelAndView, @RequestParam String classNo, @RequestParam String professorNo) {
		int result = 0;
		
		result = subjectService.joinProfessor(classNo, professorNo);
		
		if(result > 0) {
			modelAndView.addObject("msg", "담당 교수로 지정되었습니다.");
		} else {
			modelAndView.addObject("msg", "담당 교수 지정을 실패하였습니다.");
		}
		
		modelAndView.addObject("location", "/subject/join");
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
}
