package com.pjt.persistence.ys;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.domain.ys.SearchCriteria;
import com.pjt.domain.ys.UserSearchDTO;
import com.pjt.domain.ys.UserSearchRequestDTO;
import com.pjt.domain.ys.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	private static final String NAMESPACE = "mappers.userMapper";
	
	@Inject
	private SqlSession sqlSession;

	//아이디 중복 확인
	@Override
	public int checkID(String id) throws Exception {
		int result=sqlSession.selectOne(NAMESPACE+".checkID", id);
		return result;
	}
	//닉네임 중복 확인
	@Override
	public int checkNick(String name) throws Exception{
		return sqlSession.selectOne(NAMESPACE+".checkNick", name);
	}
	//회원 가입
	@Override
	public void registUser(UserVO vo) throws Exception {
		sqlSession.insert(NAMESPACE+".registUser", vo);
		
	}
	//회원정보 수정-회원정보 얻기
	@Override
	public UserVO getUserInfo(String id) throws Exception {
		UserVO vo=sqlSession.selectOne(NAMESPACE+".getUserInfo", id);
		return vo;
	}
	//회원정보 수정-이전 사진 파일 삭제
	@Override
	public String getUserPhoto(String user_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".getUserPhoto", user_id);
	}
	//회원정보 수정-회원정보수정
	@Override
	public int updateUserInfo(UserVO vo) throws Exception {
		return sqlSession.insert(NAMESPACE+".updateUserInfo", vo);
	}
	//회원검색-검색된 리스트
	@Override
	public List<UserSearchDTO> getSearchUserList(UserSearchRequestDTO dto) throws Exception {
		List<UserSearchDTO> list = sqlSession.selectList(NAMESPACE+".getSearchUserList", dto);
		return list;
	}
	//회원검색-검색된 회원 수
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".listSearchCount", cri);
	}

	//CommonDAO로 이동
//	@Override
//	public List<GenderVO>  getGenderList() throws Exception {
//		List<GenderVO> genderList=sqlSession.selectList(NAMESPACE+".getGenderList");
//		return genderList;
//	}
//
//	@Override
//	public List<LocVO> getLocList() throws Exception {
//		List<LocVO> locList=sqlSession.selectList(NAMESPACE+".getLocList");
//		return locList;
//	}
//
//	@Override
//	public List<ReligionVO> getReligionList() throws Exception {
//		List<ReligionVO> religionList=sqlSession.selectList(NAMESPACE+".getReligionList");
//		return religionList;
//	}
//
//	@Override
//	public String login(LoginDTO dto) throws Exception {
//		String id=sqlSession.selectOne(NAMESPACE+".login", dto);
//		return id;
//	}
	
	//사용하지 않음
//	@Override
//	public int getUserLoc(String id) throws Exception {
//		int locNum=sqlSession.selectOne(NAMESPACE+".getUserLoc", id);
//		return locNum;
//	}
	
}
