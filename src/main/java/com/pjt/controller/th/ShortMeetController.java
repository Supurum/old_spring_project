package com.pjt.controller.th;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pjt.domain.th.Criteria;
import com.pjt.domain.th.MeetDTO;
import com.pjt.domain.th.PageMaker;
import com.pjt.domain.th.Sub_Category_DTO;
import com.pjt.service.th.ShortMeetService;

@Controller
@RequestMapping("/ath/*")
public class ShortMeetController {
	@Inject
	ShortMeetService service;

	//전체보기 페이지 완료
	@RequestMapping(value = "selectAll", method = RequestMethod.GET)
	public void selectAll(Criteria cri,Model model) throws Exception{
		int page = cri.getPage();
		List<Sub_Category_DTO> sub_category_list = service.sub_category();
		List<MeetDTO> list = service.listPage(page);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		int totalCount = service.listCount();
		pageMaker.setTotalCount(totalCount);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list", list);
		model.addAttribute("sub_category_list",sub_category_list);
	}
	//서브 카테고리 페이지
	@RequestMapping(value = "subCategory", method = RequestMethod.GET)
	public void selectMovie(Criteria cri,@RequestParam("category_name") String category_name, Model model) throws Exception{
		int page = cri.getPage();
		List<Sub_Category_DTO> sub_category_list = service.sub_category();
		List<MeetDTO> list = service.select(page, category_name);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		int totalCount = service.listCountOne(category_name);
		pageMaker.setTotalCount(totalCount);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("list", list);
		model.addAttribute("sub_category_list",sub_category_list);
	}
	
	
}
