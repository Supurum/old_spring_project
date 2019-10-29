package com.pjt.common.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pjt.common.domain.PartnerInfoDTO;
import com.pjt.common.service.PartnerInfoService;
import com.pjt.domain.th.Criteria;

@Controller
public class PartnerController {

	@Inject
	PartnerInfoService service;
	
	//유저 상세정보 페이지(매칭신청)
	@RequestMapping(value = "partnerInfo", method = RequestMethod.GET)
	public String userInfo(@RequestParam("user_id") String user_id, @RequestParam("category_name") String category_name, 
						  Criteria cri,Model model,HttpSession session) throws Exception{
		String sessionId = (String) session.getAttribute("id");
		if(sessionId == null || sessionId==""){
			return "redirect:/login";
		}
		PartnerInfoDTO dto = service.userInfo(user_id);
		model.addAttribute("page",cri.getPage());
		model.addAttribute("category_name",category_name);
		model.addAttribute("dto",dto);
		return "/partnerInfo";
	}
}
