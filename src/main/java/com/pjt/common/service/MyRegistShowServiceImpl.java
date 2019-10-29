package com.pjt.common.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.pjt.common.domain.MyRegistShowDTO;
import com.pjt.common.domain.MyRequestingInfoDTO;
import com.pjt.common.persistence.MyRegistShowDAO;


@Service
public class MyRegistShowServiceImpl implements MyRegistShowService {
	
	@Inject
	MyRegistShowDAO dao;
	
	@Override
	public MyRegistShowDTO myRegistShow(String user_id)throws Exception{
		return dao.myRegistShow(user_id);
	}

	@Override
	public void completeMatching(String user_id) throws Exception {
		 dao.completeMatching(user_id);
	}
	
	
	@Override
	public void updatePartner(int meet_num, String meet_partner)throws Exception{
		dao.updatePartnerInfo(meet_num, meet_partner);
	}

	@Override
	public List<MyRequestingInfoDTO> myRequestingShow(String user_id) throws Exception {
		return	dao.myRequestingShow(user_id);
	}

	
}
