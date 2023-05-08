package com.beihua.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegistLevelMapper {

	/**
	 *  查询 挂号级别列表
	 * @return
	 */
	List<Map<String, Object>> getRegistLevelList();
}
