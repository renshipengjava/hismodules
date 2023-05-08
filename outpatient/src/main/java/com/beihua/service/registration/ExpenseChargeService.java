package com.neuedu.service.registration;

import java.util.List;
import java.util.Map;

import com.neuedu.bean.Result;

public interface ExpenseChargeService {

	/**
	 *   根据病历号、患者姓名查询患者信息，及需要缴费项目
	 * @param caseNumber
	 * @param realName
	 * @return
	 */
	Map<String, Object> getPatientAndItem(String caseNumber, String realName);

	/**
	 * 更新收费项目状态为"已缴费"
	 * @param list
	 * @return
	 */
	void updateItemState(List<Map<String, Object>> list);

}
