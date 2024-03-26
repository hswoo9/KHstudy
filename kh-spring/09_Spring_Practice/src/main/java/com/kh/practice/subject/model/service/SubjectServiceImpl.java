package com.kh.practice.subject.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.practice.subject.model.mapper.SubjectMapper;
import com.kh.practice.subject.model.vo.Subject;

@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectMapper mapper;

	@Override
	public List<Subject> findAllByDeptNo(String deptNo) {
		
		return mapper.selectAllByDeptNo(deptNo);
	}

	@Override
	@Transactional
	public int save(Subject subject) {
		
		return mapper.insertSubject(subject);
	}

	@Override
	public int joinProfessor(String classNo, String professorNo) {
		
		return mapper.insertClassAndProfessor(classNo, professorNo);
	}

}
