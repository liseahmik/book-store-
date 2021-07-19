<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../includes/header.jsp"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>





<div class="container">
	<h1>장바구니 </h1> <hr/> <br/><br/><br/>
	<input type="hidden" value="${cart.cartNo}" name="cartNo">
	<input type="hidden" value="${user.userNo}" name="userNo">
	<h1></h1>
	<c:forEach items="${clists}" var="product" >
		
		<div class="d-flex">
		<img src="data:image/jpg;base64,${product.product.base64}" width="300px" height="300px">
		
		<div class="ml-auto"> <br/>
		<br/><h2>책이름 : ${product.product.productName }</h2>
		<br/><h2 id="price">가격   : ${product.product.productPrice }</h2>
		<h3>${product.couponapply}</h3>
		<%-- <h2> 카트번호: <input type="text" readonly="readonly" value="${product.cartNo}" > </h2> --%>
		<c:choose >
		<c:when test="${product.couponapply eq 0}">
		<button class="btn btn-info btn-sm"  type="button" onclick="discount(${product.user.couponNo},${product.cartNo })">쿠폰적용</button>
		</c:when>
		<c:otherwise>
		<button class="btn btn-info btn-sm"  type="button" onclick="back(${product.product.productNo},${product.cartNo })">쿠폰적용취소하기</button>
		</c:otherwise>
		</c:choose>
		<br/><h2 >수량   : ${product.qty }</h2>
		</div>
		<%-- onclick="cuponbtn(${user.couponNo})" --%>
		
		
		<div class="ml-auto">
		<br/><br/><br/><br/><br/>
		<form action="#" method="post">
			<button type="button" class="btn btn-primary"  onclick="xdelete(${product.cartNo});"  >X</button>
<c:if test="${!empty msg}">
	<script >
		alert("남은 쿠폰이 없습니다");
	</script>
	</c:if>
		</form>
		</div>
		</div>
		<br/><hr/><br/>
	</c:forEach>
	
	<div class="d-flex">
	<h2>총 상품금액 : ${sum }</h2>
	
	<div class="ml-auto">
	<form action="/cart/order" method="post">
	<button class="btn btn-primary btn-lg">주문하기</button>
	</form>
	</div>
	
	</div>
	
	
	
	
	<br/><br/><br/>
	
	
	
</div>

<script>


function xdelete(cartNo) {
	if(!confirm("정말 삭제하시겠습니까?"))
		return false;
	
	$.ajax({
		type : "DELETE",
		url : "/cart/delete/"+cartNo
	})
	.done(function(resp) {
		alert("삭제성공")
		location.href = "/cart/cartlist"
	})
}




  function discount(couponNo,cartNo) {
	
	  
	if(couponNo < 1) {
		alert("남은쿠폰이 없습니다.")
		
	} else {
			
		if(!confirm("정말 사용하시겠습니까?"))
			return false;
		
		$.ajax({
			type: "PUT",
			url : "/coupon"
		})
		.done(function(resp) {
		alert("사용 성공" + resp);
		location.href="/cart/cartlist/"+cartNo+"?resp="+resp;
		
	})	
	}
}   

  function back(couponNo,cartNo) {
	  if(!confirm("정말 취소하시겠습니까?"))
			return false;
	  $.ajax({
		  type: "PUT",
		  url : "/couponback"
	  })
	  .done(function(resp) {
		 	alert("사용 성공" + resp);
			location.href="/cart/cartlistback/"+cartNo+"?resp="+resp;
	  })
	  
  }


/*   $(document).ready(function(couponNo) {
	$(document).on("click", "#couponbtn",function() {
		
		
		
		if(${user.couponNo } < 1) {
			alert("남은쿠폰이 없습니다.")
			
		} else {
			
			
			if(!confirm("쿠폰이"+${user.couponNo }+"장 남았습니다 "+"정말 사용하시겠습니까?"))
				return false;
			
			
			$.ajax({
				type: "PUT",
				url : "/coupon",
				
			})
			.done(function(resp) {
			alert("사용 성공" + resp);
			location.href="/cart/cartlist?resp="+resp;
		})	
		}
	}) 
})  
 */

</script>

</body>
</html>