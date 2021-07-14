package com.project.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.bookstore.domain.Product;
import com.project.bookstore.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void insert(Product product) {
		System.out.println(product);
		productRepository.save(product);
	}

	public Page<Product> list(Pageable pageable) {
		return productRepository.findAll(pageable);
	}




	public Page<Product> findByProductNameContaining(String txt, Pageable pageable) {
		return productRepository.findByProductNameContaining(txt,pageable);
	}

//	public Page<Product> findAllByProductNameContaining(String txt) {
//		return productRepository.findAllByProductNameContaining(txt);
//	}

}
