package com.beihua.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

	/**
	 *  根据科室id和号别id查询医生
	 * @param deptId 
	 * @param levelId
	 * @return
	 */
	List<Map<String, Object>> getEmpByDeptIdAndLevelId(Integer deptId, Integer levelId);

	/**
	 *   根据部门id查询医生信息
	 * @param deptId
	 * @return
	 */
	List<Map<String, Object>> getEmployeeByDeptId(Integer deptId);
}
