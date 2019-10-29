package com.pjt.common.persistence;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.common.domain.MessageDTO;
import com.pjt.common.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {
	
	private static final String NAMESPACE = "mappers.messageMapper";
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public MessageDTO select(int msg_num) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectMessage", msg_num);
	}

	@Override
	public void delete(int msg_num) throws Exception {
		sqlSession.delete(NAMESPACE + ".deleteMessage", msg_num);
	}

	@Override
	public void insert(MessageVO vo) throws Exception {
		sqlSession.insert(NAMESPACE + ".insertMessage", vo);
	}

	@Override
	public List<MessageDTO> sendList(String user_id, int page) throws Exception {
		int startRow = ((page -1) * 10) + 1;
		int endRow = (page * 10); 
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("user_id", user_id);
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		return sqlSession.selectList(NAMESPACE + ".selectSendList", paramMap);
	}

	@Override
	public List<MessageDTO> targetList(String user_id, int page) throws Exception {
		int startRow = ((page -1) * 10) + 1;
		int endRow = (page * 10); 
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("user_id", user_id);
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		return sqlSession.selectList(NAMESPACE + ".selectTargetList", paramMap);
	}

	@Override
	public int countTargetPage(String user_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countTargetPage", user_id);
	}

	@Override
	public int countSenderPage(String user_id) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countSenderPage", user_id);
	}

	@Override
	public void chkRead(int msg_num) throws Exception {
		sqlSession.update(NAMESPACE + ".chkRead", msg_num);
	}

	@Override
	public Timestamp chkOpenDate(int msg_num) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".chkOpenDate", msg_num);
	}

}
