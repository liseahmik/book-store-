<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../../includes/header.jsp"%>

<!DOCTYPE html>
<html>
	
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
					<c:forEach items="${lists.content }" var="board">
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
			<ul class="pagination justify-content-center" style="margin:20px 0">
			  <li class="page-item"><a class="page-link" href="?page=${lists.number-1 }">Previous</a></li>
			  
			  <!-- 수정 필요 -->
			  <li class="page-item active"><a class="page-link" href="?page=${lists.number }">${lists.number+1}</a></li>
			  
			  <li class="page-item"><a class="page-link" href="?page=${lists.number+1 }">Next</a></li>
			</ul>
			
			<c:choose>
				<c:when test="${lists.first }">
				</c:when>
				<c:when test="${lists.last }">
				</c:when>
			</c:choose>
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