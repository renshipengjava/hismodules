package com.beihua.service.drugstage.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.mapper.PrescriptionMapper;
import com.neuedu.mapper.RegisterMapper;
import com.neuedu.service.drugstage.GiveMedicineService;
@Service
public class GiveMedicineServiceImpl implements GiveMedicineService {

	@Autowired
	private RegisterMapper registerMapper;
	@Autowired
	private PrescriptionMapper prescriptionMapper;
	@Override
	public PageInfo getRegister(Integer caseNumber, String realName, Integer nowPageNumber, Integer pageSize) {
		PageHelper.startPage(nowPageNumber, pageSize);
		List<Map<String, Object>> list = registerMapper.getRegisterByDrugState(caseNumber,realName);
		return new PageInfo(list);
	}
	@Override
	public List<Map<String, Object>> getDrugInfoByRegisterIdAndState(Integer registerId) {
		return prescriptionMapper.getDrugInfoByRegisterIdAndState(registerId);
	}
	@Override
	public void giveMedicine(Map<String, Object> map) {
		Integer id = (Integer) map.get("drugId");
		prescriptionMapper.updateItemState(id, "已发药");;
	}

}
