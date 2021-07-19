package com.project.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookstore.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);

//	void updateCoupon(User user);

	
	
//	@Query("update tbl_user set coupon_no = coupon_no-1 where user_no = ?")
//	void updateCoupon(int i);
	

}
