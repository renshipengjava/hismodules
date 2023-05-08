package com.neuedu.service.registration.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.bean.Result;
import com.neuedu.mapper.CheckRequestMapper;
import com.neuedu.mapper.InspectionRequestMapper;
import com.neuedu.mapper.PrescriptionMapper;
import com.neuedu.mapper.RegisterMapper;
import com.neuedu.service.registration.ExpenseChargeService;
@Service
@Transactional
public class ExpenseChargeServiceImpl implements ExpenseChargeService {
	
	@Autowired
	private RegisterMapper registerMapper;
	@Autowired
	private CheckRequestMapper checkRequestMapper;
	@Autowired
	private InspectionRequestMapper inspectionRequestMapper;
	@Autowired
	private PrescriptionMapper prescriptionMapper;

	@Override
	public Map<String, Object> getPatientAndItem(String caseNumber, String realName) {
		//查询患者信息
		Map<String, Object> result = registerMapper.getRegisterByCaseAndName(caseNumber, realName);
		Integer registerId = (Integer) result.get("id");
		
		//根据患者信息的id查询对应的检查项，状态为'已开立'
		List<Map<String, Object>> itemList = checkRequestMapper.getCheckByRegisterIdAndState(registerId,"已开立");
		//根据患者信息的id查询对应的检验项，状态为'已开立'
		List<Map<String, Object>> inspectionList = inspectionRequestMapper.getCheckByRegisterIdAndState(registerId,"已开立");
		//把两个列表整合到一起。
		itemList.addAll(inspectionList);
		//根据患者信息的id查询对应的处方项，状态为'已开立'
		List<Map<String, Object>> prescriptionList = prescriptionMapper.getPrescriptionByRegisterIdAndState(registerId,"已开立");
		itemList.addAll(prescriptionList);
		
		for (Map<String, Object> map : itemList) {
			Date createDate = (Date) map.get("item_create_time");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String item_create_time = sdf.format(createDate);
			map.put("item_create_time", item_create_time);
		}
		
		result.put("itemList", itemList);
		return result;
	}

	@Override
	public void updateItemState(List<Map<String, Object>> list) {
		for (Map<String, Object> map : list) {
			String itemType = (String) map.get("item_type");
			if("检查".equals(itemType)) {
				checkRequestMapper.updateItemState((Integer)(map.get("id")), "已缴费");
			}else if("检验".equals(itemType)) {
				inspectionRequestMapper.updateItemState((Integer)(map.get("id")), "已缴费");
			}else {
				prescriptionMapper.updateItemState((Integer)(map.get("id")), "已缴费");
			}
		}
	}

}
