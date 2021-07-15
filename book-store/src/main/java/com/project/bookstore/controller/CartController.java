package com.project.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cart/*")
@Controller
public class CartController {
	
	@GetMapping("list")
	public String list() {
		return "/cart/list";
	}
	
	@PostMapping("list")
	public String list(Model model) {
		return "/cart/list";
	}
}
