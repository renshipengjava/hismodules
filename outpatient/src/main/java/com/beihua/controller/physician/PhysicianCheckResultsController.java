package com.neuedu.controller.physician;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.service.physician.PhysicianCheckResultsService;

@RestController
@CrossOrigin
public class PhysicianCheckResultsController {
	
	@Autowired
	private PhysicianCheckResultsService physicianCheckResultsService;

	@GetMapping("/getCheckRequestByRegisterId")
	public List<Map<String, Object>> getCheckRequestByRegisterId(Integer registerId) {
		
		return physicianCheckResultsService.getCheckRequestByRegisterId(registerId);
	}
	@GetMapping("/getCheckRequestById")
	public Map<String, Object> getCheckRequestById(Integer id) {
		
		return physicianCheckResultsService.getCheckRequestById(id);
	}
}
