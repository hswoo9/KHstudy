package com.kh.practice.department.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.practice.department.model.mapper.DepartmentMapper;
import com.kh.practice.department.model.vo.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper mapper;
	
	@Override
	public List<Department> findAll() {
		
		return mapper.selectAll();
	}

}
