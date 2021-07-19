package com.project.bookstore.controller;

import java.io.IOException;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.bookstore.config.auth.PrinpalDetatils;
import com.project.bookstore.domain.Cart;
import com.project.bookstore.domain.Product;
import com.project.bookstore.domain.User;
import com.project.bookstore.repository.CartRepository;
import com.project.bookstore.repository.UserRepository;
import com.project.bookstore.service.CartService;
import com.project.bookstore.service.ProductService;

@RequestMapping("/cart/*")
@Controller
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userrepository;
	
//	@GetMapping("list")
//	public String list() {
//		
//		return "/cart/list";
//	}
//	
	@GetMapping("cartlist")
	public String cartlist(Model model,String resp,
			@AuthenticationPrincipal PrinpalDetatils principal) {
		
//		System.out.println(num);
		User user = userrepository.findByUsername(principal.getUser().getUsername());
		
		System.out.println("user : " + user);
		if(user != null) {
			
			
			
			int id = user.getUserNo();
			
			
//			System.err.println("쿠폰: "+user.getCouponNo());
//			System.out.println("로그인 아이디"+id);
			List<Cart> clists = cartService.findByUserNo(id);
		
			int sum = 0;
//			System.out.println("사이즈"+clists.size());
			for(Cart cart : clists) {
				Product product = cart.getProduct();
				if(product.getImgage() != null) {
					String tmp1 = Base64.getEncoder().encodeToString(product.getImgage());
					product.setBase64(tmp1);
					product.setImgage(null);
					
					sum += product.getProductPrice() * cart.getQty();
					
					
					 if( resp != null) {
						product.setProductPrice((int) (product.getProductPrice() * 0.9));
					 }
					 
					
					
				}
				
				
			}
			model.addAttribute("clists", clists);
			model.addAttribute("sum",sum);
			model.addAttribute("user",user);
			
		}

		return "/cart/list";
	}
	
	@GetMapping("cartlist/{num}")
	public String cartlist2(Model model,String resp,@PathVariable int num,
			@AuthenticationPrincipal PrinpalDetatils principal) {
		
//		System.out.println(num);
		User user = userrepository.findByUsername(principal.getUser().getUsername());
		
		Cart c = cartService.findById(num);
		
		System.out.println("user : " + user);
		System.out.println("cart : " + c.getCartNo());
		System.out.println("cart적용 : " + c.getCouponapply());
		
		
		
		if(user != null) {
			
			
			
			int id = user.getUserNo();
			
			
//			System.err.println("쿠폰: "+user.getCouponNo());
//			System.out.println("로그인 아이디"+id);
			List<Cart> clists = cartService.findByUserNo(id);
		
			int sum = 0;
//			System.out.println("사이즈"+clists.size());
			for(Cart cart : clists) {
				Product product = cart.getProduct();
				if(product.getImgage() != null) {
					String tmp1 = Base64.getEncoder().encodeToString(product.getImgage());
					product.setBase64(tmp1);
					product.setImgage(null);
					
					
					
					
					 if(cart.getCouponapply() == 1) {
						
							 product.setProductPrice((int) (product.getProductPrice() * 0.9));

					 }
					 
					 sum += product.getProductPrice() * cart.getQty();
					
				}
				
				
			}
			model.addAttribute("clists", clists);
			model.addAttribute("sum",sum);
			model.addAttribute("user",user);
		}

		return "/cart/list";
	}
	
	@GetMapping("cartlistback/{num}")
	public String cartlistback(Model model,String resp,@PathVariable int num,
			@AuthenticationPrincipal PrinpalDetatils principal) {
		
//		System.out.println(num);
		User user = userrepository.findByUsername(principal.getUser().getUsername());
		
		Cart c = cartService.findById2(num);
		
		System.out.println("user : " + user);
		System.out.println("cart : " + c.getCartNo());
		System.out.println("cart취소 : " + c.getCouponapply());
		
		
		
		if(user != null) {
			
			
			
			int id = user.getUserNo();
			
			
//			System.err.println("쿠폰: "+user.getCouponNo());
//			System.out.println("로그인 아이디"+id);
			List<Cart> clists = cartService.findByUserNo(id);
		
			int sum = 0;
//			System.out.println("사이즈"+clists.size());
			for(Cart cart : clists) {
				Product product = cart.getProduct();
				if(product.getImgage() != null) {
					String tmp1 = Base64.getEncoder().encodeToString(product.getImgage());
					product.setBase64(tmp1);
					product.setImgage(null);
					
					
					
					
					 if(cart.getCouponapply() == 1) {
						
							 product.setProductPrice((int) (product.getProductPrice() * 0.9));

					 }
					 
					 sum += product.getProductPrice() * cart.getQty();
					
				}
				
				
			}
			model.addAttribute("clists", clists);
			model.addAttribute("sum",sum);
			model.addAttribute("user",user);
		}

		return "/cart/list";
	}

	@PostMapping("insert")
	public String insert(Cart cart, Product product,
			@AuthenticationPrincipal PrinpalDetatils principal,RedirectAttributes attr) throws IOException {
		
		cart.setUser(principal.getUser());
		
		User user = principal.getUser();
		int id = user.getUserNo();
		List<Cart> clists = cartService.findByUserNo(id);
		
		
		
		for(int i=0; i<clists.size(); i++) {
			if(clists.get(i).getProduct().getProductNo() == product.getProductNo()) {
				
				System.out.println("a"+clists.get(i).getProduct().getProductNo());
				System.out.println("b"+product.getProductNo());
				
				attr.addFlashAttribute("msg", "aa");
				
				
				return "redirect:/product/detail/"+product.getProductNo();
			}
		}
		
		cartService.insert(cart,product);
		
		return "redirect:/cart/cartlist";
	}
	
	@ResponseBody
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		System.out.println("cart delete 실행");
		cartService.delete(id);
		
		return "success";
		
	}
	
	@PostMapping("order")
	public String order(@AuthenticationPrincipal PrinpalDetatils principal) {
		System.out.println("order실행됨");
		
		int id = principal.getUser().getUserNo();
		
		System.out.println("userid : " + id);
		cartService.alldelete(id);
		return "redirect:/cart/cartlist";
	}
	
}
