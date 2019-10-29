package com.pjt.service.kmh;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.pjt.domain.kmh.Criteria;
import com.pjt.domain.kmh.MatchRegisterVO;
import com.pjt.persistence.kmh.MatchRegisterDAO;

@Service
public class MatchRegisterServiceImpl implements MatchRegisterService {
	
	@Inject
	MatchRegisterDAO dao;

	@Override
	public List<MatchRegisterVO> listPage(int page) throws Exception {
		return dao.listPage(page);
	}

	@Override
	public void regist(MatchRegisterVO vo) throws Exception {
		
	}

	@Override
	public int listCount() throws Exception {
		return dao.listCount();
	}


	
	
	
	
//	@Inject
//	MatchRegisterDAO dao;
//
//	@Override
//	public MatchRegisterVO read(Integer num) throws Exception {
//		return dao.read(num);
//	}

}
