<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<div class="container">
	<form action="/login" method="post">
		<div class="form-group">
			<label for="username">아이디:</label> 
			<input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
		</div>
		<div class="form-group">
			<label for="password">비밀번호:</label> 
			<input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
		</div>
		<button class="btn btn-secondary">로그인</button>
	</form>
	</div>
 </body>
</html>	