package com.pjt.common.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.common.domain.MeetRegiVO;

@Repository
public class MeetRegiDAOImpl implements MeetRegiDAO {
	private static final String NAMESPACE = "mappers.meetRegiMapper";
	
	@Inject
	SqlSession session;
	
	@Override
	public void waitRegi(MeetRegiVO vo) throws Exception {
		System.out.println("waitRegi,vo:" + vo);
		session.insert(NAMESPACE+".insert", vo);
	}

	@Override
	public int waitRegioverRapChk(String meet_writer) throws Exception {
		return session.selectOne(NAMESPACE+".overRapChk",meet_writer);
	}

}
