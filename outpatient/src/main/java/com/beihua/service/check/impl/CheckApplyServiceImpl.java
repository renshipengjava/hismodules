package com.neuedu.service.check.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.mapper.CheckRequestMapper;
import com.neuedu.service.check.CheckApplyService;
@Service
public class CheckApplyServiceImpl implements CheckApplyService {
	@Autowired
	private CheckRequestMapper checkRequestMapper;

	@Override
	public Integer getFinishCheckCount() {
		return checkRequestMapper.getCheckCountByState("执行完成");
	}

	@Override
	public Integer getWaitCheckCount() {
		return checkRequestMapper.getCheckCountByState("已缴费");
	}

	@Override
	public PageInfo getWaitCheck(String case_number, String real_name, Integer nowPageNumber, Integer pageSize) {
		PageHelper.startPage(nowPageNumber, pageSize);
		//患者信息
		List<Map<String,Object>> list = checkRequestMapper.getWaitCheck(case_number,real_name);
		PageInfo info = new PageInfo(list);
		return info;
	}

}
