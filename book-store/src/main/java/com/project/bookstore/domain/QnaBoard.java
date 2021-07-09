package com.project.bookstore.domain;

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

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity(name = "tbl_qnaboard")
public class QnaBoard {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qnaNo;
	
	private String content;
	@CreationTimestamp
	private Date qnaDate;
	private String qnaStatus;
	private String qnaProduct;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "qnaboard")
	private List<QnaComment> qnacomments;
}
