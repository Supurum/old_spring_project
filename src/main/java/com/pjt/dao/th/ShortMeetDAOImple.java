package com.pjt.dao.th;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.domain.th.MeetDTO;
import com.pjt.domain.th.Sub_Category_DTO;
@Repository
public class ShortMeetDAOImple implements ShortMeetDAO {
	
	private static final String NAMESPACE = "mappers.shortmeetMapper";
	
	@Inject
	SqlSession session;
	
	@Override
	public List<MeetDTO> selectAll() throws Exception {
		return session.selectList(NAMESPACE+".selectAll");
	}
	// 목록 6개씩만뽑아가져오기
	@Override
	public List<MeetDTO> select(int page, String category_name) throws Exception {
		int startRow = ((page - 1) * 6) + 1;
		int endRow = startRow + 5;
		Map<Object, Object> paramMap = new HashMap<>();
		paramMap.put("category_name", category_name);
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		return session.selectList(NAMESPACE+".listOne", paramMap);
	}

	@Override
	public void meetIng(String user_id,String meet_partner) throws Exception {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("user_id", user_id);
		paramMap.put("meet_partner", meet_partner);
		session.update(NAMESPACE+".ing",paramMap);
	}
	//페이지처리
	@Override
	public List<MeetDTO> listPage(int page) throws Exception {
		int startRow = ((page - 1) * 6) + 1;
		int endRow = 0;
		if(startRow == 1){
			endRow = 7;
		} else{
			endRow = startRow + 5;
		}
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		return session.selectList(NAMESPACE+".listPage", paramMap);
	}

	@Override
	public int listCount() throws Exception {
		return session.selectOne(NAMESPACE+".listCount");
	}

	@Override
	public int listCountOne(String category_name) throws Exception {
		return session.selectOne(NAMESPACE+".listCountOne",category_name);
	}
	@Override
	public List<Sub_Category_DTO> sub_category() throws Exception {
		return session.selectList(NAMESPACE+".sub_category");
	}
}
