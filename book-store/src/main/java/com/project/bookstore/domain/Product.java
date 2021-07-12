package com.project.bookstore.domain;

import java.sql.Blob;
import java.sql.Clob;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.type.BlobType;

import lombok.Data;

@Entity( name =  "tbl_product")
@Data
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productNo;
	
	private String productName;
	private int productPrice;
	
	private Date productDate;
	private Date salesRate;
	
	private String writer;
	private String image;
	private int discountRate;
	
	@OneToMany(mappedBy = "product")
	private List<Cart> carts;
	
	@OneToMany(mappedBy = "product")
	private List<Review> reviews;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
}
