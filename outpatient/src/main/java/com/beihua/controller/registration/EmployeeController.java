package com.neuedu.controller.registration;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.service.registration.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getEmployeeList")
	public List<Map<String, Object>> getEmployeeList(Integer deptId, Integer levelId) {
		
		return employeeService.getEmployeeList(deptId, levelId);
	}
}
