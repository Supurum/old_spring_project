package com.pjt.service.kth;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pjt.domain.kth.UserInfoDTO;
import com.pjt.persistence.kth.UserInfoDAO;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Inject
	private UserInfoDAO dao;
	
	@Override
	public UserInfoDTO select(Integer meet_num) throws Exception {
		return dao.select(meet_num);
	}

}
