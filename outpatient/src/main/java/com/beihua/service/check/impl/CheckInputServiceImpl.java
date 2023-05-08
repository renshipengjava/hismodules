package com.neuedu.service.check.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.mapper.CheckRequestMapper;
import com.neuedu.service.check.CheckInputService;
@Service
public class CheckInputServiceImpl implements CheckInputService {
	@Autowired
	private CheckRequestMapper checkRequestMapper;
	@Override
	public PageInfo getFinishCheck(String case_number, String real_name, Integer nowPageNumber, Integer pageSize) {
		PageHelper.startPage(nowPageNumber, pageSize);
		//完成检查患者信息
		List<Map<String,Object>> list = checkRequestMapper.getFinishCheck(case_number,real_name);
		
		return new PageInfo(list);
	}
	@Override
	public List<Map<String, Object>> getFinishCheckByRegistid(Integer id) {
		List<Map<String,Object>> list = checkRequestMapper.getFinishCheckByRegistid(id);
		SimpleDateFormat smf = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		for(Map<String,Object> m : list) {
			Object ct = m.get("check_time");
			if(ct!=null) {
				Timestamp date = (Timestamp)ct;
				String s = smf.format(date);
				m.put("check_time", s);
			}
		}
		return list;
	}
	@Override
	public void updateCheckInput(String id, String employee_id, String check_result) {
		checkRequestMapper.updateCheckInput(id,employee_id,check_result);
	}

}
