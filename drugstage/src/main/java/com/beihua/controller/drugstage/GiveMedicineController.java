package com.beihua.controller.drugstage;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.beihua.bean.Result;
import com.beihua.service.drugstage.GiveMedicineService;

@RestController
@CrossOrigin
public class GiveMedicineController {

	@Autowired
	private GiveMedicineService giveMedicineService;
	
	@GetMapping("/getRegister")
	public PageInfo getRegister(Integer caseNumber, String realName,
				Integer nowPageNumber, Integer pageSize) {
		
		return giveMedicineService.getRegister(caseNumber, realName,nowPageNumber, pageSize); 
	}
	@GetMapping("/getDrugInfoByRegisterIdAndState")
	public List<Map<String, Object>> getDrugInfoByRegisterIdAndState(Integer registerId) {
		
		return giveMedicineService.getDrugInfoByRegisterIdAndState(registerId); 
	}
	@PostMapping("/giveMedicine")
	public Result giveMedicine(@RequestBody Map<String, Object> map) {
		try {
			giveMedicineService.giveMedicine(map);
			return Result.build(200, "发药成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Result.build(500, "发药失败");
		}
	}
}
