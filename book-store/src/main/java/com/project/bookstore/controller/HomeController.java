package com.project.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

//메인페이지=============================
	@GetMapping("/")
	public String home() {
		return "home";
	}

//국내도서===============================
	@GetMapping("domestic")
	public String domestic() {
		//...
		return "domestic";	
	}
	
//해외도서===============================
	@GetMapping("international")
	public String international() {
		//...
		return "international";	
	}
//Q & A==================================
	@GetMapping("qna")
	public String qna() {
		//...
		return "qna";	
	}

//장바구니 (로그인필요)==================================
	@GetMapping("cart")
	public String cart() {
		//...
		return "cart";	
	}
	
//회원가입 (비로그인)===============================
	
	
	
	
	
	
	
//로그인 (비로그인)=================================
	@GetMapping("login")
	public String login() {
		return "users/login";
	}
	
//	@PostMapping("login")
//	public String login() {
//
//		return "redirect:/";
//	}

	
	
	
//마이페이지(로그인필요) 
//회원수정==============================	
	@GetMapping("modifyUser")
	public String modifyUser() {
		//...
		return "users/mypage/modifyUser";
	}
	
//주문조회==============================
	@GetMapping("myOrder")
	public String myOrder() {
		//...
		return "users/mypage/myOrder";
	}
	
//회원탈퇴===============================
	@GetMapping("deleteAccount")
	public String deleteAccount() {
		//...
		return "users/mypage/deleteAccount";
	}
	
	
	
//관리자페이지(로그인필요)
//회원관리===============================
	@GetMapping("customer")
	public String customer() {
		//...
		return "users/adminpage/customer";
	}
	
//주문관리===============================
	@GetMapping("orderList")
	public String orderList() {
		//...
		return "users/adminpage/orderList";
	}
	
}
