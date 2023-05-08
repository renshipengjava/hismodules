package com.neuedu.service.physician;

import com.github.pagehelper.PageInfo;

public interface PhysicianHistorySerivice {

	PageInfo getCheckedPatient(Integer employee_id, String case_number, String real_name, Integer nowPageNumber,
			Integer pageSize);

}
