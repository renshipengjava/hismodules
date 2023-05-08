package com.beihua.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MedicalRecordDiseaseMapper {

	/**
	 *  保存病历疾病关系表数据
	 * @param id
	 * @param diseaseId
	 */
	void saveMedicalRecordDisease(Integer medical_record_id, Integer disease_id);

}
