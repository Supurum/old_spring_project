package com.pjt.controller.kmh;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.tools.DocumentationTool.Location;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pjt.domain.kmh.Criteria;

import com.pjt.domain.kmh.MatchRegisterVO;
import com.pjt.domain.kmh.PageMaker;
import com.pjt.domain.kmh.UserInfoDTO;

import com.pjt.service.kmh.LongMeetService;

@Controller
@RequestMapping("/longmeet/*")
public class LongMeetController {

	@Inject
	LongMeetService service;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void loginPage(Model model) throws Exception {

	}

	@RequestMapping(value = "myRegistPage", method = RequestMethod.GET)
	public void myRegistPage() throws Exception {

	}

	// @RequestMapping(value = "requestMatching", method = RequestMethod.GET)
	// public void myRequestPage(Model model) throws Exception {
	// List<JoinDTO>list = service3.listAll();
	// model.addAttribute("list", list);
	// System.out.println(list);
	// }

	// 긴만남 회원 리스트
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void matchRegistPage(Criteria cri, Model model) throws Exception {
		int page = cri.getPage();
		List<MatchRegisterVO> longUserList = service.longUserList(page);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		int totalCount = service.listCount();
		pageMaker.setTotalCount(totalCount);
		model.addAttribute("longUserList", longUserList);
		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "detailInfo", method = RequestMethod.GET)
	public void userDetailInfo(@RequestParam("user_id") String user_id, Criteria cri, Model model) throws Exception {
		UserInfoDTO dto = service.userDetailInfo(user_id);
		model.addAttribute("page", cri.getPage());
		model.addAttribute("dto", dto);
	}

	@RequestMapping(value = "longmeet", method = RequestMethod.GET)
	public void longMeet() throws Exception {
		// String id = (String) session.getAttribute("id");
		// try {
		//
		// } catch (Exception e) {
		//
		// }
		// return "redirect: /ys/user/login";
	}



	@RequestMapping(value = "uploadMatching", method = RequestMethod.GET)
	public void uploadMatching() throws Exception {

	}

	@RequestMapping(value = "registShow", method = RequestMethod.GET)
	public String registShow() throws Exception {
		return "redirect:/registShow/myRegistShow";
	}
	// @RequestMapping(value="randommatch",method=RequestMethod.POST)
	// public String matchAction(RequestMatchDTO vo, Model model) throws
	// Exception{
	// List<UserVO> list=null;
	// try{
	// list=service.getmatch(vo);
	// model.addAttribute("list", list);
	// }catch(Exception ex){
	// if(ex instanceof MyException){
	// model.addAttribute("message", ex.getMessage());
	// return "matchFail";
	// }
	// }
	// return "matchSuccess";
	//

}
