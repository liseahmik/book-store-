package com.project.bookstore.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;


@Data
@Entity(name = "tbl_order")
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oderNo;
	private String orderName;
	private String orderAddr;
	private String orderPhone;
	private Date orderDate;
	private int amount;
	private int payment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
}
