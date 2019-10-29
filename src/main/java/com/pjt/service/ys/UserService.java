package com.pjt.service.ys;

import java.util.List;

import com.pjt.domain.ys.LoginDTO;
import com.pjt.domain.ys.SearchCriteria;
import com.pjt.domain.ys.UserSearchDTO;
import com.pjt.domain.ys.UserSearchRequestDTO;
import com.pjt.domain.ys.UserVO;

public interface UserService {
	String login(LoginDTO dto) throws Exception;
	int checkID(String id) throws Exception;
	int checkNick(String name) throws Exception;
	void registUser(UserVO vo) throws Exception;
	UserVO getUserInfo(String id) throws Exception;
	String getUserPhoto(String user_id) throws Exception;
	int updateUserInfo(UserVO vo) throws Exception;
	List<UserSearchDTO> getSearchUserList(UserSearchRequestDTO dto) throws Exception;
	int listSearchCount(SearchCriteria cri) throws Exception;
	//사용하지 않음
//	public int getUserLoc(String id) throws Exception;
}
