package com.pjt.service.kmh;


import java.util.List;

import com.pjt.domain.kmh.Criteria;
import com.pjt.domain.kmh.MatchRegisterVO;

public interface MatchRegisterService {

	
	
	// 글 등록
		public void regist(MatchRegisterVO vo) throws Exception;
//	// 글 읽기
//		public MatchRegisterVO read(Integer num) throws Exception;

		public  List<MatchRegisterVO>listPage(int page)throws  Exception;
		
		
		public int listCount()throws Exception;


		
}
