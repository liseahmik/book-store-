package com.project.bookstore.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.bookstore.domain.User;
import com.project.bookstore.repository.UserRepository;
import com.project.bookstore.service.UserService;


@Controller
public class UserController {
	
	
	@Autowired
	private UserService userservice; 
	
	@Autowired
	private UserRepository userrepository;
	
	@GetMapping("register")
	public String register() {
		return "/user/register";
	}
	
	//회원가입
		@PostMapping("register")
		@ResponseBody
		public String register(@RequestBody User user) {
			if(userrepository.findByUsername(user.getUsername())!=null)
				return "fail";
			userservice.registerUser(user);
			
			return "success";
		}
	
	@GetMapping("/jusoPopup")
	public String jusoPopup() {
		return "/user/jusoPopup";
	}
	
	@PostMapping("jusoPopup")
	public String jusoPopup2() {
		return "user/jusoPopup";
	}
	
	@GetMapping("/Sample")
	public String Sample() {
		return "user/Sample";
	}
	
	@GetMapping("login")
	public String login() {
		return "user/login";
	} 
	
	@GetMapping("joinIdDupChk")
	public @ResponseBody String joinIdDupChk(String id) {
		
		System.out.println(id);
		User user = userrepository.findByUsername(id);
		
		if(user == null) {
			return "1";
		}else {
			return "0";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("joinIdDupChkJson")
//	public @ResponseBody Map<String, Object> joinIdDupChkJson(User user) {
//		// @ResponseBody애노테이션을 통해
//		// 리턴값은 JSON문자열 형식으로 변환하여 응답을 줌
//		int rowCount = userrepository.findByUserNo(user.getUserNo());
//		
//		boolean isIdDup = (rowCount == 1) ? true : false;
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("isIdDup", isIdDup);
//		
//		return map;
//	}

	
}
