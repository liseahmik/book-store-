<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../includes/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	

	<h1>상품 상세페이지</h1>
	
	<div class="d-flex">
	<img src="data:image/jpg;base64,${product.base64}" width="400px" height="500px">
	
	
	
	<div class="container">
	<h3>${product.productName}  </h3> <br/> 
	<h3>판매가 : ${product.productPrice}</h3>
	
	</div>


</div>
</div>
</body>
</html>