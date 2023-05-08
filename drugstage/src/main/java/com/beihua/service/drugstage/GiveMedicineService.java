package com.beihua.service.drugstage;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

public interface GiveMedicineService {

	PageInfo getRegister(Integer caseNumber, String realName, Integer nowPageNumber, Integer pageSize);

	/**
	 * 根据患者的id查询已缴费的药品信息
	 * @param registerId
	 * @return
	 */
	List<Map<String, Object>> getDrugInfoByRegisterIdAndState(Integer registerId);

	/**
	 *  发药
	 * @param map
	 * @return
	 */
	void giveMedicine(Map<String, Object> map);

}
