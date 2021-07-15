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
		
	<input hidden="coupon_no" id="coupon_no" name="coupon_no">
	<input hidden="userNo" id="userNo" name="userNo">
	
		<div class="form-group">
			<label for="username">ID</label>
			<input type="text" class="form-control" id="username" placeholder="Enter username" name="username" >
			<button  id="duplicate_check" type="button" class="btn btn-primary" onclick="check()">중복확인</button>
			<span class="helper-text" id="idDupMessage">*아이디는 필수 입력 항목입니다.</span>
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
			<label for="name">Name</label>
			<input type="text" class="form-control" id="name" placeholder="Enter phone" name="name">
		</div>
		
		<div class="form-group">
			<label for="phone">Phone</label>
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
	
	

<!-- --------------------------------------------------------  -->



<script>


function check() {
	var inputId = $("#username").val();
	
	if(inputId.length == 0 ) { //inputId == '' 
		alert('아이디를 입력하세요.');
		$('#username').focus();
		return;
	}
	//window.name = "parentForm";
	
	$.ajax({
		url:'/joinIdDupChk',
		data: {id: inputId}, // 키(id):벨류(inputId)
		method: 'GET',
		success:function (data) {
			console.log(typeof data);
			console.log(data);
			
			if(data == "1")
			$('#idDupMessage').html("<font color='green'> 사용가능한 아이디입니다");
			
			if(data == "0")
				$('#idDupMessage').html("<font color='red'> 사용불가능한 아이디입니다");
		}
	});
	
}




function goPopup() {
	var pop = window.open("/jusoPopup", "pop",
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
	
<script >


  
  
$("#btnJoin").click(function() {
	
	if($("#username").val() == "") {
		alert("아이디를 입력하세요");
		$("#username").focus();
		return false;
	}
	
	if($("#password").val() == "") {
		alert("패스워드를 입력하세요");
		$("#password").focus();
		return false;
	}
	
	if($("#email").val() == "") {
		alert("이메일를 입력하세요");
		$("#email").focus();
		return false;
	}
	
	if($("#name").val() == "") {
		alert("이름을 입력하세요");
		$("#email").focus();
		return false;
	}
	
	if($("#phone").val() == "") {
		alert("핸드폰 번호를 입력하세요");
		$("#email").focus();
		return false;
	}
	
	if($("#addr").val() == "") {
		alert("주소를 넣어주세요");
		$("#addr").focus();
		return false;
	}
	
	
	var data = {
			"username" : $("#username").val(),
			"password" : $("#password").val(),
			"email" : $("#email").val(),
			"name" : $("#name").val(),
			"phone" : $("#phone").val(),
			"addr" : $("#addr").val(),
		}
	
	$.ajax({
		type : "POST",
		url : "/register",
		contentType: "application/json;charset=utf-8",
		data : JSON.stringify(data)
		
	})
	.done(function(resp) {
		if(resp == "success") {
			alert("회원가입 성공 쿠폰이 지급되었습니다.");
			location.href="/";
		}else if (resp == "fail") {
			alert("아이디 중복");
			$("#username").val("");
		}
			
	})
	.fail(function(e) {
		alert("회원가입 실패")
	})
})


</script>
</body>
</html>