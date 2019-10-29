package com.pjt.service.ys;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pjt.common.persistence.CommonDAO;
import com.pjt.domain.ys.CategoryVO;
import com.pjt.domain.ys.MeetUpdateDTO;
import com.pjt.domain.ys.MeetVO;
import com.pjt.domain.ys.PointVO;
import com.pjt.domain.ys.RequestMatchDTO;
import com.pjt.domain.ys.UserDTO;
import com.pjt.exception.ys.MyException;
import com.pjt.persistence.ys.RandomMatchDAO;

@Service
public class RandomMatchServiceImpl implements RandomMatchService {

	@Inject
	RandomMatchDAO dao;
	CommonDAO cdao;
	
	@Override
	public List<CategoryVO> randomMatcPage() throws Exception {
		List<CategoryVO> categoryList= dao.readCategory();
		
		return categoryList;
	}
	@Transactional
	@Override
	public List<UserDTO> getmatch(RequestMatchDTO rmvo) throws Exception {
		List<UserDTO> returnList=new ArrayList<>();//두사람의 정보를 담아 돌려줄 객체
		returnList.add(dao.readUserInfo(rmvo.getId()));//자신의 정보
		rmvo.setName(returnList.get(0).getUser_name());
		rmvo.setAge(returnList.get(0).getUser_age());
		rmvo.setUser_gender(returnList.get(0).getUser_gender());
		
		if(returnList.get(0)==null){throw new MyException("매칭 요청자의 정보를 가져오지 못했습니다.",1);}
		List<MeetVO> meetList=dao.getSelectMeetWriterList(rmvo);//매칭조건에 맞는 만남의 정보
		if(meetList==null||meetList.size()==0){throw new MyException("적합한 매칭이 없습니다.",2);}
		int select=(int)(Math.random()*meetList.size());
		returnList.add(dao.readUserInfo(meetList.get(select).getMeet_writer()));//상대방 정보
		if(returnList.get(1)==null){throw new MyException("매칭 상대의 정보를 가져오지 못했습니다.",3);}
		MeetUpdateDTO muvo=new MeetUpdateDTO(meetList.get(select).getMeet_num(), returnList.get(0).getUser_id());
		
		PointVO pvo= new PointVO(returnList.get(0).getUser_id(),"REQUEST MATCH","출석보상");
		int row=cdao.updatePoint(pvo);
		if(row==1){
			row=-1;
			
			row=cdao.writePointTBook(pvo);
		}
		
		dao.matchUpdate(muvo);
		for(UserDTO vo:returnList){
			System.out.println(vo.toString());
		}
		return returnList;
	}
//	@Override
//	public void insertRandom(MeetVO vo) throws Exception {
//		dao.insertRandom(vo);
//	}
}
