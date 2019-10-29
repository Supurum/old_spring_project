package com.pjt.service.kth;

import com.pjt.domain.kth.UserInfoDTO;

public interface UserInfoService {
	
	public UserInfoDTO select(Integer meet_num) throws Exception;
}
