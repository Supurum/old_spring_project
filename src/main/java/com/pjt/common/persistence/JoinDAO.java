package com.pjt.common.persistence;



import java.util.List;

import com.pjt.common.domain.JoinDTO;

public interface JoinDAO {
	
	
	public List<JoinDTO> listAll(String user_id) throws Exception;
	
	public void insertJoin(int meet_num, String user_id) throws Exception;
	
	public void update(int meet_num) throws Exception;
	
	public void deleteRequest(int join_idx) throws Exception;
	
	public List<String> selectListByMeetNum(int meet_num) throws Exception;
	
	public void updatePeopleNum(int meet_num)throws Exception;
	
	// 수락 버튼 눌렀을때 파트너 정보 넣기 
	public void updatePartnerInfo(int meet_num, String meet_partner)throws Exception;
}
