package com.beihua.service.registration;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

	/**
	 * 查询所有部门信息
	 * @return
	 */
	List<Map<String, Object>> getDeptList();
}
