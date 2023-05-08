package com.neuedu.controller.check;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.bean.Result;
import com.neuedu.service.check.CheckPatientService;

@RestController
@CrossOrigin
public class CheckPatientController {
	
	@Autowired
	private CheckPatientService checkPatientService;

	@GetMapping("/getPatientCheckList")
	public List<Map<String, Object>> getPatientCheckList(Integer registerId) {
		
		return checkPatientService.getPatientCheckList(registerId);
	}
	@GetMapping("/getCheckDept")
	public List<Map<String, Object>> getCheckDept() {
		
		return checkPatientService.getCheckDept();
	}
	@GetMapping("/getEmployeeByDeptId")
	public List<Map<String, Object>> getEmployeeByDeptId(Integer deptId) {
		return checkPatientService.getEmployeeByDeptId(deptId);
	}
	
	@PostMapping("/addCheckPatient")
	public Result addCheckPatient(@RequestBody Map<String, Object> map) {
		try {
			checkPatientService.addCheckPatient(map);
			return Result.build(200, "更新检查信息成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Result.build(500, "更新检查信息失败");
		}
	}
	
}
