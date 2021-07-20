<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<br />
	<h2>QnA</h2>
	<br />
	
	<table class="table table-hover">
		
			<thead>
				
				<div>
				<span style="margin-right : 30px">글번호: ${qboard.qnaNo}</span> <span style="margin-right : 30px"> 작성자: ${qboard.user.username }</span>
				<span >작성일 : ${qboard.qnaDate }</span>
				
				
				</div>
			</thead>

			
				<tbody>
					<tr>	
						<td>${qboard.content}</td>
					</tr>
				</tbody>

		
			
		</table>
		<br/>

 	 <div class="form-group">
			<input type="hidden" class="form-control" id="num" name="num" value="${qboard.qnaNo}" readonly="readonly">
		</div>
		<div class="form-group">
			<input type="hidden" class="form-control" id="title" name="title" value="${qboard.title}" readonly="readonly">
		</div>
		<div class="form-group">
			<input type="hidden" class="form-control" id="writer" name="writer" value="${qboard.user.username }" readonly="readonly">
		</div>
		<div class="form-group">
<%-- 			<label for="content">내용:</label>
			<textarea id="content" name="content" class="form-control" readonly="readonly">${qboard.content}</textarea>
 --%>		</div>
		
		<c:if test="${principal.user.username == qboard.user.username }">
		<button type="button" id="btnUpdate" class="btn btn-primary btn-sm">수정하기</button>
		<button type="button" id="btnDelete" class="btn btn-danger btn-sm">삭제하기</button>
		</c:if>
		
 </div>
<br/><br/>
<div class="container">
<textarea rows="3" cols="100" id="msg"></textarea>
<input type="button" value="댓글쓰기" class="btn btn-secondary btn-sm" id="btnComment">
</div>


<div id="replyResult"></div>
<hr/>
<div class="container">
<table class="table table-boarderless">
<c:forEach items="${qboard.qnacomments }" var="comment" >
	<tr>
		<td>${comment.qnacomNo }</td>
		<td>${comment.content }</td>
		<td><fmt:formatDate value="${comment.qnacomDate }" pattern="yyyy-MM-dd" /></td>
	</tr>
</c:forEach>
</table>
</div> 

<script>
 var init = function() {
	//alert($("#num").val());
	$.ajax({
		type: "GET",
		url: "/reply/list/"+$("#num").val()
		
	})
	.done(function(resp) {
		//alert("실행됨" + resp.length);
		var str = "";
		$.each(resp, function(key, val) {
			/* str += val.user.id+" " */
			str += val.content+" "
			str += val.regdate+"<br/> "
		})
		/* $("#replyResult").html(str); */
	})
	.fail(function(e) {
		alert("error : " + e);
	})
}


//댓글쓰기
$("#btnComment").click(function() {
	if(${empty principal.user}) {
		alert("로그인하세요");
		location.href="/login";
		return;
	}
	if($("#msg").val()=="") {
		alert("댓글을 적으세요");
		return;
	}
	
	data = {
			"bnum" : $("#num").val(),
			"content" : $("#msg").val()
	}
	$.ajax({
		type: "POST",
		url: "/reply/insert/"+$("#num").val(),
		contentType: "application/json;charset=utf-8",
		data: JSON.stringify(data)
	})
	.done(function() {
		alert("댓글 추가성공");
		location.href = "/qna/detail/"+${qboard.qnaNo}
	})
	.fail(function() {
		alert("댓글 추가 실패")
	})
	
})


//삭제
$("#btnDelete").click(function() {
	if(!confirm("정말 삭제하시겠습니까?"))
		return false;
	$.ajax({
		type : "DELETE",
		url :"/qna/delete/"+${qboard.qnaNo}
	})
	.done(function(resp) {
		if(resp=="success") {
		alert("삭제성공")
		location.href = "/qna/list"
		}
	})
})

//수정폼
$("#btnUpdate").click(function() {
	if(!confirm("정말 수정하시겠습니까?"))
		return false;
	location.href="/qna/update/${qboard.qnaNo}"
})

 init(); 
</script>

</body>
</html>
