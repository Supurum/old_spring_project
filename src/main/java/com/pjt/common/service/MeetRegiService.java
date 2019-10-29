package com.pjt.common.service;

import com.pjt.common.domain.MeetRegiVO;

public interface MeetRegiService {
	public void waitRegi(MeetRegiVO vo) throws Exception;
	public int waitRegiOverRapChk(String meet_writer) throws Exception;
}
