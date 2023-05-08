package com.neuedu.controller.physician;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.bean.Result;
import com.neuedu.service.physician.PhysicianCheckRequestService;

@RestController
@CrossOrigin
public class PhysicianCheckRequestController {
	
	@Autowired
	private PhysicianCheckRequestService physicianCheckRequestService;

	@RequestMapping("/getMedicalTechnology")
	public List<Map<String, Object>> getMedicalTechnology(String techCode, String techName) {
		
		return physicianCheckRequestService.getMedicalTechnology(techCode, techName);
	}
	
	@PostMapping("/saveCheckRequest")
	public Result saveCheckRequest(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		physicianCheckRequestService.saveCheckRequest(map);
		return Result.ok();
	} 
}
