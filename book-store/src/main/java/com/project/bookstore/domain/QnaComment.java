package com.project.bookstore.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity(name = "tbl_qnacomment")
public class QnaComment {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qnacomNo;
	
	private String content;
	@CreationTimestamp
	private Date qnacomDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "qna_id")
	@JsonIgnore
	private QnaBoard qnaboard;
}
