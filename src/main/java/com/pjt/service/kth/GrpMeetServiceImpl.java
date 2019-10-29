package com.pjt.service.kth;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pjt.domain.kth.GrpMeetVO;
import com.pjt.persistence.kth.GrpMeetDAO;

@Service
public class GrpMeetServiceImpl implements GrpMeetService {
	
	@Inject
	private GrpMeetDAO dao;
	
	@Override
	public GrpMeetVO select(Integer meet_num) throws Exception {
		return dao.select(meet_num);
	}

	@Override
	public void insert(GrpMeetVO vo) throws Exception {
		dao.insert(vo);
	}

	@Override
	public void update(GrpMeetVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void delete(Integer meet_num) throws Exception {
		dao.delete(meet_num);
	}

	@Override
	public List<GrpMeetVO> listAll() throws Exception {
		return dao.listAll();
	}

}
