package com.neuedu.service.physician.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.mapper.CheckRequestMapper;
import com.neuedu.service.physician.PhysicianCheckResultsService;

@Service
public class PhysicianCheckResultsServiceImpl implements PhysicianCheckResultsService {

	@Autowired
	private CheckRequestMapper checkRequestMapper;
	@Override
	public List<Map<String, Object>> getCheckRequestByRegisterId(Integer registerId) {
		return checkRequestMapper.getCheckByRegisterIdAndState(registerId, "已出结果");
	}
	@Override
	public Map<String, Object> getCheckRequestById(Integer id) {
		return checkRequestMapper.getCheckRequestById(id);
	}

}
