package com.pjt.persistence.ys;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.domain.ys.CategoryVO;
import com.pjt.domain.ys.MeetVO;
import com.pjt.domain.ys.MeetUpdateDTO;
import com.pjt.domain.ys.RequestMatchDTO;
import com.pjt.domain.ys.UserDTO;

@Repository
public class RandomMatchDAOImpl implements RandomMatchDAO {
	private static final String NAMESPACE = "mappers.randommeetMapper";
	
	@Inject
	private SqlSession sqlSession;
	//매칭해줄 분류 리스트 읽기
	@Override
	public List<CategoryVO> readCategory() throws Exception {
		List<CategoryVO> categoryList=sqlSession.selectList(NAMESPACE+".readCategory");
		return categoryList;
	}
	//매칭시킬수 있는 만남 리스트
	@Override
	public List<MeetVO> getSelectMeetWriterList(RequestMatchDTO vo) throws Exception {
		List<MeetVO> list= sqlSession.selectList(NAMESPACE+".getSelectMeetWriterList", vo);
		return list;
	}
	//매칭 성사
	@Override
	public void matchUpdate(MeetUpdateDTO dto) throws Exception {
		sqlSession.update(NAMESPACE+".matchUpdate",dto);
	}

	//유저정보 읽어오기
	@Override
	public UserDTO readUserInfo(String id) throws Exception {
		UserDTO vo= sqlSession.selectOne(NAMESPACE+".readUserInfo", id);
		return vo;
	}
	
	//더 이상 사용하지 않음
//	@Override
//	public void insertRandom(MeetVO vo) throws Exception {
//		sqlSession.insert(NAMESPACE+".insertRandom", vo);
//	}
}
