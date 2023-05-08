package com.beihua.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InspectionRequestMapper {

	/**
	 * 根据患者id和状态查询检验项目
	 * @param registerId
	 * @param state
	 * @return
	 */
	List<Map<String, Object>> getCheckByRegisterIdAndState(Integer registerId, String state);

	/**
	 * 更新检验项目状态
	 * @param list
	 * @return
	 */
	void updateItemState(Integer id, String state);

}
