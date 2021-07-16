package com.project.bookstore.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.bookstore.config.auth.PrinpalDetatils;
import com.project.bookstore.domain.Cart;
import com.project.bookstore.domain.Product;
import com.project.bookstore.domain.User;
import com.project.bookstore.service.CartService;
import com.project.bookstore.service.ProductService;

@RequestMapping("/cart/*")
@Controller
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("list")
	public String list() {
		
		return "/cart/list";
	}
	
	@GetMapping("cartlist")
	public String cartlist(Model model,
			@AuthenticationPrincipal PrinpalDetatils principal) {
		
		User user = principal.getUser();
		
		if(user != null) {
//			System.out.println(user.getUsername());
//			System.out.println(user.getName());
			model.addAttribute("user",user);
			
			String id = user.getUsername();
			List<Cart> clists = cartService.findByUserName(id);
//			int num = user.getUserNo();
//			Cart cart2 = cartService.findById(num);
			
			int sum = 0;
			
			for(Cart cart : clists) {
				Product product = cart.getProduct();
				if(product.getImgage() != null) {
					String tmp1 = Base64.getEncoder().encodeToString(product.getImgage());
					product.setBase64(tmp1);
					product.setImgage(null);
					
					sum += product.getProductPrice() * cart.getQty();
					
				}
				
				
			}
			model.addAttribute("clists", clists);
			model.addAttribute("sum",sum);
//			model.addAttribute("cart",cart2);
		}

		return "/cart/list";
	}

	@PostMapping("insert")
	public String insert(Cart cart,Product product,@AuthenticationPrincipal PrinpalDetatils principal) {
		
		cart.setUser(principal.getUser());
		cartService.insert(cart,product);
		
		
		return "/cart/list";
	}
	
	@ResponseBody
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		System.out.println("cart delete 실행");
		cartService.delete(id);
		
		return "success";
		
	}
	
}
