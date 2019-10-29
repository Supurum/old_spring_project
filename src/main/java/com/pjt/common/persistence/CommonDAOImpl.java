package com.pjt.common.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.domain.ys.GenderVO;
import com.pjt.domain.ys.LocVO;
import com.pjt.domain.ys.LogVO;
import com.pjt.domain.ys.LoginDTO;
import com.pjt.domain.ys.MainCategoryVO;
import com.pjt.domain.ys.MasterMeetVO;
import com.pjt.domain.ys.MeetFlapper;
import com.pjt.domain.ys.PointVO;
import com.pjt.domain.ys.ReligionVO;

@Repository
public class CommonDAOImpl implements CommonDAO {

	private static final String NAMESPACE = "mappers.commonMapper";
	private static final String MASTERNAMESPACE = "mappers.masterMapper";
	@Inject
	private SqlSession sqlSession;
	

	//로그인
	@Override
	public String login(LoginDTO dto){
		String id=sqlSession.selectOne(NAMESPACE+".login", dto);
		System.out.println("id="+id);
		return id;
	}
	//로그인-기록
	@Override
	public int writeLog(LogVO lvo) {
		return sqlSession.insert(NAMESPACE+".writeLog", lvo);
	}
	//로그인-금일 로그인 여부 확인
	@Override
	public int checkLoginToday(String id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+".checkLoginToday",id);
	}
	//포인트 변경
	@Override
	public int updatePoint(PointVO vo) throws Exception{
		return sqlSession.update(NAMESPACE+".updatePoint", vo);
	}
	//포인트 출납기록 !포인트 변경(updatePoint)후 반드시 트렌젝션으로 작업
	@Override
	public int writePointTBook(PointVO vo) {
		return sqlSession.insert(NAMESPACE+".writePointTBook", vo);
	}
	
	//메뉴 읽어오기
	@Override
	public List<MainCategoryVO> getMainMenuList() throws Exception {
		List<MainCategoryVO> mainList = sqlSession.selectList(NAMESPACE+".getMainMenuList");
		return mainList;
	}
	//성별 목록 읽어오기
	@Override
	public List<GenderVO>  getGenderList() throws Exception {
		List<GenderVO> genderList=sqlSession.selectList(NAMESPACE+".getGenderList");
		return genderList;
	}
	//지역 목록 읽어오기
	@Override
	public List<LocVO> getLocList() throws Exception {
		List<LocVO> locList=sqlSession.selectList(NAMESPACE+".getLocList");
		return locList;
	}
	//종교 목록 읽어오기
	@Override
	public List<ReligionVO> getReligionList() throws Exception {
		List<ReligionVO> religionList=sqlSession.selectList(NAMESPACE+".getReligionList");
		return religionList;
	}
	//Intro-최근 등록된 만남
	@Override
	public Map<String,List<MeetFlapper>> getLastRegistList() throws Exception {
		Map<String,List<MeetFlapper>> map=new HashMap<>();
		List<MeetFlapper> wlist = sqlSession.selectList(NAMESPACE+".LatestRegistration", 1);
		map.put("wlist", wlist);
		List<MeetFlapper> mlist = sqlSession.selectList(NAMESPACE+".LatestRegistration", 2);
		map.put("mlist", mlist);
		return map;
	}
	//Intro-최근 성사된 만남
	@Override
	public List<MeetFlapper> getLastMatchedList() throws Exception {
		List<MeetFlapper> list = sqlSession.selectList(NAMESPACE+".LatestAccomplishments");
		return list;
	}
	//Intro-오늘 만들어진 만남 수
	@Override
	public int getTodayMeetCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE+".TodayCreate");
	}
	//Intro-전체 만남 수
	@Override
	public int getTotalMeetCount() throws Exception {
		int i=sqlSession.selectOne(NAMESPACE+".TotalMeet");
		return i;
	}
	//Intro-회원 수
	@Override
	public int getMemberCount() throws Exception {
		int i=sqlSession.selectOne(NAMESPACE+".Members");
		return i;
	}

	//마스터 DAO로 옮겨야함
	@Override
	public List<MasterMeetVO> getMeetList() throws Exception {
		return sqlSession.selectList(MASTERNAMESPACE+".getMeetList");
	}
	
	@Override
	public String getDate(int i) {
		return sqlSession.selectOne(MASTERNAMESPACE+".getDate", i);
	}

	@Override
	public int getTodayLoginMember(int i) throws Exception {
		return sqlSession.selectOne(MASTERNAMESPACE+".getTodayLoginMember", i);
	}
	@Override
	public int getTodayLogin(int i) throws Exception {
		return sqlSession.selectOne(MASTERNAMESPACE+".getTodayLogin", i);
	}	
	@Override
	public int getTodayMeetCount(int i) throws Exception {
		return sqlSession.selectOne(MASTERNAMESPACE+".getTodayCreate", i);
	}

	@Override
	public int getGenderCount(int gender) throws Exception {
		return sqlSession.selectOne(MASTERNAMESPACE+".getGenderCount", gender);
	}
	@Override
	public int getMeetStatusCount(char c) {
		return sqlSession.selectOne(MASTERNAMESPACE+".getMeetStatusCount",c);
	}

//	//Intro-오래 만난 회원
//	@Override
//	public List<LongMeet> getLongMeetList() throws Exception {
//		List<LongMeet> list = sqlSession.selectList(NAMESPACE+".Long-termMeeting");
//		return list;
//	}
}
