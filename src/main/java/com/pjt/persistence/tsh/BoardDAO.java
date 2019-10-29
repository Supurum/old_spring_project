package com.pjt.persistence.tsh;

import java.util.List;

import com.pjt.domain.tsh.BoardVO;
import com.pjt.domain.tsh.Criteria;
import com.pjt.domain.tsh.SearchCriteria;

public interface BoardDAO {
	
	// 글 등록
	public void create(BoardVO vo) throws Exception;
	
	// 조회
	public BoardVO read(Integer tbl_bno) throws Exception;
	
	// 수정
	public void update(BoardVO vo) throws Exception;
	
	// 삭제
	public void delete(Integer tbl_bno) throws Exception;
	
	// 목록
	public List<BoardVO> listAll() throws Exception;
	
	// 페이징(목록)
	public List<BoardVO> listPage(int page) throws Exception;
	
	// 목록 - 크리테리아
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	// 게시글
	public int countPaging(Criteria cri) throws Exception;
	
	// 게시글 갯수 - 검색
	public int listSearchCount(SearchCriteria cri) throws Exception;
		
	// 게시글 목록 - 검색
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
	
	// 조회 수 증가
	public void viewCnt(int tbl_bno) throws Exception;
	
	// 댓글수
	public void updateReplyCnt(int tbl_bno, int amount) throws Exception;
	
	// 첨부파일 추가
	public void addAttach(String tbl_fullName) throws Exception;
	
	// 첨부파일 가져오는것
	public List<String> getAttach(int tbl_bno) throws Exception;
	
	// 첨부파일 삭제
	public void deleteAttach(int tbl_bno) throws Exception;
	
	// 첨부파일 바꾸기
	public void replaceAttach(String tbl_fullName, int tbl_bno) throws Exception;
}
