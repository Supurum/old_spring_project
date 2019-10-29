package com.pjt.service.th;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pjt.dao.th.ShortMeetDAO;
import com.pjt.domain.th.MeetDTO;
import com.pjt.domain.th.Sub_Category_DTO;
@Service
public class ShortMeetServiceImple implements ShortMeetService {
	@Inject
	ShortMeetDAO dao;

	@Override
	public List<MeetDTO> selectAll() throws Exception {
		return dao.selectAll();
	}
	@Override
	public List<MeetDTO> select(int page,String category_name) throws Exception {
		return dao.select(page,category_name);
	}
	@Override
	public void meetIng(String user_id, String meet_partner) throws Exception {
		dao.meetIng(user_id, meet_partner);
	}
	@Override
	public List<MeetDTO> listPage(int page) throws Exception {
		return dao.listPage(page);
	}
	@Override
	public int listCount() throws Exception {
		return dao.listCount();
	}
	@Override
	public int listCountOne(String category_name) throws Exception {
		return dao.listCountOne(category_name);
	}
	@Override
	public List<Sub_Category_DTO> sub_category() throws Exception {
		return dao.sub_category();
	}

}
