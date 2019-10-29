package com.pjt.controller.ys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pjt.common.service.CommonService;
import com.pjt.domain.ys.MainCategoryVO;

@RestController
@RequestMapping("ys/MENU")
public class MenuController {
	@Inject
	CommonService service;

	@RequestMapping(value = "/getMain", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getMenu() {
		ResponseEntity<Map<String, Object>> entity = null;

		try {
			List<MainCategoryVO> mainList = service.getMainMenuList();
			System.out.println(mainList.size());
			Map<String, Object> map = new HashMap<>();
			map.put("mainList", mainList);

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
//	@RequestMapping(value = "/getSub", method = RequestMethod.GET)
//	public ResponseEntity<Map<String, Object>> getSub() {
//		ResponseEntity<Map<String, Object>> entity = null;
//
//		try {
//			List<CategoryVO> subList = service.getSubMenuList();
//
//			Map<String, Object> map = new HashMap<>();
//			map.put("subList", subList);
//
//			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
//		}
//		return entity;
//	}
}
