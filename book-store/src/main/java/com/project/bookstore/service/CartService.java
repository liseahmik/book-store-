package com.project.bookstore.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.project.bookstore.config.auth.PrinpalDetatils;
import com.project.bookstore.domain.Cart;
import com.project.bookstore.domain.Product;
import com.project.bookstore.domain.User;
import com.project.bookstore.repository.CartRepository;
import com.project.bookstore.repository.UserRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;

	public List<Cart> list() {
		return cartRepository.findAll();
	}

	public List<Cart> list(int userNo) {
		return cartRepository.findCartsByUser(userNo);
	}
	
	@Transactional
	public void insert(Cart cart,Product product) {
		cart.setProduct(product);

//		cart.setUser(user);
		cartRepository.save(cart);
	}

	public List<Cart> list(User user) {
		return cartRepository.findCartsByUser(user);
	}

	public List<Cart> findByUserName(String id) {
		return cartRepository.findByUserName(id);
	}

	public void delete(int id) {
		cartRepository.deleteById(id);
	}

	public Cart findById(int num) {
		 Cart cart = cartRepository.findById(num).get();
		 cart.setCouponapply(1);
		 return cart;
	}
	
	@Transactional
	public List<Cart> findByUserNo(int id) {
//		Optional<User> user = userRepository.findById(id);
		return cartRepository.findByUser_userNo(id);
	}

	public Cart findById2(int num) {
		 Cart cart = cartRepository.findById(num).get();
		 cart.setCouponapply(0);
		 return cart;
	}

	public void alldelete(int id) {
		cartRepository.deleteAllByUserId(id);
		
	}
	
	
}
