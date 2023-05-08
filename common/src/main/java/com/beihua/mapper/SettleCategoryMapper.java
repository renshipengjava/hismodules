package com.beihua.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SettleCategoryMapper {

	/**
	 *  查询所有结算类别
	 * @return
	 */
	List<Map<String, Object>> getSettleCategoryList();
}
