<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../includes/header.jsp"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<img src="data:image/jpg;base64,${product.base64}" width="300px" height="410px">
	
	<div class="container">
	<h2>${product.productName}  </h2> 
	<p>${product.writer }</p> <p><fmt:formatDate value="${product.productDate }" pattern="yyyy-MM-dd" /> </p> <hr/>
	
	<h2>정가 : ${product.productPrice} </h2><p>(10% 할인)</p>
	<h2>할인가 : <fmt:parseNumber value="${product.productPrice * 90/100}" integerOnly="true" /></h2> <br/> 
	
	<form action="/cart/insert" method="post">
	<input type="hidden" name="productNo" value="${product.productNo }">
	수량 <input type="number" value="1" name="qty"> <br/> <br/>
	<button type="submit" class="btn btn-primary btn-lg ">장바구니에 담기</button>
	<c:if test="${!empty msg}">
	<script >
		alert("이미 장바구니에 있습니다");
	</script>
	</c:if>
	</form>
	</div>

</div>
	<hr/>
	<div>
	<h3>줄거리 </h3> <br/>
	<p>${product.content} </p> 

	</div>
</div>

<script>

</script>
</body>
</html>