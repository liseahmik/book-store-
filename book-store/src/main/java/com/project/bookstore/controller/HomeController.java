package com.project.bookstore.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Sort;

import com.project.bookstore.domain.Product;
import com.project.bookstore.service.ProductService;
import com.project.bookstore.service.UserService;



@Controller
public class HomeController {
	
	@Autowired
	private UserService userService; 
	
	@Autowired
	private ProductService productService;
	
	
//	@GetMapping("/")
//	public String home() {
//		return "home";
//	}
	
	@GetMapping("/")
	public String list(Model model,
			@PageableDefault(size = 5, sort = "productNo",
			direction = Sort.Direction.DESC) Pageable pageable) {
		
//		List<Product> lists = productService.list();
//		Long count = bservice.count();
		Page<Product> lists = productService.list(pageable);
		
		for(Product product : lists) {
		
			if(product.getImgage() != null) {
				String tmp = Base64.getEncoder().encodeToString(product.getImgage());
				product.setBase64(tmp);
				product.setImgage(null);
			}
		}
		model.addAttribute("lists",lists);
		model.addAttribute("rowNo", productService.count()-(lists.getNumber()*5)) ; 
		
		return "/product/list";
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
