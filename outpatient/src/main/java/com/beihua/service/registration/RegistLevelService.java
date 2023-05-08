package com.neuedu.service.registration;

import java.util.List;
import java.util.Map;

public interface RegistLevelService {

	/**
	 *  查询 挂号级别列表
	 * @return
	 */
	List<Map<String, Object>> getRegistLevelList();
}
