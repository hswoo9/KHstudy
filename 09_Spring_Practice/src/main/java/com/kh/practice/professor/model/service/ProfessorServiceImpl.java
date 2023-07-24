package com.kh.practice.professor.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.practice.professor.model.mapper.ProfessorMapper;
import com.kh.practice.professor.model.vo.Professor;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorMapper mapper;
	
	@Override
	public Professor findByNo(String no) {
		
		return mapper.selectProfessorByNo(no);
	}

	@Override
	public List<Professor> findAllByDeptNo(String deptNo) {
		
		return mapper.selectAllByDeptNo(deptNo);
	}

}
