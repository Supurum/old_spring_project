package com.pjt.common.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pjt.common.domain.JoinDTO;
import com.pjt.common.domain.MessageVO;
import com.pjt.common.domain.MyRegistShowDTO;
import com.pjt.common.domain.MyRequestingInfoDTO;
import com.pjt.common.service.JoinService;
import com.pjt.common.service.MessageService;
import com.pjt.common.service.MyRegistShowService;

@Controller
@RequestMapping("/registShow/*")
public class MyRegistShowController {

	@Inject
	MyRegistShowService service;

	@Inject
	JoinService joinService;
	
	@Inject
	MessageService messageService;
	@RequestMapping(value = "myRegistShow", method = RequestMethod.GET)
	public void myRegistShow(HttpSession session, Model model) throws Exception {
		String user_id = (String) session.getAttribute("id");
		MyRegistShowDTO dto = service.myRegistShow(user_id);
		List<JoinDTO> list = joinService.listAll(user_id);
		List<MyRequestingInfoDTO> dto2 =service.myRequestingShow(user_id);
		model.addAttribute("dto2", dto2);
		model.addAttribute("list", list);
		model.addAttribute("dto", dto);
	}

	@RequestMapping(value = "requestMatching", method = RequestMethod.GET)
	public void myRequestPage(Model model, HttpSession session,int meet_num,String meet_partner) throws Exception {
		// TODO 로그인 작업 후 세션 아이디 값으로 수정 요함
//		String user_id = "id5";
		String user_id = (String) session.getAttribute("id");
		List<JoinDTO> list = joinService.listAll(user_id);
		model.addAttribute("list", list);
		model.addAttribute("meet_num", meet_num);
		model.addAttribute("meet_partner", meet_partner);
		System.out.println(list);
	}

	// 삭제
	@ResponseBody
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public ResponseEntity<String> deleteRequest(int join_idx) throws Exception {
		System.out.println("deleteRequest 호출됨");
		ResponseEntity<String> entity = null;

		try {
			joinService.deleteRequest(join_idx);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// 수락 누르면 상태 n-> y
	@ResponseBody
	@RequestMapping(value = "changeY", method = RequestMethod.POST)
	public ResponseEntity<String> changeY(int meet_num, String meet_partner) throws Exception {
		System.out.println("---meet_num:" + meet_num);
		System.out.println("---meet_partner:" + meet_partner);
		
		
		ResponseEntity<String> entity = null;
		try {
			joinService.updatePartner(meet_num, meet_partner);
			joinService.update(meet_num);
			joinService.updatePeopleNum(meet_num);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}

		return entity;		
	}
	// 매칭현황에 매칭완료 시키기
	@RequestMapping(value = "completeMatching", method = RequestMethod.GET)
	public String myRequestShow(HttpSession session ,Model model) throws Exception {
		//TODO 세션id값 받으면 변경
		String user_id = "id3";
		service.completeMatching(user_id);
		return "redirect:/longmeet/longmeet";
	}
	
	// 참가신청	
		@ResponseBody
		@RequestMapping(value = "/meet_request"	, method = RequestMethod.POST)
		public String regist(HttpSession session, String meet_writer,int meet_num) throws Exception{
			// TODO 로그인한 사용자 값으로 부터 user_id 얻어옴
			String user_id = (String) session.getAttribute("id");
//			String user_id = "id7";
			
			MessageVO vo = new MessageVO();
			String targetid = meet_writer;
			String sender = user_id;
			vo.setTargetid(targetid);
			vo.setSender(sender);
			vo.setMessage(sender + "님이 신청하셨습니다.");
			
			
			List<String> user_ids = joinService.selectListByMeetNum(meet_num);
			Boolean chkJoin = false;
			String result = null;
			
			for(String id : user_ids){	
				if(user_id.equals(id)){
					chkJoin = true;
					break;
				}
			} 
			if(chkJoin){
				result = "FAIL";
			} else{
				joinService.insertJoin(meet_num, user_id);
				messageService.insert(vo);		
				result = "SUCCESS";
			}
			
			return result;
		}
		
		// 짧은 만남 신청자 상세보기
		@RequestMapping(value = "shortRequestedShow", method = RequestMethod.GET)
		public void shortRequestedShow(Model model, HttpSession session) throws Exception {
			// TODO 로그인 작업 후 세션 아이디 값으로 수정 요함
//			String user_id = "id5";
			String user_id = (String) session.getAttribute("id");
			List<JoinDTO> list = joinService.listAll(user_id);
			
			//			service.updatePartner(meet_num, meet_partner);
////			service.updatePartner(meet_num, meet_partner);
//			model.addAttribute("meet_num", meet_num);
//			model.addAttribute("meet_partner", meet_partner);
			model.addAttribute("list", list);
			System.out.println("/registShow/shortRequestedShow, list: " + list);
		}
		
		// 긴 만남 신청자 상세보기
		@RequestMapping(value = "longRequestedShow", method = RequestMethod.GET)
		public void longRequestedShow(Model model, HttpSession session) throws Exception {
			String user_id = (String) session.getAttribute("id");
			List<JoinDTO> list = joinService.listAll(user_id);
			model.addAttribute("list", list);
			System.out.println(list);
		}
		
		
		// 단체만남 신청자 상세보기
		@RequestMapping(value = "groupRequestedShow", method = RequestMethod.GET)
		public void GroupRequestedShow(Model model, HttpSession session) throws Exception {
			String user_id = (String) session.getAttribute("id");
			List<JoinDTO> list = joinService.listAll(user_id);
			model.addAttribute("list", list);
			System.out.println(list);
		}
		
		
		// 랜덤만남 신청자 상세보기
		@RequestMapping(value = "randomRequestedShow", method = RequestMethod.GET)
		public void RandomRequestedShow(Model model, HttpSession session) throws Exception {
			String user_id = (String) session.getAttribute("id");
			List<JoinDTO> list = joinService.listAll(user_id);
			model.addAttribute("list", list);
			System.out.println(list);
		}
}









