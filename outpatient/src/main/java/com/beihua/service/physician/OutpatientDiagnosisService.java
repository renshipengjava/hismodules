package com.neuedu.service.physician;

import java.util.Map;

public interface OutpatientDiagnosisService {

	/**
	 * 患者确诊，更新病历
	 * @param map
	 */
	void outpatientDiagnosis(Map<String, Object> map);

}
