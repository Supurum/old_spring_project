package com.pjt.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pjt.common.persistence.CommonDAO;
import com.pjt.domain.ys.GenderVO;
import com.pjt.domain.ys.LocVO;
import com.pjt.domain.ys.MainCategoryVO;
import com.pjt.domain.ys.MasterMeetVO;
import com.pjt.domain.ys.MeetFlapper;
import com.pjt.domain.ys.ReligionVO;
import com.pjt.domain.ys.Statistical;

@Service
public class CommonServiceImpl implements CommonService {
	
	@Inject
	CommonDAO dao;

	@Override
	public List<MainCategoryVO> getMainMenuList() throws Exception {
		List<MainCategoryVO> mainList = dao.getMainMenuList();
		return mainList;
	}
	
	@Override
	public List<GenderVO> getGenderList() throws Exception {
		List<GenderVO> genderList=dao.getGenderList();
		return genderList;
	}

	@Override
	public List<LocVO> getLocList() throws Exception {
		List<LocVO> locList=dao.getLocList();
		return locList;
	}

	@Override
	public List<ReligionVO> getReligionList() throws Exception {
		List<ReligionVO> religionList=dao.getReligionList();
		return religionList;
	}
	//메인 페이지 
	@Override
	public Map<String,List<MeetFlapper>> getLastRegistList() throws Exception {
		return dao.getLastRegistList();
	}

	@Override
	public List<MeetFlapper> getLastMatchedList() throws Exception {
		return dao.getLastMatchedList();
	}

	

	@Override
	public int getTotalMeetCount() throws Exception {
		return dao.getTotalMeetCount();
	}

	@Override
	public int getMemberCount() throws Exception {
		return dao.getMemberCount();
	}

	@Override
	public List<MasterMeetVO> getMeetList() throws Exception {
		return dao.getMeetList();
	}
	
	@Override
	public int getTodayMeetCount() throws Exception {
		return dao.getTodayMeetCount();
	}

	private String getDate(int i) throws Exception{
		return dao.getDate(i);
	}

	private int getTodayLogin(int i) throws Exception {
		return dao.getTodayLogin(i);
	}
	
	private int getTodayLoginMember(int i) throws Exception {
		return dao.getTodayLoginMember(i);
	}

	private int getTodayMeetCount(int i) throws Exception {
		return dao.getTodayMeetCount(i);
	}
	

	@Override
	public List<Statistical> getStatisticalList() throws Exception {
		List<Statistical> mlist=new ArrayList<>();
		for(int i=0; i<15; i++){
			String date=getDate(i); 
			int todayLogin=getTodayLogin(i);
			int todayLoginMember=getTodayLoginMember(i);
			int todayMeet=getTodayMeetCount(i);
			Statistical s = new Statistical(date,todayLoginMember,todayLogin,todayMeet);
			mlist.add(s);
		}
		return mlist;
	}

	@Override
	public int getGenderCount(int gender) throws Exception {
		return dao.getGenderCount(gender);
	}

	@Override
	public int getMeetStatusCount(char c) {
		return dao.getMeetStatusCount(c);
	}
//
//	@Override
//	public List<LongMeet> getLongMeetList() throws Exception {
//		return dao.getLongMeetList();
//	}

}
