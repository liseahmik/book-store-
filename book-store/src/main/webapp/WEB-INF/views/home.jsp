<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
<h1>home</h1>
<!-- 사이트 제목 , 검색  -->
	<div class = "container">
		<div class="container-fluid full-width">
		<div class="row">	
			
			<div class="col-md-3">
			<a href = "${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/resources/images/rogo.jpg" width = "200" height = "80" /> </a>
			</div>
			
			<div class="col-md-6">
			<form class="form-inline" action="${pageContext.request.contextPath}/product/select" method="get" style ="float:right"  >
				 	<input type="text" name="txt" class="pull-right form-control" placeholder="검색어를 입력하세요"/>
				 	<input type="submit" class=" pull-right form-control"  value="Search"/>
			</form>
			</div>
			
		</div>
		</div>
	</div>
<hr/>

<img src="${pageContext.request.contextPath}/resources/images/1.jpg" alt="First slide" > 
</div>
</body>
</html>