package com.pjt.common.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.common.domain.MyRegistShowDTO;
import com.pjt.common.domain.MyRequestingInfoDTO;

@Repository
public class MyRegistShowDAOImpl implements MyRegistShowDAO {

	private static final String NAMESPACE = "mappers.myRegistShowMapper";

	@Inject
	private SqlSession sqlSession;
	// 등록 현황 보여주기
	@Override
	public MyRegistShowDTO myRegistShow(String user_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".myRegistShow", user_id);
	}

	@Override
	public void completeMatching(String user_id) throws Exception {
		sqlSession.update(NAMESPACE + ".completeMatching", user_id);

	}

	@Override
	public void updatePartnerInfo(int meet_num, String meet_partner) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("meet_num", meet_num);
		paramMap.put("meet_partner", meet_partner);

		System.out.println("JoinDAOImpl, insertPartnerInfo, meet_num:" + meet_num);
		System.out.println("JoinDAOImpl, insertPartnerInfo, meet_partner:" + meet_partner);

		sqlSession.update(NAMESPACE + ".updatePartnerInfo", paramMap);
	}

	@Override
	public List<MyRequestingInfoDTO> myRequestingShow(String user_id) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".myRequestingShow",user_id);
	}

	
	
}
