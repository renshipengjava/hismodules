package com.neuedu.service.check;

import com.github.pagehelper.PageInfo;

public interface CheckApplyService {

	Integer getFinishCheckCount();

	Integer getWaitCheckCount();

	PageInfo getWaitCheck(String case_number, String real_name, Integer nowPageNumber, Integer pageSize);

}
