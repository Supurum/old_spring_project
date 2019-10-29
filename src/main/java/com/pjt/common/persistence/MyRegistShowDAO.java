package com.pjt.common.persistence;

import java.util.List;

import com.pjt.common.domain.MyRegistShowDTO;
import com.pjt.common.domain.MyRequestingInfoDTO;

public interface MyRegistShowDAO {
	// 내가 등록한 것 들 보기 (지역, 술, 만남종류 ) 
	public  MyRegistShowDTO myRegistShow(String user_id)throws Exception;
	
		// 수정
		public void completeMatching(String user_id) throws Exception;
		
		// 삭제
//		public void cancelMatching(Integer bno) throws Exception;
		
		// 수락 버튼 눌렀을때 파트너 정보 넣기 
		public void updatePartnerInfo(int meet_num, String meet_partner)throws Exception;
		
		// 내가 신청한 현황 가지고 오기(보기)
		List<MyRequestingInfoDTO> myRequestingShow(String user_id) throws Exception;
}
