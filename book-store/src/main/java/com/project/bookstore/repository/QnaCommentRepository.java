package com.project.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookstore.domain.QnaComment;

public interface QnaCommentRepository extends JpaRepository<QnaComment, Integer>{

	
	
	List<QnaComment> findByqnacomNo(int num);
	
	
}
