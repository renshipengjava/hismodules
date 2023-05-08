package com.neuedu.service.physician;

import java.util.List;
import java.util.Map;

public interface PhysicianCheckRequestService {

	/**
	 *   根据医技项目编号、名称查询检查项目
	 * @param techCode
	 * @param techName
	 * @return
	 */
	List<Map<String, Object>> getMedicalTechnology(String techCode, String techName);

	/**
	 * 保存检查项目
	 * @param map
	 */
	void saveCheckRequest(Map<String, Object> map);

}
