package com.pjt.persistence.tsh;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pjt.domain.tsh.BoardVO;
import com.pjt.domain.tsh.Criteria;
import com.pjt.domain.tsh.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final String NAMESPACE = "mappers.boardMapper";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void create(BoardVO vo) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", vo);
	}
	
	@Override
	public BoardVO read(Integer tbl_bno) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", tbl_bno);
		
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public void delete(Integer tbl_bno) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", tbl_bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}
	
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listCriteria", cri);
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		int startRow = ((page - 1) * 10) + 1;
		int endRow = page * 10;
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", endRow);
		return sqlSession.selectList(NAMESPACE + ".listPage", paramMap);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countPaging", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".listSearchCount", cri);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listSearch", cri);
	}

	@Override
	public void viewCnt(int tbl_bno) throws Exception {
		sqlSession.update(NAMESPACE + ".viewCnt", tbl_bno);
	}

	@Override
	public void updateReplyCnt(int tbl_bno, int amount) throws Exception {
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("amount", amount);
		paramMap.put("tbl_bno", tbl_bno);
		sqlSession.update(NAMESPACE + ".updateReplyCnt", paramMap);
	}

	@Override
	public void addAttach(String tbl_fullName) throws Exception {
		sqlSession.insert(NAMESPACE + ".addAttach", tbl_fullName);
	}

	@Override
	public List<String> getAttach(int tbl_bno) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".getAttach", tbl_bno);
	}

	@Override
	public void deleteAttach(int tbl_bno) throws Exception {
		sqlSession.delete(NAMESPACE + ".deleteAttach", tbl_bno);
		
	}

	@Override
	public void replaceAttach(String tbl_fullName, int tbl_bno) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("tbl_fullName", tbl_fullName);
		paramMap.put("tbl_bno", tbl_bno);
		sqlSession.insert(NAMESPACE + ".replaceAttach", paramMap);
		
	}

}
