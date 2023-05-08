package com.beihua.controller.registration;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beihua.service.registration.DepartmentService;

@RestController
@CrossOrigin
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/getDeptList")
	public List<Map<String, Object>> getDeptList() {
		return departmentService.getDeptList();
	}
}