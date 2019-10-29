package com.pjt.service.ys;

import java.util.List;

import com.pjt.domain.ys.CategoryVO;
import com.pjt.domain.ys.RequestMatchDTO;
import com.pjt.domain.ys.UserDTO;

public interface RandomMatchService {

	public List<CategoryVO> randomMatcPage() throws Exception;

	public List<UserDTO> getmatch(RequestMatchDTO id) throws Exception;
	
//	public void insertRandom(MeetVO vo) throws Exception;
}
