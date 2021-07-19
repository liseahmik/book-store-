package com.project.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.bookstore.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService; 
	
	@GetMapping("/")
	public String home() {
		return "home";
	}

	
//	@GetMapping("qna")
//	public String qna(Model model,
//			@PageableDefault(size = 3, sort = "userNo", direction = Sort.Direction.DESC) Pageable pageable) {
//		Page<User> lists = userService.qnaList(pageable);
//		model.addAttribute("lists", lists);
//		return "qna";
//	}

	//장바구니 (로그인필요)==================================
		@GetMapping("cart")
		public String cart() {
			//...
			return "cart";	
		}
		
	//회원가입 (비로그인)===============================
		

}
