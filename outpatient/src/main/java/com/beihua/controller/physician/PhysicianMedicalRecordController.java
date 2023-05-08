package com.neuedu.controller.physician;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.bean.Result;
import com.neuedu.service.physician.PhysicianMedicalRecordService;

@RestController
@CrossOrigin
public class PhysicianMedicalRecordController {

	@Autowired
	private PhysicianMedicalRecordService physicianMedicalRecordService;
	
	@PostMapping("/getDisease")
	public List<Map<String, Object>> getDisease(@RequestBody Map<String, Object> map) {
		
		return physicianMedicalRecordService.getDisease(map);
	}
	@PostMapping("/saveMedicalRecord")
	public Result saveMedicalRecord(@RequestBody Map<String, Object> map) {
		
		try {
			physicianMedicalRecordService.saveMedicalRecord(map);
			return Result.build(200, "保存病历成功");
		} catch (Exception e) {
			e.printStackTrace();
			return Result.build(500, "保存病历失败");
		}
	}
}
