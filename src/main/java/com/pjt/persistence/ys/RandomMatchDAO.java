package com.pjt.persistence.ys;

import java.util.List;

import com.pjt.domain.ys.CategoryVO;
import com.pjt.domain.ys.MeetVO;
import com.pjt.domain.ys.MeetUpdateDTO;
import com.pjt.domain.ys.RequestMatchDTO;
import com.pjt.domain.ys.UserDTO;

public interface RandomMatchDAO {

	List<CategoryVO> readCategory() throws Exception;

	UserDTO readUserInfo(String id) throws Exception;

	List<MeetVO> getSelectMeetWriterList(RequestMatchDTO vo) throws Exception;

	void matchUpdate(MeetUpdateDTO dto) throws Exception;
	
//	void insertRandom(MeetVO vo) throws Exception;
}
