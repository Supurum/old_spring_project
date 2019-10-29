package com.pjt.common.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pjt.common.domain.JoinDTO;
import com.pjt.common.persistence.JoinDAO;

@Service
public class JoinServiceImpl implements JoinService {

	@Inject
	JoinDAO dao;

	@Override
	public List<JoinDTO> listAll(String user_id) throws Exception {
		return dao.listAll(user_id);
	}

	@Override
	public void insertJoin(int meet_num, String user_id) throws Exception {
		System.out.println("JoinServiceImpl, insertJoin, meet_num:" + meet_num);
		System.out.println("JoinServiceImpl, insertJoin, user_id:" + user_id);
		dao.insertJoin(meet_num, user_id);
	}

	@Override
	public void update(int meet_num) throws Exception {
		dao.update(meet_num);
	}

	@Override
	public void deleteRequest(int join_idx) throws Exception {
		dao.deleteRequest(join_idx);
	}

	@Override
	public List<String> selectListByMeetNum(int meet_num) throws Exception {
		return dao.selectListByMeetNum(meet_num);
	}

	@Override
	public void updatePeopleNum(int meet_num) throws Exception {
		dao.updatePeopleNum(meet_num);
	}

	@Override
	public void updatePartner(int meet_num, String meet_partner) throws Exception {
		dao.updatePartnerInfo(meet_num, meet_partner);
	}
}
