package com.project.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.bookstore.domain.User;
import com.project.bookstore.repository.CartRepository;
import com.project.bookstore.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	
	public void registerUser(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole("ROLE_USER");
		user.setCouponNo(1);
		userRepository.save(user);
	}


	// admin: 회원조회
		public List<User> customerList(){
			return userRepository.findAll();
		}




		// 회원탈퇴==========================================
				public void delete(int userNo) {
					userRepository.deleteById(userNo);
				}


				// 페이징 전체보기-----------------
				public Page<User> customerList(Pageable pageable){
					return userRepository.findAll(pageable);
				}


		// 회원개인조회======================================
				public User findByUserNo(int userNo) {
					return userRepository.findById(userNo)
							.orElseThrow(()->{
								return new IllegalArgumentException("상세보기 실패");
							});
				}

		// 회원수정
				public void modify(User user) {
					User user2 = userRepository.findById(user.getUserNo()).get();
					user2.setPassword(user.getPassword());
					user2.setPhone(user.getPhone());
					user2.setEmail(user.getEmail());
					user2.setAddr(user.getAddr());

				}
				//쿠폰 적용
				public void updateCoupon(User user) {
					User u = userRepository.findById(user.getUserNo()).get();
					System.out.println("u1 : " +u);
					u.setCouponNo(u.getCouponNo()-1);
					System.out.println("u2 : "+u);
					
//					cartRepository.findByUser_userNo(u.getUserNo());
				}
				//쿠폰 취소
				public void backCoupon(User user) {
					User u = userRepository.findById(user.getUserNo()).get();
					u.setCouponNo(u.getCouponNo()+1);
					
				}
		

}
