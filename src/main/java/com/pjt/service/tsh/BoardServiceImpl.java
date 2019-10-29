package com.pjt.service.tsh;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pjt.util.ys.MediaUtils;
import com.pjt.util.ys.UploadFileUtils;
import com.pjt.domain.tsh.BoardVO;
import com.pjt.domain.tsh.Criteria;
import com.pjt.domain.tsh.SearchCriteria;
import com.pjt.persistence.tsh.BoardDAO;
import com.pjt.persistence.tsh.ReplyDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	BoardDAO dao;
	
	@Inject
	ReplyDAO replyDAO;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@Transactional
	@Override
	public void register(BoardVO vo) throws Exception {
		dao.create(vo);
		
		String[] files = vo.getFiles();
		
		if(files != null) {
			for(String file : files) {
				dao.addAttach(file);
			}
		}
	}
	
	@Transactional
	@Override
	public BoardVO read(Integer tbl_bno) throws Exception {
		dao.viewCnt(tbl_bno);
		return dao.read(tbl_bno);
	}

	@Transactional
	@Override
	public void modify(BoardVO vo) throws Exception {
		
		deleteLocalFiles(vo.getTbl_bno());
		
		dao.update(vo);
		int tbl_bno = vo.getTbl_bno();
		dao.deleteAttach(tbl_bno);
		
		String[] files = vo.getFiles();
		if (files != null) {
			for (String file : files) {
				dao.replaceAttach(file, tbl_bno);
			}
		}
	}
	
	@Transactional
	@Override
	public void remove(Integer tbl_bno) throws Exception {
		dao.deleteAttach(tbl_bno);
		dao.delete(tbl_bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}
	
	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public List<String> getAttach(int tbl_bno) throws Exception {
		return dao.getAttach(tbl_bno);
	}
	
	
	private void deleteLocalFiles(int tbl_bno) throws Exception {
		List<String> localFiles = dao.getAttach(tbl_bno);
		
		if (localFiles != null) {
			for (String fileName : localFiles) {
				MediaType mType = MediaUtils.getMediaType(
						MediaUtils.getFormatName(fileName));
				// 이미지라면 원본 이미지 삭제
				if (mType != null) {
					UploadFileUtils.deleteOriginalImage(uploadPath, fileName);
				}
				
				UploadFileUtils.deleteLocalFile(uploadPath, fileName);
			}
		}
	}

}
