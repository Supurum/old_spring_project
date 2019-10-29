package com.pjt.service.tsh;

import java.util.List;

import com.pjt.domain.tsh.Criteria;
import com.pjt.domain.tsh.ReplyVO;

public interface ReplyService {
	
	public static final int REPLY_AMOUNT = 1;
	
	// 목록
	public List<ReplyVO> listReply(Integer re_bno) throws Exception;
		
	// 추가
	public void addReply(ReplyVO vo) throws Exception;
		
	// 수정
	public void modifyReply(ReplyVO vo) throws Exception;
		
	// 삭제
	public void removeReply(Integer re_rno) throws Exception;
	
	// 페이징
	public List<ReplyVO> listReplyPage(Integer re_bno, Criteria cri) throws Exception;
	
	// 댓글 갯수
	public int count(Integer re_bno) throws Exception;
}
