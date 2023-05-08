package com.beihua.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {

	/**
	 * 获得最大病历号
	 * @return
	 */
	Integer getMaxCaseNumber();
	/**
	 *   根据医生编号和午别，查询当天该医生已用的号额
	 * @param empId
	 * @param noon
	 * @return
	 */
	Integer getUsedNumberByEmployeeIdAndNoon(Integer empId, String noon);
	
	/**
	 * 保存挂号信息
	 * @param map
	 */
	Integer saveRegister(Map<String, Object> map);
	
	/**
	 * 根据挂号状态，查询人数
	 * @param map
	 * @return
	 */
	Integer getCountByEmployeeIdAndState(Integer employeeId, Integer visitState);
	/**
	 *  根据医生id查询当日等待患者信息
	 * @param employeeId
	 * @return
	 */
	List<Map<String, Object>> getWaitPatientList(Map<String, Object> map);
	/**
	 * 根据病历号、患者姓名查询患者信息
	 * @param caseNumber
	 * @param realName
	 * @return
	 */
	Map<String, Object> getRegisterByCaseAndName(String caseNumber, String realName);
	
	List<Map<String, Object>> getPatientByState(Integer employee_id, String case_number, String real_name);
	
	/**
	 *   更新挂号信息状态为2
	 * @param map
	 */
	void updateRegisterState(Integer id);
	/**
	 *   根据条件查询患者信息
	 * @param caseNumber
	 * @param realName
	 * @return
	 */
	List<Map<String, Object>> getRegisterByDrugState(Integer caseNumber, String realName);

}
