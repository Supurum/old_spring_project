package com.pjt.controller.kth;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pjt.common.domain.PartnerInfoDTO;
import com.pjt.common.service.MessageService;
import com.pjt.common.service.PartnerInfoService;
import com.pjt.domain.kth.Criteria;
import com.pjt.domain.kth.ListDTO;
import com.pjt.domain.kth.PageMaker;
import com.pjt.domain.kth.UserInfoDTO;
import com.pjt.service.kth.ListService;
import com.pjt.service.kth.UserInfoService;

@Controller
@RequestMapping(value = "/grp")
public class GrpMeetController {
	
//	@Inject
//	GrpMeetService service;
	
	@Inject
	ListService listService;
	
	@Inject
	UserInfoService UserInfoService;
	
	@Inject
	MessageService messageService;
	
	@Inject
	PartnerInfoService partnerInfoService;
	
	//참여하기리스트
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() throws Exception{
		return "redirect:/grp/list/1";
	}
	
	//참여하기페이징
	@RequestMapping(value = "/list/{page}", method = RequestMethod.GET)
	public String listPage(@PathVariable("page") int page, Model model, @ModelAttribute("cri") Criteria cri)throws Exception{
		List<ListDTO>list = listService.listPage(page);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(listService.countPaging());
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list",list);
		System.out.println("list:" + list);
		return "/grp/list";
	}
	
	//전체목록
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAll() throws Exception{
		return "redirect:/grp/listAll/1";
	}
	
	//전체목록페이징
	@RequestMapping(value = "/listAll/{page}", method = RequestMethod.GET)
	public String listAllPage(@PathVariable("page") int page, Model model, @ModelAttribute("cri") Criteria cri)throws Exception{
		List<ListDTO>list = listService.listPageAll(page);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(listService.countPagingAll());
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list",list);
		return "/grp/listAll";
	}
	
	//상세글
	@RequestMapping( value = "/read/{page}/{meet_num}", method = RequestMethod.GET)
	public String read(@PathVariable("meet_num") int meet_num, Model model, @ModelAttribute("page") int page) throws Exception{
		ListDTO dto = listService.select(meet_num);
//		UserInfoDTO dto2 = UserInfoService.select(meet_num);
		PartnerInfoDTO dto2 = partnerInfoService.writerInfo(meet_num);
		Criteria cri = new Criteria(1, 4);
		int startRow = cri.getStartRow();
		int endRow = cri.getEndRow();
		System.out.println(getClass().getName() + ", " + "/read/page/meet_num, starRow:" + startRow);
		System.out.println(getClass().getName() + ", " + "/read/page/meet_num: endRow" + endRow);
		List<PartnerInfoDTO> list = partnerInfoService.partnerInfo(meet_num, startRow, endRow);
		model.addAttribute("dto", dto);
		model.addAttribute("dto2", dto2);
		model.addAttribute("list", list);
		return "/grp/read";
	}
	
	
	@RequestMapping (value = "/listPartner"/*, method = RequestMethod.GET*/)
	public String partnerList(Model model, int meet_num, int subpage, int perPageNum) throws Exception {
		System.out.println("--------------------partnerList, meet_num:" + meet_num);
		System.out.println("--------------------partnerList, subpage:" + subpage);
		System.out.println("--------------------partnerList, perPageNum:" + perPageNum);
		
		
		Criteria cri = new Criteria(subpage, perPageNum);
		System.out.println("GrpMeetController, listPartner, cri:" + cri);
		
		List<PartnerInfoDTO> partnerList = partnerInfoService.partnerInfo(meet_num, cri.getStartRow(), cri.getEndRow());
//		System.out.println("GrpMeetController, listPartner, partnerList:" + partnerList);
		System.out.println(partnerList);
		model.addAttribute("list", partnerList);
		
		return "/grp/joiningMembers";
	}
	
	
	
//	// 글 삭제
//	@RequestMapping(value = "/delete/{meet_num}", method = RequestMethod.GET)
//	public String del(@PathVariable("meet_num") int meet_num)throws Exception{
//		System.out.println("/delete/{meet_num}: " + meet_num);
//		service.delete(meet_num);
//		return "redirect:/grp/list";
//	}
	
	// 모집 상태 변경
	@RequestMapping(value = "/state/{meet_num}/{meet_state}", method = RequestMethod.GET)
	public String state(@PathVariable("meet_num") int meet_num, @PathVariable("meet_state") String meet_state) throws Exception{
		System.out.println("/status/{meet_num}:" + meet_num);
		listService.updateState(meet_num, meet_state);
		return "redirect:/grp/listAll/";
	}
	
	
}
