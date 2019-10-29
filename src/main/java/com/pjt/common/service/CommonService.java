package com.pjt.common.service;

import java.util.List;
import java.util.Map;

import com.pjt.domain.ys.GenderVO;
import com.pjt.domain.ys.LocVO;
import com.pjt.domain.ys.MainCategoryVO;
import com.pjt.domain.ys.MasterMeetVO;
import com.pjt.domain.ys.MeetFlapper;
import com.pjt.domain.ys.ReligionVO;
import com.pjt.domain.ys.Statistical;

public interface CommonService {
	List<MainCategoryVO> getMainMenuList() throws Exception;
	List<GenderVO> getGenderList() throws Exception;
	List<LocVO> getLocList() throws Exception;
	List<ReligionVO> getReligionList() throws Exception;
	Map<String,List<MeetFlapper>> getLastRegistList() throws Exception;
	List<MeetFlapper> getLastMatchedList() throws Exception;
	int getTotalMeetCount() throws Exception;
	int getMemberCount() throws Exception;
	List<MasterMeetVO> getMeetList() throws Exception;
	int getTodayMeetCount() throws Exception;
	List<Statistical>getStatisticalList() throws Exception;
	int getGenderCount(int gender) throws Exception;
	int getMeetStatusCount(char c);
//	List<LongMeet> getLongMeetList() throws Exception;
}
