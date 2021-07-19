package com.project.bookstore.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity( name =  "tbl_product")
@Data
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productNo;
	@Column(nullable = false)
	private String productName;
	@Column(nullable = false)
	private int productPrice;
	
	@Transient //컬럼 생성 안함
	private String base64;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date productDate;
	private int salesRate;
	
	private String writer;
	
	@Lob
	@Column(name = "PRIMG")
	public byte[] imgage;
	
	@Column(length = 2000)
	private String content;
	private String cate;
	
	@OneToMany(mappedBy = "product")
	private List<Cart> carts;
	
	@OneToMany(mappedBy = "product")
	private List<Review> reviews;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	
	public String getBase64() {
		return base64;
	}


	public void setBase64(String base64) {
		this.base64 = base64;
	}

}
