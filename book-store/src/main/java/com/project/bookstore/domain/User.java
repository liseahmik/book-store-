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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity(name = "tbl_user")
public class User {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int userNo;

	private String phone;
	private String email;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	private String addr;
	private int couponNo;
	
	private String role;
	private String name;
	
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

	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", couponNo=" + couponNo + "]";
	}

	
}
