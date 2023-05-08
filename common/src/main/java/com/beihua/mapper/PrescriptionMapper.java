package com.beihua.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface PrescriptionMapper {

	/**
	 *  保存处方信息
	 * @param map
	 */
	void savePrescription(Map<String, Object> map);

	/**
	 *  根据病历号查询'已开立'状态的处方信息
	 * @param registerId
	 * @param string
	 * @return
	 */
	List<Map<String, Object>> getPrescriptionByRegisterIdAndState(Integer registerId, String state);

	/**
	 * 修改处方状态
	 * @param integer
	 * @param string
	 */
	void updateItemState(Integer id, String state);

	/**
	 * 根据患者的id查询已缴费的药品信息
	 * @param registerId
	 * @return
	 */
	List<Map<String, Object>> getDrugInfoByRegisterIdAndState(Integer registerId);

}
