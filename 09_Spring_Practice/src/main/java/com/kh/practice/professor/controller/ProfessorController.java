package com.kh.practice.professor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.practice.professor.model.service.ProfessorService;
import com.kh.practice.professor.model.vo.Professor;

@Controller
public class ProfessorController {
	@Autowired
	private ProfessorService service;
	
	@ResponseBody
	@GetMapping("/professor")
	public Professor professor(@RequestParam String professorNo) {
		
		Professor professor = service.findByNo(professorNo);
		
		return professor;
	}
	
	@GetMapping("/professors/{deptNo}")
	public ResponseEntity<List<Professor>> professors(@PathVariable String deptNo) {
		List<Professor> professors = null;
		
		professors = service.findAllByDeptNo(deptNo);
		
		return ResponseEntity.ok(professors);
	}
}
