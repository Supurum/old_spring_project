package com.pjt.persistence.kth;

import java.util.List;

import com.pjt.domain.kth.Criteria;
import com.pjt.domain.kth.ListDTO;

public interface ListDAO {
	public final static int GRP_STATUS_FINISH = 1;
	public final static int GRP_STATUS_ING = 2;
	
	public ListDTO select(Integer meet_num) throws Exception;
	
	public List<ListDTO> listAll() throws Exception;
	
	public void updateState(Integer meet_num, String meet_state) throws Exception;
	
	public List<ListDTO> listPage(int page) throws Exception;
	
	public List<ListDTO> listPageAll(int page) throws Exception;
	
	public List<ListDTO> listCri(Criteria cri) throws Exception;
	
	public int countPaging() throws Exception;
	
	public int countPagingAll() throws Exception;
	
}
