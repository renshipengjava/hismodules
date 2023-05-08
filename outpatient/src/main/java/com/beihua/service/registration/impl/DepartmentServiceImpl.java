package com.beihua.service.registration.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beihua.mapper.DepartmentMapper;
import com.beihua.service.registration.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	@Override
	public List<Map<String, Object>> getDeptList() {
		return departmentMapper.getDeptList("门诊");
	}

}
