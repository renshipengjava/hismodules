package com.neuedu.service.physician.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.mapper.CheckRequestMapper;
import com.neuedu.mapper.MedicalTechnologyMapper;
import com.neuedu.service.physician.PhysicianCheckRequestService;
@Service
public class PhysicianCheckRequestServiceImpl implements PhysicianCheckRequestService {

	@Autowired
	private MedicalTechnologyMapper medicalTechnologyMapper;
	@Autowired
	private CheckRequestMapper checkRequestMapper;
	@Override
	public List<Map<String, Object>> getMedicalTechnology(String techCode, String techName) {
		
		return medicalTechnologyMapper.getMedicalTechnologyByCodeAndNameAndType(techCode, techName, "检查");
	}
	@Override
	public void saveCheckRequest(Map<String, Object> map) {
		//保存信息。插入数据的条数，应该由medicalTechnologyIds数组中元素的数量决定。
		List<Integer> ids = (List<Integer>) map.get("medicalTechnologyIds");
		if(ids != null && ids.size() > 0) {
			for (Integer id : ids) {
				//向map中保存检查项目的id
				map.put("medicalTechnologyId", id);
				//保存数据
				checkRequestMapper.saveCheckRequest(map);
			}
			
		}
	}

}
