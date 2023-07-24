package com.kh.practice.subject.model.service;

import java.util.List;

import com.kh.practice.subject.model.vo.Subject;

public interface SubjectService {

	List<Subject> findAllByDeptNo(String deptNo);

	int save(Subject subject);

	int joinProfessor(String classNo, String professorNo);

}
