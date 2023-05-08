package com.neuedu.service.registration;

import java.util.List;
import java.util.Map;

public interface SettleCategoryService {

	/**
	 *  查询所有结算类别
	 * @return
	 */
	List<Map<String, Object>> getSettleCategoryList();
}
