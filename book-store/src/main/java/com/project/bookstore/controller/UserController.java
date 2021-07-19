package com.project.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
//회원가입================================================
	@GetMapping("register")
	public String register() {
		return "/user/register";
	}

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
	
//로그인=====================================================
	@GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "exception", required = false) String exception,
                        Model model) {
		model.addAttribute("error",error);
        model.addAttribute("exception",exception);
        return "user/login";
    }

	
	
// mypage/회원 수정------------------------
	@GetMapping("/mypage/modifyUser/{userNo}")
	public String update(@PathVariable int userNo, Model model) {
		model.addAttribute("user", userservice.findByUserNo(userNo));
		return "/user/mypage/modifyUser";
	}
	@PutMapping("/mypage/modifyUser")
	@ResponseBody
	public String update(@RequestBody User user) {
		userservice.modify(user);
		return "success";
	}
		
	
// mypage/회원 탈퇴==========================================

	@GetMapping("deleteAccount/{userNo}")
	public String delete(@PathVariable int userNo, Model model) {
		model.addAttribute("user", new User());
		return "user/mypage/deleteAccount";
	}
	@DeleteMapping("deleteAccount/{userNo}")
	@ResponseBody
	public String delete1(@PathVariable int userNo) {
		userservice.delete(userNo);
		return "success";
	}

	

	
//adminpage/회원조회 ===================================================  
	@GetMapping("/adminpage/customer")
	public String customer(Model model,
			@PageableDefault(size = 10, sort = "userNo", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<User> lists = userservice.customerList(pageable);
		model.addAttribute("lists", lists);
		return "/user/adminpage/customer";
	}
	
		
	
	
	
	


	
}
