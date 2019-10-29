package com.pjt.controller.ys;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pjt.service.ys.UserService;


@RestController
@RequestMapping("/ys/AJAX")
public class JSONController {
	@Inject
	UserService service;
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> checkID(
			@PathVariable("id") String id) {
		String result="이미 존재하는 아이디";
		int i=-1;
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			i=service.checkID(id);
			if(i==0){
				result="";
			}
			Map<String, Object> map = new HashMap<>();
			map.put("result", result);
			
			entity = new ResponseEntity<Map<String,Object>>(
					map, HttpStatus.OK);
		} catch (Exception e) {
			
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(
					HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	@RequestMapping(value = "/nickName/{nickName}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> checkNickName(
			@PathVariable("nickName") String nickName){
		System.out.println("Path 1");
		String result="이미 존재하는 닉네임";
		int i=-1;
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			i=service.checkNick(nickName);
			if(i==0){
				result="";
			}
			Map<String, Object> map = new HashMap<>();
			map.put("result", result);
			
			entity = new ResponseEntity<Map<String,Object>>(
					map, HttpStatus.OK);
		} catch (Exception e) {
			
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(
					HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}
