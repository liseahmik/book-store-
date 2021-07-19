package com.project.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.project.bookstore.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService; 
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}

	

	//Q & A==================================
//		@GetMapping("qna")
//		public String qna(Model model,
//				@PageableDefault(size = 3, sort = "userNo", direction = Sort.Direction.DESC) Pageable pageable) {
//			Page<User> lists = userService.qnaList(pageable);
//			model.addAttribute("lists", lists);
//			return "qna";
//		}
	

		

}
