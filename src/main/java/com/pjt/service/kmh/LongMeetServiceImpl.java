package com.pjt.service.kmh;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.pjt.domain.kmh.Criteria;
import com.pjt.domain.kmh.MatchRegisterVO;
import com.pjt.domain.kmh.UserInfoDTO;
import com.pjt.persistence.kmh.LongMeetDAO;

@Service
public class LongMeetServiceImpl implements LongMeetService {
	
	@Inject
	LongMeetDAO dao;

	@Override
	public List<MatchRegisterVO> longUserList(int page) throws Exception {
		return dao.longUserList(page);
	}

	@Override
	public void regist(MatchRegisterVO vo) throws Exception {
		
	}

	@Override
	public int listCount() throws Exception {
		return dao.listCount();
	}

	@Override
	public UserInfoDTO userDetailInfo(String user_id) throws Exception {
		return dao.detailInfo(user_id);
	}

	




	
	
	
	
//	@Inject
//	MatchRegisterDAO dao;
//
//	@Override
//	public MatchRegisterVO read(Integer num) throws Exception {
//		return dao.read(num);
//	}

}
