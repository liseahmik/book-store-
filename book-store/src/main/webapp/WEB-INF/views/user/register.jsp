<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
		<h1>회원가입</h1>

		<div class="form-group">
			<label for="username">ID</label>
			<input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
			<button type="button" class="btn btn-primary">중복확인</button>
		</div>



		<div class="form-group">
			<label for="pwd">PW</label>
			<input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
		</div>

		<div class="form-group">
			<label for="pwd">Confirm PW</label>
			<input type="password" class="form-control" id="password2" placeholder="Enter password" name="password2">
		</div>
		
		<p id="pwCheckF" style="color: #FF6600; margin: 0;"></p>
		<p id="pwCheckFF" style="color: #FF6600; margin: 0;"></p>

		<div class="form-group">
			<label for="username">Phone</label>
			<input type="text" class="form-control" id="phone" placeholder="Enter phone" name="phone">
		</div>

		<div class="form-group">
			<label for="email">Email:</label>
			<input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
		</div>

		<div class="form-group">
			<div class="d-flex justify-content-end">
				<button type="button" class="btn btn-info" onClick="goPopup();">주소검색</button>
			</div>
			<input type="text" class="form-control" id="addr" placeholder="Enter addr" name="addr" readonly="readonly">

		</div>

		<button type="button" class="btn btn-primary" id="btnJoin">회원가입</button>

	</div>

	<script>
		function goPopup() {
			var pop = window.open("/user/jusoPopup", "pop",
					"width=570,height=420, scrollbars=yes, resizable=yes");

		}

		function jusoCallBack(roadFullAddr) {
			var addrEl = document.querySelector("#addr");
			addrEl.value = roadFullAddr;
		}
		
$(document).ready(function(){
			$('#password').keyup(function(){
				$('#password2').text('');
			}); 
			
			$('#password2').keyup(function(){
				if($('#password').val()!=$('#password2').val()){
					$('#pwCheckFF').text('');
			  		$('#pwCheckFF').html("<font color='red'>패스워드가 일치하지 않습니다.");
			 	}else{
				  	$('#pwCheckFF').text('');
				  	$('#pwCheckFF').html("<font color='green'>패스워드가 일치합니다.</font>");
			 	}
			});
		 }); 
	</script>
</body>
</html>