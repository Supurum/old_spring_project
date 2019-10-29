package com.pjt.service.ys;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pjt.common.persistence.CommonDAO;
import com.pjt.domain.ys.LogVO;
import com.pjt.domain.ys.LoginDTO;
import com.pjt.domain.ys.PointVO;
import com.pjt.domain.ys.SearchCriteria;
import com.pjt.domain.ys.UserSearchDTO;
import com.pjt.domain.ys.UserSearchRequestDTO;
import com.pjt.domain.ys.UserVO;
import com.pjt.persistence.ys.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Inject
	UserDAO dao;
	
	@Inject
	CommonDAO cdao;

	//로그인
	@Transactional
	@Override
	public String login(LoginDTO dto) throws Exception {
		System.out.println("service실행");
		String id = cdao.login(dto);
		
		if(id !=null){
			int count=cdao.checkLoginToday(id);
			LogVO lvo= new LogVO(id,"login");
			cdao.writeLog(lvo);
			if(count==0){
				PointVO pvo= new PointVO(id,"TODAY LOGIN","출석보상");
				int re = cdao.updatePoint(pvo);
				if(re==1){
					cdao.writePointTBook(pvo);
				}
				return id;
			}
			else if(count>0) {
				return id;
			}
		}
		return null;
	}
	//ID중복 확인
	@Override
	public int checkID(String id) throws Exception {
		int result=dao.checkID(id);
		return result;
	}
	//닉네임 중복확인
	@Override
	public int checkNick(String name) throws Exception {
		return dao.checkNick(name);
	}
	//회원가입
	@Override
	public void registUser(UserVO vo) throws Exception {
		dao.registUser(vo);
	}
	//회원정보 수정-회원정보 얻기
	@Override
	public UserVO getUserInfo(String id) throws Exception {
		UserVO vo=dao.getUserInfo(id);
		return vo;
	}
	//회원정보 수정-이전 사진 파일 삭제
	@Override
	public String getUserPhoto(String user_id) throws Exception {
		return dao.getUserPhoto(user_id);
	}
	//회원정보 수정-회원정보수정
	@Override
	public int updateUserInfo(UserVO vo) throws Exception {
		return dao.updateUserInfo(vo);
	}	
	//회원검색-검색된 리스트 
	@Override
	public List<UserSearchDTO> getSearchUserList(UserSearchRequestDTO dto) throws Exception {
		List<UserSearchDTO> list = dao.getSearchUserList(dto);
		return list;
	}
	//회원검색-검색된 회원 수
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}
	
	//사용하지 않음
//	@Override
//	public int getUserLoc(String id) throws Exception {
//		int locNum = dao.getUserLoc(id);
//		return locNum;
//	}
}
