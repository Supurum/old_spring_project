package com.pjt.common.service;

import java.util.List;

import com.pjt.common.domain.MyRegistShowDTO;
import com.pjt.common.domain.MyRequestingInfoDTO;

public interface MyRegistShowService {

	public MyRegistShowDTO myRegistShow(String user_id) throws Exception;

	public void completeMatching(String user_id)throws Exception;
	
	public void updatePartner(int meet_num,String meet_partner)throws Exception;
	
	public List<MyRequestingInfoDTO> myRequestingShow(String user_id)throws Exception;
}
