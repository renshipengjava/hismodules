package com.neuedu.service.physician.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.mapper.RegisterMapper;
import com.neuedu.service.physician.PhysicianPatientService;
@Service
public class PhysicianPatientServiceImpl implements PhysicianPatientService {

	@Autowired
	private RegisterMapper registerMapper;
	@Override
	public Integer getFinishPatientCount(Integer employeeId) {
		
		return registerMapper.getCountByEmployeeIdAndState(employeeId, 3);
	}

	@Override
	public Integer getWaitPatientCount(Integer employeeId) {
		
		return registerMapper.getCountByEmployeeIdAndState(employeeId, 1);
	}

	@Override
	public PageInfo getWaitPatientList(Map<String, Object> map) {
		int pageNum = (int) map.get("pageNum");
		int pageSize = (int) map.get("pageSize");
		int employeeId = (int) map.get("employeeId");
		PageHelper.startPage(pageNum, pageSize);
		List<Map<String, Object>> list = registerMapper.getWaitPatientList(map);
		//获得分页信息
		PageInfo info = new PageInfo(list);
		return info;
	}

	@Override
	public void updateRegisterState(Map<String, Object> map) {
		Integer id = (Integer) map.get("id");
		registerMapper.updateRegisterState(id);
		
	}
	
	

}
