<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
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
	
<div class="form-group text-right">

		<a href="/product/insert">
		<button type="button" class="btn btn-primary btn-sm" id="writeBtn">상품등록</button>
		</a>
	</div>
	<div class="container">
		<table class="table table-hover">
		
			<thead>
				<th>번호</th>
				<th>이미지</th>
				<th>제목</th>
				<th>가격</th>
				

			</thead>

			<c:forEach items="${lists.content}" var="product" varStatus="st">
				<tbody>
					
					<tr onclick="location.href='http://localhost:8866/product/detail/'+${product.productNo}">	
						<td>${rowNo-st.index }</td>
						<td><img src="data:image/png;base64,${product.base64}" width="100px" height="100px"> </td>
						<td>${product.productName}</td>
						<td>${product.productPrice }</td>
					
					</tr>
					
				</tbody>

			</c:forEach>
			
		</table>
			<ul class="pagination">
				<c:if test="${lists.first  ==false }">
					<li class="page-item"><a class="page-link" href="?page=${lists.number-1}">Previous</a></li>
				</c:if>
				<c:if test="${lists.last == false}">
					<li class="page-item"><a class="page-link" href="?page=${lists.number+1}">Next</a></li>
				</c:if>
			</ul>

		</div>
		</div>
</body>
</html>