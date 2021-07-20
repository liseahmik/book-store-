package com.project.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bookstore.domain.QnaBoard;

public interface QnaRepository extends JpaRepository<QnaBoard, Integer> {

	void deleteByqnaNo(int id);



}
