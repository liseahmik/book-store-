<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>  
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>  
 <sec:authorize access="isAuthenticated()">
 	<sec:authentication property="principal" var="principal"/>
 </sec:authorize>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3"  >
  <ul class="navbar-nav mr-auto">
    <li class="nav-item active">
      <a class="nav-link" href="/">Board</a>
    </li>
     <li class="nav-item active">
      <a class="nav-link" href="/board/list">BoardLIST</a>
    </li>
  </ul>
 

 

  <ul class="navbar-nav " >
    <li class="nav-item ">
      <a class="nav-link" href="/user/register">회원가입</a>
    </li>
     <li class="nav-item ">
      <a class="nav-link" href="user/login">로그인</a>
    </li>
  </ul>

  
  <sec:authorize access="isAuthenticated()">
  <ul class="navbar-nav " >
    <li class="nav-item ">
      <a class="nav-link" href="/logout">로그아웃(<sec:authentication property="principal.user.username"/>)</a>
    </li>
  </ul>
  </sec:authorize>
  
</nav>
	
