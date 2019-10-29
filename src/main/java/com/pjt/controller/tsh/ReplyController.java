package com.pjt.controller.tsh;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pjt.domain.tsh.Criteria;
import com.pjt.domain.tsh.PageMaker;
import com.pjt.domain.tsh.ReplyVO;
import com.pjt.service.tsh.ReplyService;


@Controller
@RequestMapping("/board")
public class ReplyController {
	
	@Inject
	ReplyService service;
	
	// 추가
	@RequestMapping(value = "/replies", method = RequestMethod.GET)
	public ResponseEntity<String> register(ReplyVO vo) {
		
		System.out.println("replies:" + vo);
		System.out.println("bno" + vo.getRe_bno());
		
		ResponseEntity<String> entity = null;
		try {
			service.addReply(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
	
	// 수정
	@RequestMapping(value = "/replies/{re_rno}", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable("re_rno") int re_rno, @RequestBody ReplyVO vo) {
		
		ResponseEntity<String> entity = null;
		try {
			vo.setRe_rno(re_rno);
			service.modifyReply(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	// 삭제
	@RequestMapping(value = "/replies/{re_rno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("re_rno") Integer re_rno) {
		ResponseEntity<String> entity = null;
		try {
			service.removeReply(re_rno);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 페이징
	@RequestMapping(value = "/replies/{re_bno}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(
			@PathVariable("re_bno") Integer re_bno, @PathVariable("page") Integer page, Model model) {
		ResponseEntity<Map<String, Object>> entity = null;
		System.out.println("신호탐");
		try {
			Criteria cri = new Criteria();
			cri.setPage(page);
			List<ReplyVO> list = service.listReplyPage(re_bno, cri);
			System.out.println("------------------list:" + list);
			System.out.println("------------------re_bno:" + re_bno);
			System.out.println("------------------cri:" + cri);
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			int totalCount = service.count(re_bno);
			pageMaker.setTotalCount(totalCount);
			
			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			map.put("pageMaker", pageMaker);
			model.addAttribute("map", map);
			
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
