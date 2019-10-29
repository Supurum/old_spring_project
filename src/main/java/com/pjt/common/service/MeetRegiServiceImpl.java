package com.pjt.common.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pjt.common.domain.MeetRegiVO;
import com.pjt.common.persistence.MeetRegiDAO;

@Service
public class MeetRegiServiceImpl implements MeetRegiService {
	@Inject
	MeetRegiDAO dao;
	@Override
	public void waitRegi(MeetRegiVO vo) throws Exception {
		dao.waitRegi(vo);
	}
	@Override
	public int waitRegiOverRapChk(String meet_writer) throws Exception {
		return dao.waitRegioverRapChk(meet_writer);
	}

}
