package com.pjt.common.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pjt.common.domain.MeetRegiVO;
import com.pjt.common.service.MeetRegiService;


@Controller
public class MeetRegiController {
	
	@Inject
	MeetRegiService service;
	
	@RequestMapping(value="/meetRegi", method = RequestMethod.GET)
	public void meetRegi(){
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/meetRegiCommit", method = RequestMethod.POST)
	public ResponseEntity<String> meetRegiCommit(HttpSession session,MeetRegiVO vo){
		
		ResponseEntity<String> entity = null;
		vo.setMeet_writer((String)session.getAttribute("id"));
		try {
			int count = service.waitRegiOverRapChk(vo.getMeet_writer());
			
			if(count == 0){
				service.waitRegi(vo);	
				entity = new ResponseEntity<String>(
					"SUCESSS", HttpStatus.OK);
			}else if(count > 0){
				entity = new ResponseEntity<String>("FAIL",HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(
					e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
}
