package com.neuedu.service.registration;

import java.util.Map;

import com.neuedu.bean.Result;

public interface RegisterService {

	String getCaseNumber();
	/**
	 *   更加医生编号和午别，查询当天该医生已用的号额
	 * @param empId
	 * @param noon
	 * @return
	 */
	Integer getUsedNumberByEmployeeIdAndNoon(Integer empId, String noon);

	/**
	 * 保存挂号信息
	 * @param map
	 */
	Result saveRegister(Map<String, Object> map);
}
