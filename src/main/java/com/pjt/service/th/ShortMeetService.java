package com.pjt.service.th;

import java.util.List;

import com.pjt.domain.th.MeetDTO;
import com.pjt.domain.th.Sub_Category_DTO;

public interface ShortMeetService {

	public List<MeetDTO> selectAll() throws Exception;
	public void meetIng(String user_id,String meet_partner) throws Exception;
	public List<MeetDTO> listPage(int page) throws Exception;
	public int listCount() throws Exception;
	public int listCountOne(String category_name) throws Exception;
	public List<MeetDTO> select(int page, String category_name) throws Exception;
	public List<Sub_Category_DTO> sub_category() throws Exception;
}
