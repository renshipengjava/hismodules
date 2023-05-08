package com.neuedu.service.check;

import java.util.List;
import java.util.Map;

public interface CheckPatientService {

	/**
	 *  根据患者id查询对应的检查项
	 * @param registerId
	 * @return
	 */
	List<Map<String, Object>> getPatientCheckList(Integer registerId);

	/**
	 *  查询检查部门信息
	 * @return
	 */
	List<Map<String, Object>> getCheckDept();

	/**
	 *   根据部门id查询医生信息
	 * @param deptId
	 * @return
	 */
	List<Map<String, Object>> getEmployeeByDeptId(Integer deptId);

	/**
	 *  修改检查信息
	 * @param map
	 */
	void addCheckPatient(Map<String, Object> map);

}
