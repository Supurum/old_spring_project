package com.pjt.common.service;

import java.util.List;

import com.pjt.common.domain.JoinDTO;

public interface JoinService {
	
	public List<JoinDTO> listAll(String user_id) throws Exception;
	
	public void insertJoin(int meet_num, String user_id) throws Exception;
	
	public void update(int meet_num) throws Exception;
	
	public void deleteRequest(int join_idx) throws Exception;
	
	public List<String> selectListByMeetNum(int meet_num) throws Exception;
	
	public void updatePeopleNum(int meet_num)throws Exception;
	
	public void updatePartner(int meet_num,String meet_partner)throws Exception;
	
}
