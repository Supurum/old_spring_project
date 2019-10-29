package com.pjt.common.persistence;

import java.util.List;
import java.util.Map;

import com.pjt.domain.ys.GenderVO;
import com.pjt.domain.ys.LocVO;
import com.pjt.domain.ys.LogVO;
import com.pjt.domain.ys.LoginDTO;
import com.pjt.domain.ys.MainCategoryVO;
import com.pjt.domain.ys.MasterMeetVO;
import com.pjt.domain.ys.MeetFlapper;
import com.pjt.domain.ys.PointVO;
import com.pjt.domain.ys.ReligionVO;

public interface CommonDAO {
	public String login(LoginDTO dto) throws Exception;
	
	public List<MainCategoryVO> getMainMenuList() throws Exception;
	
	public List<GenderVO>  getGenderList() throws Exception ;

	public List<LocVO> getLocList() throws Exception ;

	public List<ReligionVO> getReligionList() throws Exception;
	
	public Map<String,List<MeetFlapper>> getLastRegistList() throws Exception;
	
	public List<MeetFlapper> getLastMatchedList() throws Exception;

	int getTodayMeetCount() throws Exception;
	
	public int getTotalMeetCount() throws Exception;
	
	public int getMemberCount() throws Exception;

	public List<MasterMeetVO> getMeetList()throws Exception;

	public String getDate(int i);
	
	public int getTodayLogin(int i)throws Exception;
	
	public int getTodayLoginMember(int i)throws Exception;
	
	public int getTodayMeetCount(int i) throws Exception;

	public int getGenderCount(int gender) throws Exception;
	
	public int checkLoginToday(String id) throws Exception;
	
	public int updatePoint(PointVO vo) throws Exception;
	
	public int writePointTBook(PointVO vo);
	
	public int writeLog(LogVO lvo);

	public int getMeetStatusCount(char c); 

//	public List<LongMeet> getLongMeetList() throws Exception;
}
