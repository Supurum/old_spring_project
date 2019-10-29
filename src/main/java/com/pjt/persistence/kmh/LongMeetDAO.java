package com.pjt.persistence.kmh;


import java.util.List;

import com.pjt.domain.kmh.Criteria;
import com.pjt.domain.kmh.MatchRegisterVO;
import com.pjt.domain.kmh.UserInfoDTO;

public interface LongMeetDAO {

	
	// 유저 정보 넣기 	
	public void RegisterCreate(MatchRegisterVO vo) throws Exception;
	
//	// 매칭 등록 회원 불러오기 	
//	public MatchRegisterVO read(Integer num) throws Exception;
	
	// 매칭 신청 후 유저 정보 업데이트 
	public void update(String user_id,String meet_partner,String meet_state)throws Exception;
	
	// 목록 - java.util.List

		public List<MatchRegisterVO> longUserList(int page) throws Exception;
		
		public int listCount()throws Exception;
		
		public  UserInfoDTO detailInfo(String user_id)throws Exception;

		
}
