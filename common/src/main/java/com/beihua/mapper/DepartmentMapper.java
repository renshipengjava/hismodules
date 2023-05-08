package com.beihua.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DepartmentMapper {

	/**
	 * 查询所有部门信息
	 * @return
	 */
	List<Map<String, Object>> getDeptList(@Param("deptType") String deptType);
}
