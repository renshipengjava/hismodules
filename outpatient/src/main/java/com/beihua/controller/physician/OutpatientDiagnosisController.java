package com.neuedu.controller.physician;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.bean.Result;
import com.neuedu.service.physician.OutpatientDiagnosisService;

@RestController
@CrossOrigin
public class OutpatientDiagnosisController {

	@Autowired
	private OutpatientDiagnosisService outpatientDiagnosisService;
	
	@PostMapping("/outpatientDiagnosis")
	public Result outpatientDiagnosis(@RequestParam Map<String, Object> map) {
		
		outpatientDiagnosisService.outpatientDiagnosis(map);
		return Result.ok();
	}
}
