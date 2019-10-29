package com.pjt.common.persistence;

import com.pjt.common.domain.MeetRegiVO;

public interface MeetRegiDAO {
	public void waitRegi(MeetRegiVO vo) throws Exception;
	public int waitRegioverRapChk(String meet_writer) throws Exception;
	
}
