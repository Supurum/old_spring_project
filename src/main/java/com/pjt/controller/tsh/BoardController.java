package com.pjt.controller.tsh;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pjt.domain.tsh.BoardVO;
import com.pjt.domain.tsh.PageMaker;
import com.pjt.domain.tsh.SearchCriteria;
import com.pjt.service.tsh.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
		
	@Inject
	BoardService service;
	
	// 글 등록 GET
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		
	}
	
	// 글 등록 POST
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo, RedirectAttributes rttr) throws Exception {
		service.register(vo);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/board/list";
	}
	
	// 글 조회
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("tbl_bno") int tbl_bno, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		BoardVO vo = service.read(tbl_bno);
		List<String> files = service.getAttach(vo.getTbl_bno());
		String[] strFiles = new String[files.size()];
		for (int i = 0; i < files.size(); i++) {
			strFiles[i] = files.get(i);
		}
		vo.setFiles(strFiles);
		model.addAttribute(vo);
	}
	
	// 글 수정
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modify(@RequestParam("tbl_bno") int tbl_bno, Model model, @ModelAttribute("cri") SearchCriteria cri) throws Exception {
		BoardVO vo = service.read(tbl_bno);
		model.addAttribute(vo);
	}
	
	// 글 수정 POST
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo, RedirectAttributes rttr, SearchCriteria cri) throws Exception {
		service.modify(vo);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/board/list";
	}
	
	// 글 삭제
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("tbl_bno") int tbl_bno, RedirectAttributes rttr, SearchCriteria cri) throws Exception {
		service.remove(tbl_bno);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/board/list";
	}
	
	// 글 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listAll(@RequestParam Map<String, Object> parameters, 
			SearchCriteria cri, Model model) throws Exception {
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		List<BoardVO> list = service.listSearch(cri);
		int totalCount = service.countPaging(cri);
		pageMaker.setTotalCount(totalCount);
		
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
	}
	
	// 첨부파일
	@RequestMapping(value = "/getAttach/{tbl_bno}", method = RequestMethod.GET)
	public List<String> getAttach(@PathVariable("tbl_bno") int tbl_bno) throws Exception {
		System.out.println("신호탐");
		return service.getAttach(tbl_bno);
	}
	
	
}
