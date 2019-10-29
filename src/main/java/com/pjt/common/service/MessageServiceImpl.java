package com.pjt.common.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pjt.common.domain.MessageDTO;
import com.pjt.common.domain.MessageVO;
import com.pjt.common.persistence.MessageDAO;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Inject
	MessageDAO dao;
	
	@Override
	public MessageDTO select(int msg_num) throws Exception {
		return dao.select(msg_num);
	}

	@Override
	public void delete(int msg_num) throws Exception {
		dao.delete(msg_num);
	}

	@Override
	public void insert(MessageVO vo) throws Exception {
		dao.insert(vo);
	}

	@Override
	public List<MessageDTO> sendList(String user_id, int page) throws Exception {
		return dao.sendList(user_id, page);
	}

	@Override
	public List<MessageDTO> targetList(String user_id, int page) throws Exception {
		return dao.targetList(user_id, page);
	}

	@Override
	public int countTargetPage(String user_id) throws Exception {
		return dao.countTargetPage(user_id);
	}

	@Override
	public int countSenderPage(String user_id) throws Exception {
		return dao.countSenderPage(user_id);
	}

	@Override
	public void chkRead(int msg_num) throws Exception {
		dao.chkRead(msg_num);
	}

	@Override
	public Timestamp chkOpenDate(int msg_num) throws Exception {
		return dao.chkOpenDate(msg_num);
	}
	
}
