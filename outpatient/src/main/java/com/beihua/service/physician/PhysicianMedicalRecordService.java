package com.neuedu.service.physician;

import java.util.List;
import java.util.Map;

import com.neuedu.bean.Result;

public interface PhysicianMedicalRecordService {

	/**
	 *  按条件查询疾病列表
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getDisease(Map<String, Object> map);

	/**
	 * 保存病历信息
	 * @param map
	 * @return
	 */
	void saveMedicalRecord(Map<String, Object> map);

}
