package com.pjt.persistence.kth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.domain.kth.Criteria;
import com.pjt.domain.kth.ListDTO;

@Repository
public class ListDAOImpl implements ListDAO {
	
	private static final String NAMESPACE = "mappers.listMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public ListDTO select(Integer meet_num) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".selectListOne", meet_num);
	}

	@Override
	public List<ListDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectList");
	}

	@Override
	public void updateState(Integer meet_num, String meet_state) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("meet_num", meet_num);
		paramMap.put("meet_state", meet_state);
		sqlSession.update(NAMESPACE + ".updateState", paramMap);		
	}

	@Override
	public List<ListDTO> listPage(int page) throws Exception {
		int startRow = ((page -1) * 6) + 1; // 7
		int endRow = (page * 6); // 12
		Map<String, Integer>paramMap = new HashMap<>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		return sqlSession.selectList(NAMESPACE + ".selectPage", paramMap);
	}

	@Override
	public List<ListDTO> listCri(Criteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".selectCri", cri);
	}

	@Override
	public int countPaging() throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countPaging");
	}
	
	@Override
	public int countPagingAll() throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countPagingAll");
	}

	@Override
	public List<ListDTO> listPageAll(int page) throws Exception {
		int startRow = ((page -1) * 6) + 1; // 7
		int endRow = (page * 6); // 12
		Map<String, Integer>paramMap = new HashMap<>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		return sqlSession.selectList(NAMESPACE + ".selectPageAll", paramMap);
	}

}
