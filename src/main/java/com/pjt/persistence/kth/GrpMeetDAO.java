package com.pjt.persistence.kth;

import java.util.List;

import com.pjt.domain.kth.GrpMeetVO;

public interface GrpMeetDAO {
	
	public GrpMeetVO select(Integer meet_num) throws Exception;
	
	public void insert(GrpMeetVO vo) throws Exception;
	
	public void update(GrpMeetVO vo) throws Exception;
	
	public void delete(Integer meet_num) throws Exception;
	
	public List<GrpMeetVO> listAll() throws Exception;
	
}
