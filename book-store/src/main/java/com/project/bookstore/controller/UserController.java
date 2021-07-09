package com.project.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user/*")
@Controller
public class UserController {
	
	
	@GetMapping("register")
	public String register() {
		return "user/register";
	}
	
	@GetMapping("jusoPopup")
	public String jusoPopup() {
		return "user/jusoPopup";
	}
	
	@PostMapping("jusoPopup")
	public String jusoPopup2() {
		return "user/jusoPopup";
	}
	
	@GetMapping("Sample")
	public String Sample() {
		return "user/Sample";
	}
	
	
}
