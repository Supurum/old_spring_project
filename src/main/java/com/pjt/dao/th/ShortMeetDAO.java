package com.pjt.dao.th;

import java.util.List;

import com.pjt.domain.th.MeetDTO;
import com.pjt.domain.th.Sub_Category_DTO;

public interface ShortMeetDAO {
	//전체목록뽑아오기
	public List<MeetDTO> selectAll() throws Exception;
	//페이지처리된서브목록뽑아오기
	public List<MeetDTO> select(int page,String category_name) throws Exception;
	//매칭완료누르면 미팅중으로 변경하기
	public void meetIng(String user_id,String meet_partner) throws Exception;
	public List<MeetDTO> listPage(int page) throws Exception;
	public int listCount() throws Exception;
	public int listCountOne(String category_name) throws Exception;
	public List<Sub_Category_DTO> sub_category() throws Exception;
}
