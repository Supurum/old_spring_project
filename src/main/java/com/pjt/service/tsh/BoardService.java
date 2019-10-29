package com.pjt.service.tsh;

import java.util.List;

import com.pjt.domain.tsh.BoardVO;
import com.pjt.domain.tsh.Criteria;
import com.pjt.domain.tsh.SearchCriteria;

public interface BoardService {
	
	public static final int REPLY_AMOUNT = 1;

	// 글 등록
	public void register(BoardVO vo) throws Exception;
	
	// 조회
	public BoardVO read(Integer tbl_bno) throws Exception;
	
	// 수정
	public void modify(BoardVO vo) throws Exception;
	
	// 삭제
	public void remove(Integer tbl_bno) throws Exception;
	
	// 글 목록
	public List<BoardVO> listAll() throws Exception;
	
	// 목록 크리테리아
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	// 게시글
	public int countPaging(Criteria cri) throws Exception;
	
	// 글 목록 - 검색
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
	
	// 게시글 갯수 - 검색
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	// 첨부파일 가져오는것
	public List<String> getAttach(int tbl_bno) throws Exception;
}
