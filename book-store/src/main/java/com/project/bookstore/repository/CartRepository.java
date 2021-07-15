package com.project.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookstore.domain.Cart;
import com.project.bookstore.domain.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	List<Cart> findCartsByUser(int userNo);

	List<Cart> findCartsByUser(User user);

	List<Cart> findByUserName(String id);

}
