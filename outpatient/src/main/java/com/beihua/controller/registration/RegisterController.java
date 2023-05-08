package com.neuedu.controller.registration;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.bean.Result;
import com.neuedu.service.registration.RegisterService;

@RestController
@CrossOrigin
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@GetMapping("/getCaseNumber")
	public String getCaseNumber() {
		return registerService.getCaseNumber();
	}
	@GetMapping("/getUsedNumberByEmployeeIdAndNoon")
	public Integer getUsedNumberByEmployeeIdAndNoon(Integer empId, String noon) {
		return registerService.getUsedNumberByEmployeeIdAndNoon(empId, noon);
	}
	
	@PostMapping("/saveRegister")
	public Result saveRegister(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		return registerService.saveRegister(map);
	}
}
