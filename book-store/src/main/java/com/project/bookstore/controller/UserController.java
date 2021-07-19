package com.project.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.bookstore.config.auth.PrinpalDetatils;
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
	
	//로그인=====================================================
		@GetMapping("/login")
	    public String login(@RequestParam(value = "error", required = false) String error,
	                        @RequestParam(value = "exception", required = false) String exception,
	                        Model model) {
			model.addAttribute("error",error);
	        model.addAttribute("exception",exception);
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
	
	@ResponseBody
	@PutMapping("coupon")
	public String coupon(@AuthenticationPrincipal PrinpalDetatils principal,
			RedirectAttributes attr ) {
		
		System.out.println("쿠폰적용버튼 실행");
		User user = principal.getUser();
		System.out.println("쿠폰개수"+user.getCouponNo());
		userservice.updateCoupon(user);
		System.out.println("쿠폰개수"+user.getCouponNo());
		
		return "success";
	}
	
	@ResponseBody
	@PutMapping("couponback")
	public String couponback(@AuthenticationPrincipal PrinpalDetatils principal) {
		
		System.out.println("쿠폰취소버튼 실행");
		User user = principal.getUser();
		
		userservice.backCoupon(user);
		
		
		return "success";
	}

	
}
