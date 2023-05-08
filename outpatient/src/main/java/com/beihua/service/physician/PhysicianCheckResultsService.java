package com.neuedu.service.physician;

import java.util.List;
import java.util.Map;

public interface PhysicianCheckResultsService {

	/**
	 *  根据患者id查询已出结果的检查项目
	 * @param registerId
	 * @return
	 */
	List<Map<String, Object>> getCheckRequestByRegisterId(Integer registerId);

	/**
	 *  根据id查询已出结果的检查项目
	 * @param registerId
	 * @return
	 */
	Map<String, Object> getCheckRequestById(Integer id);

}
