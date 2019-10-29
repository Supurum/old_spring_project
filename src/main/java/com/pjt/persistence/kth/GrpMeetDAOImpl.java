package com.pjt.persistence.kth;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.domain.kth.GrpMeetVO;

@Repository
public class GrpMeetDAOImpl implements GrpMeetDAO {
	
	private static final String NAMESPACE = "mappers.grpMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public GrpMeetVO select(Integer meet_num) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectOne", meet_num);
	}

	@Override
	public void insert(GrpMeetVO vo) throws Exception {
		sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public void update(GrpMeetVO vo) throws Exception {
		sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public void delete(Integer meet_num) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", meet_num);
	}

	@Override
	public List<GrpMeetVO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

}
