package com.project.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bookstore.domain.QnaComment;
import com.project.bookstore.repository.QnaCommentRepository;

@Service
public class QnaCommentService {
	
	@Autowired
	private QnaCommentRepository qnaCommentRepository;
	
	@Transactional
	public void insert(QnaComment qnacomment) {
		qnaCommentRepository.save(qnacomment);
	}

	@Transactional
	public List<QnaComment> list(int num) {
		return qnaCommentRepository.findByqnacomNo(num);
	}


}
