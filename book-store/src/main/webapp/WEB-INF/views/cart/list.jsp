<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../includes/header.jsp"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>장바구니</h1> <hr/> <br/><br/><br/>
	
	<c:forEach items="${clists}" var="product" >
		
		<div class="d-flex">
		<img src="data:image/jpg;base64,${product.product.base64}" width="300px" height="300px">
		
		<div class="ml-auto"> <br/>
		<br/><h2>책이름 : ${product.product.productName }</h2>
		<br/><h2>가격   : ${product.product.productPrice }</h2>
		<br/><h2>수량   : ${product.qty }</h2>
		</div>
		
		
		
		<div class="ml-auto">
		<br/><br/><br/><br/><br/>
		<form action="#" method="post">
			<input type="checkbox" name="cartck">
		</form>
		</div>
		</div>
		<br/><hr/><br/>
	</c:forEach>
	
	<div class="d-flex">
	<h2>총 상품금액 : ${sum }</h2>
	
	</div>
	
	
	
	
	<br/><br/><br/>
	
	
	
</div>
</body>
</html>