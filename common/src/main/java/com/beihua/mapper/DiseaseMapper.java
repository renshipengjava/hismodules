package com.beihua.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DiseaseMapper {

	/**
	 *  按条件查询疾病列表
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> getDisease(Map<String, Object> map);
}
