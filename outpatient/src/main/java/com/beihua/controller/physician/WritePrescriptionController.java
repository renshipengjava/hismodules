package com.neuedu.controller.physician;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.bean.Result;
import com.neuedu.service.physician.WritePrescriptionService;

@RestController
@CrossOrigin
public class WritePrescriptionController {

	@Autowired
	private WritePrescriptionService writePrescriptionService;
	
	@GetMapping("/getDrugInfo")
	public List<Map<String, Object>> getDrugInfo(String drugName, String mnemonicCode) {
		return writePrescriptionService.getDrugInfo(drugName, mnemonicCode);
	}
	@PostMapping("/addDrugPrescription")
	public Result addDrugPrescription(@RequestBody Map<String, Object> map) {
		writePrescriptionService.addDrugPrescription(map);
		return Result.ok();
	}
}
