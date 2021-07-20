package com.project.bookstore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.bookstore.domain.QnaBoard;
import com.project.bookstore.domain.User;
import com.project.bookstore.repository.QnaRepository;

@Service
public class QnaService {
	
	@Autowired
	private QnaRepository qnarepository;
	
	public Page<QnaBoard> list(Pageable pageable) {
		return qnarepository.findAll(pageable);
	}

	public Long count() {
		return qnarepository.count();
	}

	public void insert(QnaBoard qboard, User user) {
		qboard.setUser(user);
		qnarepository.save(qboard);
	}

	public QnaBoard findById(int num) {
		QnaBoard qboard = qnarepository.findById(num).get();
		return qboard;
	}

	public void delete(Long id) {

	}

	public void deleteById(int id) {
		qnarepository.deleteById(id);
	}

	public void deleteByQnaNo(int id) {
		qnarepository.deleteByqnaNo(id);
	}

	public QnaBoard view(int num) {
		 QnaBoard qboard =	qnarepository.findById(num).get();
		 return qboard;
	}
	
	@Transactional
	public void update(QnaBoard qboard) {
		QnaBoard qb = qnarepository.findById(qboard.getQnaNo()).get();
		qb.setTitle(qboard.getTitle());
		qb.setContent(qboard.getContent());
		System.out.println("수정된 타이틀 : " + qboard.getTitle());
	}
	
}
