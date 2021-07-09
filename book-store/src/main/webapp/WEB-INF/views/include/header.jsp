<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


 <link rel="stylesheet" href="resources/css/main.css">

 
	<!-- Start Header Area -->
	<header class="header_area sticky-header">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light main_box">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<a class="navbar-brand logo_h" href="index"><img src="resources/img/logo3.png" alt=""></a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
					 aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto">
							<li class="nav-item active"><a class="nav-link" href="index">Home</a></li>
							<li class="nav-item submenu dropdown">
								<a href="productAllList" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">국내도서</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="productList?categoryCode=101">컴퓨터</a></li>
									<li class="nav-item"><a class="nav-link" href="productList?categoryCode=102">어린이</a></li>
									<li class="nav-item"><a class="nav-link" href="productList?categoryCode=103">여행</a></li>
									<li class="nav-item"><a class="nav-link" href="productList?categoryCode=104">소설</a></li>
									<li class="nav-item"><a class="nav-link" href="productList?categoryCode=105">과학</a></li>
								</ul>
							</li>
							<li class="nav-item submenu dropdown">
								<a href="productAllList" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">외국도서</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="productList?categoryCode=501">소설/시/희곡</a></li>
									<li class="nav-item"><a class="nav-link" href="productList?categoryCode=502">인문/사회</a></li>
								</ul>
							</li>
							
							<sec:authorize access="isAnonymous()">
							<li class="nav-item submenu dropdown">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">로그인</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="customLogin">로그인</a></li>
									<li class="nav-item"><a class="nav-link" href="join">회원가입</a></li>
								</ul>
							</li>
							</sec:authorize>
							<sec:authorize access="hasRole('ROLE_USER')">
							<li class="nav-item submenu dropdown">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">로그아웃</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="customLogout">로그아웃</a></li>
									<li class="nav-item"><a class="nav-link" href="mypage">마이페이지</a></li>
								</ul>
							</li>
							</sec:authorize>
							<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li class="nav-item submenu dropdown">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">관리자페이지</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="customLogout">로그아웃</a></li>
									<li class="nav-item"><a class="nav-link" href="userList">회원관리</a></li>
							<!-- 		<li class="nav-item"><a class="nav-link" href="productRegister">상품관리</a></li> -->
									<li class="nav-item"><a class="nav-link" href="orderList">주문관리</a></li>
									<li class="nav-item"><a class="nav-link" href="qnaList">1:1문의관리</a></li>
								</ul>
							</li>
							</sec:authorize>
							
							<li class="nav-item"><a class="nav-link" href="#">고객센터</a>
							
						<!--	<li class="nav-item submenu dropdown">
								<a href="qnaboard" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">고객센터</a>
						 		<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
									<li class="nav-item"><a class="nav-link" href="tracking.html">Tracking</a></li>
									<li class="nav-item"><a class="nav-link" href="elements.html">Elements</a></li>
								</ul>  -->
							</li>
							<li class="nav-item"><a class="nav-link" href="cartList">장바구니</a>
				<!-- 		<sec:authorize access="hasRole('ROLE_USER')">
							( ${cartSize} )
							</sec:authorize> -->
							</li>
						</ul>
				<!-- 		<ul class="nav navbar-nav navbar-right">
							<li class="nav-item"><a href="#" class="cart"><span class="ti-bag"></span></a></li>
							<li class="nav-item">
								<button class="search"><span class="lnr lnr-magnifier" id="search"></span></button>
							</li>
						</ul>  -->
					</div>
				</div>
			</nav>
		</div>
		<div class="search_input" id="search_input_box">
			<div class="container">
				<form class="d-flex justify-content-between">
					<input type="text" class="form-control" id="search_input" placeholder="Search Here">
					<button type="submit" class="btn"></button>
					<span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
				</form>
			</div>
		</div>
	</header>
	<!-- End Header Area -->
	
