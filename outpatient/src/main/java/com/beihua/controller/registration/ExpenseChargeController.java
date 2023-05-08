package com.neuedu.controller.registration;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.bean.Result;
import com.neuedu.service.registration.ExpenseChargeService;

@RestController
@CrossOrigin
public class ExpenseChargeController {

	@Autowired
	private ExpenseChargeService expenseChargeService;
	
	@GetMapping("/getPatientAndItem")
	public Map<String, Object> getPatientAndItem(String caseNumber, String realName) {
		
		return expenseChargeService.getPatientAndItem(caseNumber, realName);
	}
	
	@PostMapping("/updateItemState")
	public Result updateItemState(@RequestBody List<Map<String, Object>> list) {
		
		try {
			expenseChargeService.updateItemState(list);
			return Result.build(200, "缴费成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Result.build(500, "缴费失败");
		}
	}
}
