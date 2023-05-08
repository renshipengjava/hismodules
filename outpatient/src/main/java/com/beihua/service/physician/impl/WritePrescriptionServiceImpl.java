package com.neuedu.service.physician.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.mapper.DrugInfoMapper;
import com.neuedu.mapper.PrescriptionMapper;
import com.neuedu.service.physician.WritePrescriptionService;
@Service
public class WritePrescriptionServiceImpl implements WritePrescriptionService {
	
	@Autowired
	private DrugInfoMapper drugInfoMapper;
	@Autowired
	private PrescriptionMapper prescriptionMapper;

	@Override
	public List<Map<String, Object>> getDrugInfo(String drugName, String mnemonicCode) {
		return drugInfoMapper.getDrugInfoByCondition(drugName, mnemonicCode);
	}

	@Override
	public void addDrugPrescription(Map<String, Object> map) {
		
		//遍历药品列表
		List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("drugInfoList");
		Integer registerId = (Integer) map.get("registerId");
		for (Map<String, Object> m : list) {
			m.put("registerId", registerId);
			Integer id = (Integer) m.get("id");
			m.put("drugId", id);
			m.put("drug_state", "已开立");
			System.out.println(m);
			prescriptionMapper.savePrescription(m);
		}
		
	}

}
