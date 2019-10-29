package com.pjt.common.controller;


import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pjt.common.domain.MessageDTO;
import com.pjt.common.domain.MessageVO;
import com.pjt.common.service.MessageService;
import com.pjt.domain.kth.Criteria;
import com.pjt.domain.kth.PageMaker;


@Controller
@RequestMapping(value = "/messages")
public class MessageController {
	
	@Inject
	MessageService messageService;
	
	//메세지 리스트
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String messageList() throws Exception{
		return "redirect:/messages/list/targetid/1";
	}
	
	
	//메세지 리스트(받은,보낸 쪽지함)
	@RequestMapping(value = "/list/{type}/{page}", method = RequestMethod.GET)
	public String messagePage(@PathVariable("type") String type, Model model, HttpSession session,
				@ModelAttribute("cri") Criteria cri, @PathVariable("page") int page) throws Exception{
		// TODO 로그인 처리 후 세션 값으로 변경
		String user_id = (String)session.getAttribute("id");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		List<MessageDTO> list = null;
		if (type.equals("sender")) {			
			pageMaker.setTotalCount(messageService.countSenderPage(user_id));
			list = messageService.sendList(user_id, page);
		} else {
			pageMaker.setTotalCount(messageService.countTargetPage(user_id));
			list = messageService.targetList(user_id, page);
		}
		model.addAttribute("list",list);
		model.addAttribute("type",type);
		model.addAttribute("pageMaker", pageMaker);
		
		return "/messages/list";
	}
	
	//메세지 상세정보 및 읽음표시
	@RequestMapping(value = "/{type}/detail/{msg_num}", method = RequestMethod.GET)
	public String messageView(@PathVariable("msg_num") int msg_num, @PathVariable("type") String type,
							MessageDTO dto, Model model) throws Exception{
		Timestamp opendate = messageService.chkOpenDate(msg_num);
		
		if(opendate == null){
			messageService.chkRead(msg_num);
		} 
		
		dto = messageService.select(msg_num);
		model.addAttribute("dto", dto);
		model.addAttribute("type", type);
		System.out.println(dto);
		
		return "/messages/detail";
	}
	
	//메세지 삭제
	@RequestMapping(value = "/delete/{msg_num}", method = RequestMethod.GET)
	public String messageDelete(@PathVariable("msg_num") int msg_num) throws Exception{
		messageService.delete(msg_num);
		System.out.println(msg_num);
		
		return "redirect:/messages/list";
	}
	
	//메세지 작성
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void messageWrite() throws Exception{
		
	}
	
	//메세지 보내기
	@RequestMapping(value = "/writePost", method = RequestMethod.POST)
	public String messageWritePost(MessageVO vo) throws Exception{
		System.out.println("------------vo:" + vo);
		messageService.insert(vo);
		
		return "redirect:/messages/list";
	}
	
	//메세지 답장폼
	@RequestMapping(value = "/reply/{sender}", method = RequestMethod.GET)
	public String messageReply(@PathVariable("sender") String sender, HttpSession session, Model model) throws Exception{
		String targetid = sender;
		// TODO 로그인 처리 완료 후 세션 값을 변경
		String user_id = (String)session.getAttribute("id");
		sender = user_id; 
		model.addAttribute("targetid", targetid);
		model.addAttribute("sender", sender);
		
		return "/messages/reply";
	}
	
	//메세지 답장
	@RequestMapping(value = "/replyPost", method = RequestMethod.POST)
	public String messageReplyPost(MessageVO vo, HttpSession session) throws Exception{
		// TODO 로그인 처리 완료 후 세션 값을 변경
		String user_id = (String)session.getAttribute("id");
		vo.setSender(user_id);
		messageService.insert(vo);
		
		return "redirect:/messages/list";
	}
	
}
