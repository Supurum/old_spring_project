package com.pjt.controller.ys;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pjt.common.service.CommonService;
import com.pjt.domain.ys.CategoryVO;
import com.pjt.domain.ys.RequestMatchDTO;
import com.pjt.domain.ys.UserDTO;
import com.pjt.exception.ys.MyException;
import com.pjt.service.ys.RandomMatchService;
import com.pjt.service.ys.UserService;


@Controller
@RequestMapping(value="ys/random/*")
public class RandomMatchController {
	
	@Inject
	UserService uservice;
	@Inject
	RandomMatchService service;
	@Inject
	CommonService cservice;
	
	
	@RequestMapping(value="randommatch",method=RequestMethod.GET)
	public String randommatch(Model model) throws Exception{
		
		List<CategoryVO> categoryList = service.randomMatcPage();
		
//		model.addAttribute("categoryListLength", categoryList.size());
		model.addAttribute("categoryList", categoryList);
		System.out.println("------------categoryListSize:"+categoryList.size());
		return "/ys/random/randommatch";
	}
	@RequestMapping(value="randommatch",method=RequestMethod.POST)
	public String matchAction(RequestMatchDTO vo, Model model,HttpSession session) throws Exception{
		List<UserDTO> list=null;
		try{
			String id=(String)session.getAttribute("id");
			vo.setId(id);
			list=service.getmatch(vo);
			model.addAttribute("list", list);
		}catch(Exception ex){
			if(ex instanceof MyException){
				model.addAttribute("message", ex.getMessage());
				return "/ys/random/matchFail";
			}
		}
		System.out.println(list.size());
		return "/ys/random/matchSuccess";
	}
//	@RequestMapping(value="registRandomMeet",method=RequestMethod.GET)
//	public String registRandomMeet(HttpSession session,Model model) throws Exception{
//		String id = (String)session.getAttribute("id");
//		if(id == null){
//			return "redirect:/error";
//		}
//		int userLocNum=uservice.getUserLoc(id);
//		List<GenderVO> genderList = cservice.getGenderList();
//		List<LocVO> locList = cservice.getLocList();
//		
//		model.addAttribute("userLocNum", userLocNum);
//		model.addAttribute("genderList", genderList);
//		model.addAttribute("locList", locList);
//		return "/ys/random/registRandomMeet";
//	}
//	@RequestMapping(value="registRandomMeet",method=RequestMethod.POST)
//	public String registRandomMeetAction(MeetVO vo, HttpSession session) throws Exception{
//		String id = (String)session.getAttribute("id");
//		vo.setMeet_writer(id);
//		service.insertRandom(vo);
//		return "/ys/random/registMatchSuccess";
//	}
}
