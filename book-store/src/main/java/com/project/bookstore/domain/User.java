package com.project.bookstore.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;


@Data
@Entity(name = "tbl_user")
public class User {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int userNo;
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String addr;
	private int couponNo;
	
	@CreationTimestamp
	private Date regdate;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;
	
	@OneToMany(mappedBy = "user")
	private List<Cart> carts;
	
	@OneToMany(mappedBy = "user")
	private List<Review> reviews;
	
	@OneToMany(mappedBy = "user")
	private List<QnaBoard> qnaboars;
}
