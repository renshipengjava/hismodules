package com.neuedu.service.registration.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.bean.Result;
import com.neuedu.mapper.RegisterMapper;
import com.neuedu.service.registration.RegisterService;
@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterMapper registerMapper;
	@Override
	public String getCaseNumber() {
		Integer max = registerMapper.getMaxCaseNumber();
		return max + 1 + "";
	}
	@Override
	public Integer getUsedNumberByEmployeeIdAndNoon(Integer empId, String noon) {
		return registerMapper.getUsedNumberByEmployeeIdAndNoon(empId, noon);
	}
	@Override
	public Result saveRegister(Map<String, Object> map) {
		//补全属性
		map.put("visit_state", 1);
		boolean isBook = (boolean) map.get("is_book");
		if(isBook) {
			map.put("is_book", "是");
		}else {
			map.put("is_book", "否");
		}
		Integer temp = registerMapper.saveRegister(map);
		if(temp > 0) {
			return Result.build(200, "插入挂号信息成功");
		}else {
			return Result.build(500, "插入挂号信息失败");
		}
	}

}
