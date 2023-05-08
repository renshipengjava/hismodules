package com.neuedu.service.check;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

public interface CheckInputService {

	PageInfo getFinishCheck(String case_number, String real_name, Integer nowPageNumber, Integer pageSize);

	List<Map<String, Object>> getFinishCheckByRegistid(Integer id);

	void updateCheckInput(String id, String employee_id, String check_result);

}
