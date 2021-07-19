package com.project.bookstore.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.bookstore.domain.Cart;
import com.project.bookstore.domain.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	List<Cart> findCartsByUser(int userNo);

	List<Cart> findCartsByUser(User user);

	List<Cart> findByUserName(String id);

	List<Cart> findByUser_userNo(int id);
	
	
//	@Query(value="DELETE FROM tbl_cart WHERE user_id=?", nativeQuery = true)
//	void deleteAllById(int id);
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM tbl_cart WHERE user_id=?", nativeQuery = true)
	void deleteAllByUserId(int id);

}
