package com.project.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.bookstore.config.auth.PrinpalDetatils;
import com.project.bookstore.domain.QnaBoard;
import com.project.bookstore.domain.QnaComment;
import com.project.bookstore.domain.User;
import com.project.bookstore.service.QnaCommentService;
import com.project.bookstore.service.QnaService;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaservice;
	

	
	//qna insert
	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()") //ㄱ로그인되있으면 글쓸수있게 
	public String insert() {
		return "/qna/insert";
	}
	
	@PostMapping("insert")
	public String insert(QnaBoard qboard,@AuthenticationPrincipal PrinpalDetatils principal) {
		qnaservice.insert(qboard,principal.getUser());
		
		return "redirect:/qna/list";
	}
	
	//qna ()===============================
	@GetMapping("list")
	public String list(Model model,
			@PageableDefault(size = 5, sort= "qnaNo",
			direction = Sort.Direction.DESC) Pageable pageable) {
		
		Page<QnaBoard> lists = qnaservice.list(pageable);
//		List<Board> lists = bservice.list();
		Long count = qnaservice.count();
//		String name = principal.getUsername();
		model.addAttribute("lists",lists);
		model.addAttribute("count",count);
		model.addAttribute("rowNo", qnaservice.count()-(lists.getNumber()*5)) ; //p2 ( 6-5
		return "/qna/list";
	}
	
	//상세보기
	@GetMapping("detail/{num}")
	public String detail(Model model, @PathVariable int num) {
		QnaBoard qboard = qnaservice.findById(num);
		model.addAttribute("qboard", qboard);
		//System.out.println(board.getComments().get(0));
		
		return "/qna/detail";
	}
	
	//삭제
	
	@ResponseBody
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		System.out.println("qboard 삭제 실행");
		qnaservice.deleteById(id);
		return "success";
	}
	
	//수정폼
	@GetMapping("update/{num}")
	public String update(@PathVariable int num,Model model) {
		System.out.println("수정하기폼 실행");
		model.addAttribute("qboard", qnaservice.view(num));
		return "/qna/update";
	}
	
	//수정하기
	@PutMapping("update/{num}")
	@ResponseBody
	public String update(@RequestBody QnaBoard qboard) {
		System.out.println("수정하기 실행");
		qnaservice.update(qboard);
		return "success";
	}
	
	
	
	
	
	
	
}







