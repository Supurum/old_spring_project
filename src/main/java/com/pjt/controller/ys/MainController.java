package com.pjt.controller.ys;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pjt.common.service.CommonService;
import com.pjt.domain.ys.MeetFlapper;

@Controller
public class MainController {
	@Inject
	CommonService service;
	
	@RequestMapping(value = "/intro", method = RequestMethod.GET)
	public String introPage(Locale locale, Model model) throws Exception{
		
		Map<String,List<MeetFlapper>> map=service.getLastRegistList();
		List<MeetFlapper>wlist=map.get("wlist");
		System.out.println("_________________"+wlist.size());
		List<MeetFlapper>mlist=map.get("mlist");
		List<MeetFlapper> lastMatchedList = service.getLastMatchedList();
		int todayMeetCount = service.getTodayMeetCount();
		int TotalMeetCount = service.getTotalMeetCount();
//		List<LongMeet> longMeetList = service.getLongMeetList();
		int memberCount = service.getMemberCount();
		
		model.addAttribute("wlist", wlist);
		model.addAttribute("mlist", mlist);
		model.addAttribute("lastMatchedList", lastMatchedList);
		
		model.addAttribute("wlistsize", wlist.size());
		model.addAttribute("mlistsize", mlist.size());
		model.addAttribute("lastMatchedListsize", lastMatchedList.size());
		
		model.addAttribute("todayMeetCount", todayMeetCount);
		model.addAttribute("TotalMeetCount", TotalMeetCount);
		model.addAttribute("memberCount", memberCount);
		
//		model.addAttribute("longMeetList", longMeetList);
//		model.addAttribute("memberCount", memberCount);
		
		return "intro";
	}
}