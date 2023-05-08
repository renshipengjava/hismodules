package com.neuedu.controller.physician;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neuedu.bean.Result;
import com.neuedu.service.physician.PhysicianPatientService;

@RestController
@CrossOrigin
public class PhysicianPatientController {

	@Autowired
	private PhysicianPatientService physicianPatientService;
	
	@GetMapping("/getFinishPatientCount")
	public Integer getFinishPatientCount(Integer employeeId) {
		
		return physicianPatientService.getFinishPatientCount(employeeId);
	}
	@GetMapping("/getWaitPatientCount")
	public Integer getWaitPatientCount(Integer employeeId) {
		
		return physicianPatientService.getWaitPatientCount(employeeId);
	}
	@PostMapping("/getWaitPatientList")
	public PageInfo getWaitPatientList(@RequestBody Map<String, Object> map) {
		
		return physicianPatientService.getWaitPatientList(map);
	}
	@PostMapping("/updateRegisterState")
	public Result updateRegisterState(@RequestBody Map<String, Object> map) {
		physicianPatientService.updateRegisterState(map);
		return Result.ok();
	}
	
	
}
