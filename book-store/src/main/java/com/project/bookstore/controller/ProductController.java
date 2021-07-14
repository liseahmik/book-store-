package com.project.bookstore.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.project.bookstore.domain.Product;
import com.project.bookstore.repository.ProductRepository;
import com.project.bookstore.service.ProductService;

import lombok.extern.java.Log;

@RequestMapping("/product/*")
@Controller
@Log
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;
	
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
		return "product/insert";
	}
	
	@GetMapping("list")
	public String list(Model model,@PageableDefault(size = 5) Pageable pageable) {
		
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

		
		return "/product/list";
	}
	
	@GetMapping("select")
	public String select(Model model,@PageableDefault(size = 5) Pageable pageable,String txt) {
		
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

		
		return "/product/select";
	}

}
