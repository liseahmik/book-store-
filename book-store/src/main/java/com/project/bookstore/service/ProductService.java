package com.project.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.bookstore.domain.Product;
import com.project.bookstore.domain.User;
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

	public Page<Product> findBycate(Pageable pageable) {
		return productRepository.findBycate(pageable);
	}

	public Page<Product> findBycate2(Pageable pageable) {
		return productRepository.findBycate2(pageable);
	}

	public long count() {
		return productRepository.count();
	}

	public long countByCate() {
		return productRepository.countByCate();
	}

	public int countByCate2() {
		return productRepository.countByCate2();
	}

	public int countsel(String txt) {
		return productRepository.countsel(txt);
	}

	public Product findById(int productNo) {
		 Product product =	productRepository.findById(productNo).get();
		 return product;
	}

	public List<Product> list() {
		return productRepository.findAll();
	}

	public List<Product> list(int userNo) {
		return productRepository.findByCarts(userNo);
	}

	public List<Product> list(User user) {
		return productRepository.findByCarts(user);
	}

//	public Page<Product> findAllByProductNameContaining(String txt) {
//		return productRepository.findAllByProductNameContaining(txt);
//	}

}
