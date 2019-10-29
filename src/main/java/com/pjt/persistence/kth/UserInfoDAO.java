package com.pjt.persistence.kth;

import com.pjt.domain.kth.UserInfoDTO;

public interface UserInfoDAO {
	
	public UserInfoDTO select(Integer meet_num) throws Exception;
}
