package com.project.bookstore.controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.project.bookstore.domain.Product;
import com.project.bookstore.domain.User;
import com.project.bookstore.service.ProductService;

@RequestMapping("/product/*")
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	

	@GetMapping("insert")
	public String insert() {
		return "product/insert";
	}
	
	@PostMapping("insert")
	public String insert(Product product,MultipartFile files,
				HttpServletRequest request) throws IOException {
		
		
		
		//이미지
		if(files.getBytes().length >0) {
			product.setImgage(files.getBytes());
		}
		
		System.out.println(product.getImgage());
		
		productService.insert(product);		
		return "redirect:list";
	}
	
	@GetMapping("list")
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
	
	@GetMapping("select")
	public String select(Model model,
			@PageableDefault(size = 5) Pageable pageable,String txt) {
		
//		List<Product> lists = productService.list();
//		Long count = bservice.count();
		Page<Product> lists = productService.findByProductNameContaining(txt,pageable);
//		Page<Product> lists = productService.findAllByProductNameContaining(txt);
		for(Product product : lists) {
		
			if(product.getImgage() != null) {
				String tmp = Base64.getEncoder().encodeToString(product.getImgage());
				product.setBase64(tmp);
				product.setImgage(null);
			}
		}
		model.addAttribute("lists",lists);
		model.addAttribute("rowNo", productService.countsel(txt)-(lists.getNumber()*5)) ; 
		
		return "/product/select";
	}
	
	@GetMapping("domestic")
	public String domestic(Model model,@PageableDefault(size = 5) Pageable pageable) {
		
		Page<Product> lists = productService.findBycate(pageable);
		for(Product product : lists) {
		
			if(product.getImgage() != null) {
				String tmp = Base64.getEncoder().encodeToString(product.getImgage());
				product.setBase64(tmp);
				product.setImgage(null);
			}
		}
		model.addAttribute("lists",lists);
		model.addAttribute("rowNo", productService.countByCate()-(lists.getNumber()*5)) ; 
		
		return "/kate/domestic";
	}
	@GetMapping("international")
	public String international(Model model,@PageableDefault(size = 5) Pageable pageable) {
		
		Page<Product> lists = productService.findBycate2(pageable);
		for(Product product : lists) {
		
			if(product.getImgage() != null) {
				String tmp = Base64.getEncoder().encodeToString(product.getImgage());
				product.setBase64(tmp);
				product.setImgage(null);
			}
		}
		model.addAttribute("lists",lists);
		model.addAttribute("rowNo", productService.countByCate2()-(lists.getNumber()*5)) ; 
		
		return "/kate/international";
	}
	
	
	@GetMapping("detail/{productNo}")
	public String detail(@PathVariable int productNo,Model model,
				User user) {
		
		Product product = productService.findById(productNo);
		if(product.getImgage() != null) {
			String tmp = Base64.getEncoder().encodeToString(product.getImgage());
			product.setBase64(tmp);
			product.setImgage(null);
		}
		
		if(!(user.getCouponNo() == 0)) {
			product.setProductPrice(product.getProductPrice() / 10);
		}
		System.out.println(user.getCouponNo());
		model.addAttribute("product",product);
		return "/product/detail";
	}

}
