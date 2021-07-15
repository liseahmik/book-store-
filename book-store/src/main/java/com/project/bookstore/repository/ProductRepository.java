package com.project.bookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.bookstore.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{




	@Query(value="SELECT * FROM tbl_product WHERE  product_name like %?% ORDER BY product_no desc" , nativeQuery = true)
	Page<Product> findByProductNameContaining(String txt,Pageable pageable);
	
	@Query(value="SELECT * FROM tbl_product WHERE  cate = 'domestic' ORDER BY product_no desc" , nativeQuery = true)
	Page<Product> findBycate(Pageable pageable);
	
	@Query(value="SELECT * FROM tbl_product WHERE  cate = 'foreign' ORDER BY product_no desc " , nativeQuery = true)
	Page<Product> findBycate2(Pageable pageable);
	
	@Query(value="SELECT count(*) FROM tbl_product WHERE  cate = 'domestic'" , nativeQuery = true)
	long countByCate();
	
	@Query(value="SELECT count(*) FROM tbl_product WHERE  cate = 'foreign'" , nativeQuery = true)
	int countByCate2();
	
	@Query(value="SELECT count(*) FROM tbl_product WHERE  product_name like %?%" , nativeQuery = true)
	int countsel(String txt);
	
}
