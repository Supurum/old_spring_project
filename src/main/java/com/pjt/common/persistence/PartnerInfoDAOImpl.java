package com.pjt.common.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.common.domain.PartnerInfoDTO;

@Repository
public class PartnerInfoDAOImpl implements PartnerInfoDAO {
	private static final String NAMESPACE = "mappers.partnerInfoMapper";
	
	@Inject
	SqlSession session;
	
	@Override
	public PartnerInfoDTO userInfo(String user_id) throws Exception {
		return session.selectOne(NAMESPACE+".selectOne",user_id);
	}

	@Override
	public List<PartnerInfoDTO> partnerInfo(int meet_num, int startRow, int endRow) throws Exception {
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("meet_num", meet_num);
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
//		System.out.println("PartnerInfoDAOImpl, meet_num:" + meet_num);
//		System.out.println("PartnerInfoDAOImpl, startRow:" + startRow);
//		System.out.println("PartnerInfoDAOImpl, endRow:" + endRow);
		List<PartnerInfoDTO> list = session.selectList(NAMESPACE + ".partnerList", paramMap);
//		System.out.println("PartnerInfoDAOImpl, list:" + list);
				
		return list;
	}

	@Override
	public PartnerInfoDTO writerInfo(int meet_num) throws Exception {
		return session.selectOne(NAMESPACE + ".selectWriter", meet_num);
	}

}
