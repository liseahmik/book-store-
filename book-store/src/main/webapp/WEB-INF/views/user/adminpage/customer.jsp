<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../../includes/header.jsp"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	
	<body>	
		<div class="container">
			<h2>회원관리</h2>
			<p>회원 정보를 조회해 보세요.</p>
			<input class="form-control" id="myInput" type="text" placeholder="Search...">
			<br>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>회원번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th>주소</th>
						<th>연락처</th>
						<th>이메일</th>
						<th>가입날짜</th>
	
					</tr>
				</thead>
				<tbody id="myTable">
					<c:forEach items="${lists }" var="board">
						<tr>
							<td>${board.userNo }</td>
							<td>${board.username }</td>
							<td>${board.name }</td>
							<td>${board.addr }</td>
							<td>${board.phone }</td>
							<td>${board.email }</td>
							<td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>
	
	
	
		<script>
			$(document).ready(function(){
			  $("#myInput").on("keyup", function() {
			    var value = $(this).val().toLowerCase();
			    $("#myTable tr").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
			  });
			});
		</script>
	</body>
</html>	