package com.project.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
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
		

}
