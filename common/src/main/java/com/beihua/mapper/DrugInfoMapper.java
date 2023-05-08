package com.beihua.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrugInfoMapper {

	/**
	 *  条件查询药品信息
	 * @param drugName
	 * @param mnemonicCode
	 * @return
	 */
	List<Map<String, Object>> getDrugInfoByCondition(String drugName, String mnemonicCode);

}
