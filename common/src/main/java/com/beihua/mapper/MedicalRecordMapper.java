package com.neuedu.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.neuedu.bean.Result;

@Mapper
public interface MedicalRecordMapper {

	/**
	 * 保存病历信息
	 * @param map
	 * @return
	 */
	void saveMedicalRecord(Map<String, Object> map);

	/**
	 * 更新病历信息
	 * @param map
	 * @return
	 */
	void updateMedicalRecord(Map<String, Object> map);
}
