package com.neuedu.service.check.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.mapper.CheckRequestMapper;
import com.neuedu.mapper.DepartmentMapper;
import com.neuedu.mapper.EmployeeMapper;
import com.neuedu.service.check.CheckPatientService;
@Service
public class CheckPatientServiceImpl implements CheckPatientService {

	@Autowired
	private CheckRequestMapper checkRequestMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Override
	public List<Map<String, Object>> getPatientCheckList(Integer registerId) {
		return checkRequestMapper.getPatientCheckByRegisterId(registerId);
	}
	@Override
	public List<Map<String, Object>> getCheckDept() {
		return departmentMapper.getDeptList("检查");
	}
	@Override
	public List<Map<String, Object>> getEmployeeByDeptId(Integer deptId) {
		return employeeMapper.getEmployeeByDeptId(deptId);
	}
	@Override
	public void addCheckPatient(Map<String, Object> map) {
		checkRequestMapper.updateCheckById(map);
		
	}

}
