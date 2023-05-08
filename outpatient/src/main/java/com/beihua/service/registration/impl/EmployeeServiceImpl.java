package com.neuedu.service.registration.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.mapper.EmployeeMapper;
import com.neuedu.service.registration.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	@Override
	public List<Map<String, Object>> getEmployeeList(Integer deptId, Integer levelId) {
		//根据部门id和号别id查询出所有满足条件的医生
		List<Map<String, Object>> list = employeeMapper.getEmpByDeptIdAndLevelId(deptId, levelId);
		//根据日期及午别进行过滤，获得坐班医生
		List<Map<String, Object>> newList = new ArrayList<>();
		
		//排班规则   00 10 00 10 00 10 00  根据星期几、午别进行判断，对应位置的数字是否为1，为1就是当班。添加到newList
		Calendar cal = Calendar.getInstance();
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int noon = cal.get(Calendar.AM_PM);
		int index = (week - 1) * 2 + noon;
		
		for(Map<String, Object> map : list) {
			String weekRule = (String) map.get("week_rule");
			char c = weekRule.charAt(index);
			if(c == '1') {
				newList.add(map);
			}
		}
		
		return newList;
	}

}
