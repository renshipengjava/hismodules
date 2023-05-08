package com.neuedu.service.physician.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.mapper.RegisterMapper;
import com.neuedu.service.physician.PhysicianHistorySerivice;
@Service
public class PhysicianHistorySeriviceImpl implements PhysicianHistorySerivice {
	@Autowired
	private RegisterMapper registerMapper;

	@Override
	public PageInfo  getCheckedPatient(Integer employee_id,String case_number, String real_name, Integer nowPageNumber,
			Integer pageSize) {
		PageHelper.startPage(nowPageNumber, pageSize);
		List<Map<String, Object>> list = registerMapper.getPatientByState(employee_id,case_number,real_name);
		SimpleDateFormat smf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		for(Map<String,Object> map : list) {
			Object t = map.get("visit_date");
			if(t != null) {
				Timestamp date = (Timestamp)t;
				String s = smf.format(date);
				map.put("visit_date", s);
			}
			
			Object state = map.get("visit_state");
			if(state != null) {
				Integer i = (Integer)state;
				if(i == 1) {
					map.put("visit_state", "已挂号");
				}else if(i == 2) {
					map.put("visit_state", "医生接诊");
				}else if(i == 3) {
					map.put("visit_state", "看诊结束");
				}
			}
		}
		
		return new PageInfo(list);
	}

}
