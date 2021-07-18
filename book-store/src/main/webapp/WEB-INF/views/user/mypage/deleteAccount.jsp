<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../includes/header.jsp"%>
<html>
<head>
	<script src= http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js></script>
</head>
<body>


	<input hidden="userNo" type="text" name="userNo" id="userNo" value="${user.userNo}">
	<div class="container">
	
			정말 탈퇴 하시겠습니까?<br>
			<button type="button" class="btn btn-secondary" id="btnDelete">예</button>

	</div>
	<script>
	$("#btnDelete").click(function(){
		$.ajax({
			type: "DELETE",
			url: "/deleteAccount/"+${user.userNo}
		})
		.done(function(resp){
			alert("탈퇴 되었습니다.")
			location.href="/"
		})
		.fail(function(resp){
			alert("탈퇴에 실패하였습니다.")
			location.href="/"
		})
	})
		
	</script>

</body>
</html>	