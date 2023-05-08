package com.beihua.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface MedicalTechnologyMapper {

	/**
	 * 根据 医技项目编号、名称、类型查询
	 * @param techCode
	 * @param techName
	 * @param string
	 * @return
	 */
	List<Map<String, Object>> getMedicalTechnologyByCodeAndNameAndType(String techCode, String techName, String techType);

}
