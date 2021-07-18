<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../includes/header.jsp"%>

<!DOCTYPE html>
<html>

<body>


	<div class="container">
		<h1>내 정보 수정하기</h1>
		
		<input hidden="coupon_no" id="coupon_no" name="coupon_no">
		<input hidden="userNo" type="text" name="userNo" id="userNo" value="${user.userNo}">
	
		<div class="form-group">
			<label for="username">ID</label>
			<input type="text" class="form-control" id="username" name="username" value="${user.username }" readonly="readonly">
			<span class="helper-text" id="idDupMessage">*아이디는 변경할 수 없습니다.</span>
		</div>



		<div class="form-group">
			<label for="pwd">PW</label>
			<input type="password" class="form-control" id="password" placeholder="변경할 비밀번호를 입력하세요." name="password">
		</div>

		<div class="form-group">
			<label for="pwd">Confirm PW</label>
			<input type="password" class="form-control" id="password2" placeholder="비밀번호를 재입력하세요." name="password2">
		</div>
		
		<p id="pwCheckF" style="color: #FF6600; margin: 0;"></p>
		<p id="pwCheckFF" style="color: #FF6600; margin: 0;"></p>
		
		<div class="form-group">
			<label for="name">Name</label>
			<input type="text" class="form-control" id="name" name="name" value="${user.name }" readonly="readonly">
			<span class="helper-text" id="idDupMessage">*이름은 변경할 수 없습니다.</span>
		</div>
		
		<div class="form-group">
			<label for="phone">Phone</label>
			<input type="text" class="form-control" id="phone" value="${user.phone }" name="phone">
		</div>

		<div class="form-group">
			<label for="email">Email:</label>
			<input type="email" class="form-control" id="email" value="${user.email }" name="email">
		</div>

		<div class="form-group">
			<div class="d-flex justify-content-end">
				<button type="button" class="btn btn-info" onClick="goPopup();">주소검색</button>
			</div>
			<input type="text" class="form-control" id="addr" name="addr" value="${user.addr }" readonly="readonly" >

		</div>

		<button type="button" class="btn btn-primary" id="btnUpdate">수정하기</button>
	</div>
	<script>
	$("#btnUpdate").click(function(){
		var dataParam = {
			"password" : $("#password").val(),
			"phone" : $("#phone").val(),
			"email" : $("#email").val(),
			"addr" : $("#addr").val(),
			"userNo" : $("#userNo").val(),
		}
		$.ajax({
			type: "PUT",
			url: "/modifyUser/",
			data: JSON.stringify(dataParam),
			contentType:"application/json;charset=utf-8"
		})
		.done(function(){
			alert("성공적으로 수정되었습니다.")
		})
		.fail(function(){
			alert("ERROR");
		})
		
	})
	


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

</body>
</html>	