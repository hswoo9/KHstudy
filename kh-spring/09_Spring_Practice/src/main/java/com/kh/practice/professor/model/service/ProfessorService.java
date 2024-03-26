package com.kh.practice.professor.model.service;

import java.util.List;

import com.kh.practice.professor.model.vo.Professor;

public interface ProfessorService {

	Professor findByNo(String no);

	List<Professor> findAllByDeptNo(String deptNo);

}
