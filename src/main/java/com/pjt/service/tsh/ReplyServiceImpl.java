package com.pjt.service.tsh;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pjt.service.tsh.ReplyService;
import com.pjt.domain.tsh.Criteria;
import com.pjt.domain.tsh.ReplyVO;
import com.pjt.persistence.tsh.BoardDAO;
import com.pjt.persistence.tsh.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	ReplyDAO dao;
	
	@Inject
	BoardDAO boardDAO;

	@Override
	public List<ReplyVO> listReply(Integer re_bno) throws Exception {
		return dao.list(re_bno);
	}

	@Transactional
	@Override
	public void addReply(ReplyVO vo) throws Exception {
		dao.create(vo);
		boardDAO.updateReplyCnt(vo.getRe_bno(), ReplyService.REPLY_AMOUNT);
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		dao.update(vo);
	}

	@Transactional
	@Override
	public void removeReply(Integer re_rno) throws Exception {
		int tbl_bno = dao.getBno(re_rno);
		dao.delete(re_rno);
		boardDAO.updateReplyCnt(tbl_bno, -1);
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer re_bno, Criteria cri) throws Exception {
		return dao.listPage(re_bno, cri);
	}

	@Override
	public int count(Integer re_bno) throws Exception {
		return dao.count(re_bno);
	}
	
}