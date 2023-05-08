package com.neuedu.service.physician.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.mapper.MedicalRecordMapper;
import com.neuedu.service.physician.OutpatientDiagnosisService;

@Service
public class OutpatientDiagnosisServiceImpl implements OutpatientDiagnosisService {

	@Autowired
	private MedicalRecordMapper medicalRecordMapper;
	
	@Override
	public void outpatientDiagnosis(Map<String, Object> map) {
		medicalRecordMapper.updateMedicalRecord(map);

	}

}
