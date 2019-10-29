package com.pjt.common.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.common.domain.JoinDTO;

@Repository
public class JoinDAOImpl implements JoinDAO {

	private static final String NAMESPACE = "mappers.joinMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<JoinDTO> listAll(String user_id) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectAll", user_id);
	}

	@Override
	public void insertJoin(int meet_num, String user_id) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("meet_num", meet_num);
		paramMap.put("user_id", user_id);
		
		System.out.println("JoinDAOImpl, insertJoin, meet_num:" + meet_num);
		System.out.println("JoinDAOImpl, insertJoin, user_id:" + user_id);
		
		sqlSession.insert(NAMESPACE + ".insertJoin", paramMap);
	}

	@Override
	public void update(int meet_num) throws Exception {
		sqlSession.update(NAMESPACE + ".updateJoin", meet_num);
	}

	@Override
	public void deleteRequest(int join_idx) throws Exception {
		sqlSession.delete(NAMESPACE + ".deleteRequest", join_idx);
	}
	
	@Override
	public List<String> selectListByMeetNum(int meet_num) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectListByMeetNum", meet_num);
	}

	@Override
	public void updatePeopleNum(int meet_num) throws Exception {
		sqlSession.update(NAMESPACE + ".updatePeopleNum", meet_num);
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
}
