package com.neuedu.service.physician;

import java.util.Map;

import com.github.pagehelper.PageInfo;

public interface PhysicianPatientService {

	/**
	 * 根据医生id查询当日已看诊人数
	 * @param employeeId
	 * @return
	 */
	Integer getFinishPatientCount(Integer employeeId);

	/**
	 * 根据医生id查询当日等待人数
	 * @param employeeId
	 * @return
	 */
	Integer getWaitPatientCount(Integer employeeId);

	/**
	 *  根据医生id查询当日等待患者信息
	 * @param employeeId
	 * @return  分页信息
	 */
	PageInfo getWaitPatientList(Map<String, Object> map);

	/**
	 *   更新挂号信息状态为2
	 * @param map
	 */
	void updateRegisterState(Map<String, Object> map);

}
