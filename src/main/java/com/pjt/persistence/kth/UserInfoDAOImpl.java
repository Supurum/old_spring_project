package com.pjt.persistence.kth;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.domain.kth.UserInfoDTO;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO{
	
	private static final String NAMESPACE = "mappers.userInfoMapper";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public UserInfoDTO select(Integer meet_num) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectWriter", meet_num);
	}
	
}
