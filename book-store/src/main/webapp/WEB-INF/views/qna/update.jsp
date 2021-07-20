<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<div class="container">
	<br />
	<h2>${qboard.user.username } 의 글 수정</h2>
	<input type="hidden" name="qnaNo" id="qnaNo" value="${qboard.qnaNo}" />
	<br />
	<form action="update" method="post" >
		<div class="form-group">
			<label for="title">제목:</label>
			<input type="text" class="form-control" id="title" name="title">
		</div>
		<div class="form-group">
			<label for="writer">글쓴이:</label>
			<input type="text" class="form-control" id="writer" 
			name="writer" value="${principal.user.username}" readonly="readonly">
		</div>
		

		
		<div class="form-group">
			<label for="content">내용:</label>
			<textarea id="content" name="content" class="form-control"></textarea>
		</div>
		<button type="button" class="btn btn-primary" id="btnModify">수정하기</button>
	</form>
</div>

<script>
$("#btnModify").click(function() {
	if(!confirm("정말 수정하시겠습니까?"))
		false;
	
	let data = {
			"qnaNo" : $("#qnaNo").val(),
			"title" : $("#title").val(),
			"content" : $("#content").val()
	}
	
	$.ajax({
		type : "PUT",
		url :"/qna/update/"+${qboard.qnaNo},
		contentType: "application/json;charset=utf-8",
		data: JSON.stringify(data)
	})
	.done(function(resp) {
		if(resp=="success") {
		alert("수정성공")
		location.href = "/"
		}
	})
})

</script>
</body>
</html>
