package com.pjt.persistence.ys;

import java.util.List;

import com.pjt.domain.ys.SearchCriteria;
import com.pjt.domain.ys.UserSearchDTO;
import com.pjt.domain.ys.UserSearchRequestDTO;
import com.pjt.domain.ys.UserVO;

public interface UserDAO {
	int checkID(String id) throws Exception;	
	int checkNick(String name) throws Exception;
	void registUser(UserVO vo) throws Exception;
	UserVO getUserInfo(String id) throws Exception;
	String getUserPhoto(String user_id) throws Exception;
	int updateUserInfo(UserVO vo) throws Exception;
	List<UserSearchDTO> getSearchUserList(UserSearchRequestDTO dto) throws Exception;
	public int listSearchCount(SearchCriteria cri) throws Exception;
	//CommonDAO로 이동
//	List<GenderVO> getGenderList() throws Exception;
//	List<LocVO> getLocList() throws Exception;
//	List<ReligionVO> getReligionList() throws Exception;
//	String login(LoginDTO dto) throws Exception;
	//사용하지 않음
//	int getUserLoc(String id) throws Exception;
}
