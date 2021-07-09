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
	@GetMapping("jusoPopup")
	public String jusoPopup() {
		return "jusoPopup";
	}
	@PostMapping("jusoPopup")
	public String jusoPopup2() {
		return "jusoPopup";
	}

	@GetMapping("Sample")
	public String Sample() {
		return "Sample";
	}

}
