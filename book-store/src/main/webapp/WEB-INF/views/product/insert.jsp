<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header2.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>


	<div class="container">
		<h1>상품등록</h1>
		<hr/>
	<form action="/product/insert" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="productName">책제목</label>
			<input type="text" class="form-control" id="productName" placeholder="Enter username" name="productName" >
		</div>

		<div class="form-group">
			<label for="productDate">카테고리</label> <br/>
			국내도서<input type="checkbox"  id="cate" name="cate" value="domestic">
			외국도서<input type="checkbox"  id="cate" name="cate" value="foreign">
		</div>

		<div class="form-group">
			<label for="writer">지은이</label>
			<input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer">
		</div>
		
		<div class="form-group">
			<label for="productDate">출간일자</label>
			<input type="date" class="form-control" id="productDate" placeholder="Enter productDate" name="productDate">
		</div>
		
		<div class="form-group">
			<label for="phone">가격</label>
			<input type="number" class="form-control" id="productPrice" placeholder="Enter productPrice" name="productPrice">
		</div>

		<div class="form-group">
			<label for="email">책정보</label><br/>
			<textarea rows="7" cols="155" name="content"></textarea>
		</div>

		<div class="form-group">
			<label for="image">이미지</label>
			<input type="file" class="form-control" id="files" name="files">
		</div>
		


		
		<button type="submit" class="btn btn-primary" id="btnJoin">등록하기</button>
	</form>
	</div>
	
	

<!-- --------------------------------------------------------  -->


</body>
</html>