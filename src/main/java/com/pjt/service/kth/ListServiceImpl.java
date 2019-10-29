package com.pjt.service.kth;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pjt.domain.kth.Criteria;
import com.pjt.domain.kth.ListDTO;
import com.pjt.persistence.kth.ListDAO;

@Service
public class ListServiceImpl implements ListService {
	
	@Inject
	ListDAO dao;
	
	@Override
	public ListDTO select(Integer meet_num) throws Exception {
		return dao.select(meet_num);
	}

	@Override
	public List<ListDTO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public void updateState(Integer meet_num, String meet_state) throws Exception {
		dao.updateState(meet_num, meet_state);
	}

	@Override
	public List<ListDTO> listPage(int page) throws Exception {
		return dao.listPage(page);
	}

	@Override
	public List<ListDTO> listCri(Criteria cri) throws Exception {
		return dao.listCri(cri);
	}

	@Override
	public int countPaging() throws Exception {
		return dao.countPaging();
	}

	@Override
	public int countPagingAll() throws Exception {
		return dao.countPagingAll();
	}
	
	@Override
	public List<ListDTO> listPageAll(int page) throws Exception {
		return dao.listPageAll(page);
	}

}
