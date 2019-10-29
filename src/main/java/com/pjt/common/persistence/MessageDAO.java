package com.pjt.common.persistence;

import java.sql.Timestamp;
import java.util.List;

import com.pjt.common.domain.MessageDTO;
import com.pjt.common.domain.MessageVO;

public interface MessageDAO {
	
	public List<MessageDTO> sendList(String user_id, int page) throws Exception;
	
	public List<MessageDTO> targetList(String user_id, int page) throws Exception;
	
	public MessageDTO select(int msg_num) throws Exception;
	
	public void delete(int msg_num) throws Exception;
	
	public void insert(MessageVO vo) throws Exception;
	
	public int countTargetPage(String user_id) throws Exception;
	
	public int countSenderPage(String user_id) throws Exception;
	
	public void chkRead(int msg_num) throws Exception;
	
	public Timestamp chkOpenDate(int msg_num) throws Exception;
}
