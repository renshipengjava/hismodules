package com.neuedu.service.physician;

import java.util.List;
import java.util.Map;

public interface WritePrescriptionService {

	/**
	 *  条件查询药品信息
	 * @param drugName
	 * @param mnemonicCode
	 * @return
	 */
	List<Map<String, Object>> getDrugInfo(String drugName, String mnemonicCode);

	/**
	 * 创建处方
	 * @param map
	 */
	void addDrugPrescription(Map<String, Object> map);

}
