package com.project.bookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.bookstore.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{


	@Query(value="SELECT * FROM tbl_product WHERE  product_name like %?%" , nativeQuery = true)
	Page<Product> findByProductNameContaining(String txt,Pageable pageable);
	
//	@Query(value="SELECT * FROM PRODUCT WHERE productName  = " , nativeQuery = true)
//	Page<Product> findAllByProductNameContaining(String txt);

}
