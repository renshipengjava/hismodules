package com.neuedu.controller.physician;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neuedu.service.physician.PhysicianHistorySerivice;

/**
 * 医生看诊：看诊记录
 */
@RestController
@CrossOrigin
public class PhysicianHistoryController {
	@Autowired
	private PhysicianHistorySerivice physicianHistorySerivice;

	@RequestMapping("getCheckedPatient")
	public PageInfo getCheckedPatient(@RequestParam("employee_id") Integer employee_id
			,@RequestParam("case_number") String case_number
			,@RequestParam("real_name") String real_name
			,@RequestParam("nowPageNumber") Integer nowPageNumber
			,@RequestParam("pageSize") Integer pageSize	){
		
		return physicianHistorySerivice.getCheckedPatient(employee_id,case_number,real_name,nowPageNumber,pageSize);
	}
	
}
