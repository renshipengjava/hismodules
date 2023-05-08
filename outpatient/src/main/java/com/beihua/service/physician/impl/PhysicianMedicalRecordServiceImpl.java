package com.neuedu.service.physician.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.bean.Result;
import com.neuedu.mapper.DiseaseMapper;
import com.neuedu.mapper.MedicalRecordDiseaseMapper;
import com.neuedu.mapper.MedicalRecordMapper;
import com.neuedu.service.physician.PhysicianMedicalRecordService;
@Service
@Transactional
public class PhysicianMedicalRecordServiceImpl implements PhysicianMedicalRecordService {

	@Autowired
	private DiseaseMapper diseaseMapper;
	@Autowired
	private MedicalRecordMapper medicalRecordMapper;
	@Autowired
	private MedicalRecordDiseaseMapper medicalRecordDiseaseMapper;
	
	@Override
	public List<Map<String, Object>> getDisease(Map<String, Object> map) {
		System.out.println(map);
		return diseaseMapper.getDisease(map);
	}

	@Override
	public void saveMedicalRecord(Map<String, Object> map) {
		// 向病历表中保存数据
		medicalRecordMapper.saveMedicalRecord(map);
		System.out.println(map);
		//获得保存新病历的id
		Integer id = (Integer) map.get("id");
		//遍历保存疾病id的数组，向病历疾病关系表中，插入一条数据
		for(Integer diseaseId : (List<Integer>)map.get("disease")) {
			medicalRecordDiseaseMapper.saveMedicalRecordDisease(id, diseaseId);
		}
		
	}

}
