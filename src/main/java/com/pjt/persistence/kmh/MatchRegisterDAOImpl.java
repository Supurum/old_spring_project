package com.pjt.persistence.kmh;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.domain.kmh.MatchRegisterVO;
@Repository
public class MatchRegisterDAOImpl implements MatchRegisterDAO {
	
	private static final String NAMESPACE = "mappers.longMeetMapper";
	
	@Inject
	private SqlSession sqlSession;

	
	// 매칭 등록 회원 불러오기 	
	public MatchRegisterVO read(Integer num) throws Exception {
		 return sqlSession.selectOne(NAMESPACE + ".read", num);
	}
	
	
	// 유저 정보 넣기 	
	@Override
	public void RegisterCreate(MatchRegisterVO vo) throws Exception {
		sqlSession.insert(NAMESPACE + ".RegisterCreate", vo);
	}

	
	// 매칭 신청 후 유저 정보 업데이트 
	@Override
	public void update(String user_id, String meet_partner, String meet_state) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("meet_state", meet_state);
		paramMap.put("meet_partner", meet_partner);
		paramMap.put("user_id", user_id);
		sqlSession.update(NAMESPACE+ ".update",paramMap);
	}

	// 페이징 처리 
	@Override
	public List<MatchRegisterVO> listPage(int page)throws Exception {
		int startRow = ((page - 1) * 6) + 1;
		int endRow = page * 6;
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		return sqlSession.selectList(NAMESPACE + ".listPage", paramMap);
	}

	
	@Override
	public int listCount()throws Exception{
		return sqlSession.selectOne(NAMESPACE+ ".listCount");
	}
	

	@Override
	public List<MatchRegisterVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
}
