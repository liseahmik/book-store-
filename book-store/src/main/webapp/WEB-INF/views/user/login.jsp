<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="../includes/header.jsp"%>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<sec:authorize access="isAnonymous()">
		<form name="loginfrm" action="/login" method="post">
			<h2>로그인하기</h2>
			<div class="form-group">
				<label for="username">아이디:</label> 
				<input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
			</div>
			<div class="form-group">
				<label for="password">비밀번호:</label> 
				<input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-secondary" id="btn-Login">로그인</button><br><br>
				<div>
					<c:if test="${param.error ne null }">
	                	<p class="alert alert-danger">${param.exception }</p>
	                </c:if>
                </div>
			</div>
		</form>
		</sec:authorize>
	</div>
	
	<script>
	$(document).ready(function(){
        $("#btn-Login").click(function(){
            var username = $("#username").val();
            var password = $("#password").val();
            if(username == ""){
                alert("아이디를 입력하세요.");
                $("#username").focus();
                return;
            }
            if(password == ""){
                alert("비밀번호를 입력하세요.");
                $("#password").focus();
                return;
            }
      	});
    });
	
	
	
// 	$("#btnJoin").click(function() {
// 		$.ajax({
// 			type : "POST",
// 			url : "/register",
// 			contentType: "application/json;charset=utf-8",
// 			data : JSON.stringify(data)
			
// 		});
// 		.done(function(resp) {
// 			if(resp == "success") {
// 				alert("로그인 되었습니다.");
// 				location.href="/";
// 			}
// 		});
// 	});
	</script>
</body>
</html>	