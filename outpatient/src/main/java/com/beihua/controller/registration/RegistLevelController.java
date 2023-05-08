package com.neuedu.controller.registration;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.service.registration.RegistLevelService;

@RestController
@CrossOrigin
public class RegistLevelController {

	@Autowired
	private RegistLevelService registLevelService;
	
	@GetMapping("/getRegistLevelList")
	public List<Map<String, Object>> getRegistLevelList() {
		
		return registLevelService.getRegistLevelList();
	}
}
