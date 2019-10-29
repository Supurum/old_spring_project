package com.pjt.persistence.tsh;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.domain.tsh.Criteria;
import com.pjt.domain.tsh.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	private static final String NAMESPACE = "mappers.replyMapper";
	
	@Inject
	SqlSession sqlsession;

	@Override
	public List<ReplyVO> list(Integer re_bno) throws Exception {
		return sqlsession.selectList(NAMESPACE + ".list", re_bno);
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		sqlsession.insert(NAMESPACE + ".create", vo);
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		sqlsession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public void delete(Integer re_rno) throws Exception {
		sqlsession.delete(NAMESPACE + ".delete", re_rno);
	}

	@Override
	public List<ReplyVO> listPage(Integer re_bno, Criteria cri) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("re_bno", re_bno);
		paramMap.put("cri", cri);
		List<ReplyVO> list =  sqlsession.selectList(NAMESPACE + ".listPage", paramMap);
		System.out.println("ReplyDAOImpl, listPage, list:" + list);
		return list;
	}

	@Override
	public int count(Integer re_bno) throws Exception {
		return sqlsession.selectOne(NAMESPACE + ".count", re_bno);
	}

	@Override
	public int getBno(int re_rno) throws Exception {
		return sqlsession.selectOne(NAMESPACE + ".getBno", re_rno);
	}
	
}
