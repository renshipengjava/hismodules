package com.beihua.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CheckRequestMapper {

	/**
	 * 保存检查项目
	 * @param map
	 */
	void saveCheckRequest(Map<String, Object> map);

	/**
	 * 根据患者id和状态查询检查项目
	 * @param registerId
	 * @param string
	 * @return
	 */
	List<Map<String, Object>> getCheckByRegisterIdAndState(Integer registerId, String state);

	/**
	 * 更新检查项目状态
	 * @param list
	 * @return
	 */
	void updateItemState(Integer id, String state);

	//根据状态得到患者数量
	Integer getCheckCountByState(@Param("checkState") String checkState);
	//得到当前医生排队患者信息
	List<Map<String, Object>> getWaitCheck(String case_number, String real_name);

	/**
	 *  根据患者id查询对应的检查项
	 * @param registerId
	 * @return
	 */
	List<Map<String, Object>> getPatientCheckByRegisterId(Integer registerId);

	/**
	 *  修改检查信息
	 * @param map
	 */
	void updateCheckById(Map<String, Object> map);
	/**
	 *   查询完成检查的患者信息
	 * @param case_number
	 * @param real_name
	 * @return
	 */
	List<Map<String, Object>> getFinishCheck(String case_number, String real_name);

	/**
	 *  按患者id查询执行完成检查项目
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> getFinishCheckByRegistid(Integer id);

	void updateCheckInput(String id, String employee_id, String check_result);

	/**
	 *  根据id查询已出结果的检查项目
	 * @param registerId
	 * @return
	 */
	Map<String, Object> getCheckRequestById(Integer id);

}
