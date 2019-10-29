package com.pjt.persistence.tsh;

import java.util.List;

import com.pjt.domain.tsh.Criteria;
import com.pjt.domain.tsh.ReplyVO;

public interface ReplyDAO {
	
	// 목록
	public List<ReplyVO> list(Integer re_bno) throws Exception;
	
	// 추가
	public void create(ReplyVO vo) throws Exception;
	
	// 수정
	public void update(ReplyVO vo) throws Exception;
	
	// 삭제
	public void delete(Integer re_rno) throws Exception;
	
	// 페이징
	public List<ReplyVO> listPage(Integer re_bno, Criteria cri) throws Exception;
	
	// 갯수
	public int count(Integer re_bno) throws Exception;
	
	// 글 번호
	public int getBno(int re_rno) throws Exception;
	
}
