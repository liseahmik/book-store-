<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>  
<html>
	<head>
		<title>이름도 못정한 온라인 서점</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
	
		<nav class="navbar navbar-expand-sm bg-light">
			<div class="container">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/">HOME</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/list">test</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/domestic">국내도서</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/international">해외도서</a></li>
				<li class="nav-item"><a class="nav-link" href="/qna">Q & A</a></li>
				<li class="nav-item"><a class="nav-link" href="/cart/cartlist">장바구니</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/insert">상품등록</a></li>
				<sec:authorize access="isAnonymous()">
  <ul class="navbar-nav " >
    <li class="nav-item ">
      <a class="nav-link" href="/register">회원가입</a>
    </li>
     <li class="nav-item ">
      <a class="nav-link" href="/login">로그인</a>
    </li>
  </ul>
  </sec:authorize>
  <sec:authorize access="isAuthenticated()">
  <ul class="navbar-nav " >
    <li class="nav-item ">
      <a class="nav-link" href="/logout">로그아웃(<sec:authentication property="principal.user.username"/>)</a>
    </li>
  </ul>
  </sec:authorize>
				<li class="nav-item dropdown">
          			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-expanded="false">마이페이지</a>
         			<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			            <li><a class="dropdown-item" href="/modifyUser">내정보수정</a></li>
			            <li><a class="dropdown-item" href="/myOrder">내주문보기</a></li>
			            <li><a class="dropdown-item" href="/deleteAccount">회원탈퇴하기</a></li>
			        </ul>
        		</li>
        		<li class="nav-item dropdown">
          			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-expanded="false">관리자페이지</a>
         			<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			            <li><a class="dropdown-item" href="/customer">회원관리</a></li>
			            <li><a class="dropdown-item" href="/orderList">주문관리</a></li>
			        </ul>
        		</li>		
			</ul>
			</div>
		</nav>
		<br>
	
		<div class="container-fluid">
			
		</div>
	
	</body>
</html>

