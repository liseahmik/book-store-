package com.project.bookstore.controller;

import java.util.List;

import javax.xml.stream.events.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bookstore.config.auth.PrinpalDetatils;
import com.project.bookstore.domain.QnaBoard;
import com.project.bookstore.domain.QnaComment;
import com.project.bookstore.service.QnaCommentService;

@RestController //responsebody 생략가능
@RequestMapping("/reply/*")
public class CommentController {
	
	@Autowired
	private QnaCommentService commentservice;
	
	//댓글추가
	@PostMapping("insert/{num}")
	public ResponseEntity<String> commentInsert(@PathVariable int num,
			@RequestBody QnaComment qnacomment,
			@AuthenticationPrincipal PrinpalDetatils principal) {
		QnaBoard qb = new QnaBoard();
		qb.setQnaNo(num);
		qnacomment.setQnaboard(qb);
		System.out.println("principal.getUser()"+principal.getUser());
//		qnacomment.setUser(principal.getUser());
//		qnacomment.set
		commentservice.insert(qnacomment);
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
	
	//댓글 리스트
	@GetMapping("list/{num}")
	public List<QnaComment> list(@PathVariable int num) {
//		System.out.println("num: "+num);
		System.out.println("댓글리스트 실행");
		List<QnaComment> clist = commentservice.list(num);
		
		return clist;
	}
	
}
