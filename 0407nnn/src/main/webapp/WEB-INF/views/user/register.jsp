<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.js"></script>
<style>
header {
	display: flex
}
.wrap {
	text-align: center;
}
</style>
<title>회원가입 페이지</title>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		// 취소
		$("#cancle").on("click", function() {
			location.href = "/mvc/index.jsp";
		})

		$("#submit").on("click", function() {
			if ($("#user_id").val() == "") {
				alert("아이디를 입력해주세요!!");
				$("#user_id").focus();
				return false;
			}
			if ($("#user_pw").val() == "") {
				alert("비밀번호를 입력해주세요!!");
				$("#user_pw").focus();
				return false;
			}
			if ($("#user_pw").val() == "") {
				alert("비밀번호를 입력해주세요!!");
				$("#user_pw").focus();
				return false;
			}
			if ($("#user_pw_check").val() == "") {
				alert("비밀번호 확인을 입력해주세요!!");
				$("#user_pw_check").focus();
				return false;
			}
			if ($("#user_pw").val() != $("#user_pw_check").val()) {
				alert("비밀번호가 달라요..ㅠㅠ");
				$("#user_pw").val("");
				$("#user_pw_check").val("");
				$("#user_pw").focus();
				return false;
			}
			if ($("#user_phone").val() == "") {
				alert("전화번호를 입력해주세요.");
				$("#user_phone").focus();
				return false;
			}
			if ($("input[name='checked_id']").val() == "") {
				alert('아이디 중복 확인을 부탁드려요~!');
				$("input[name='checked_id']").focus();
				return false;
			}
			if ($("input[name='checked_email']").val() == "") {
				alert('이메일 중복 확인을 부탁드려요~!');
				$("input[name='checked_email']").focus();
				return false;
			}
			if (($("input[name='checked_email']").val() == "Y") && ($("input[name='checked_id']").val() == "")) {
				return true;
			}
		});
				
		// 이메일 유효성 검사 정규식
		function email_check(email) {
		    var regexEmail=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		    return (email != '' && email != 'undefined' && regexEmail.test(email));
		}
		// 포커스 벗어 날 때 검사
		$("input[name='user_email']").blur(function() {
			var email = $(this).val();
			// 값을 입력안한경우는 아예 체크를 하지 않는다. 
			if (email == '' || email == 'undefined')
				return;
			// 이메일 유효성 검사 
			if (!email_check(email)) {
				alert('잘못된 형식의 이메일 주소입니다.');
				$("#user_email").val("");
				return false;
			}
		});
		
		// 전화번호 유효성 검사 정규식
		function phone_ck(phone) {
		    var regexPhone=/^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-[0-9]{3,4}-[0-9]{4}$/;
		    return (phone != '' && phone != 'undefined' && regexPhone.test(phone));
		}
		// 포커스 벗어 날 때 검사
		$("input[name='user_phone']").blur(function() {
			var phone = $(this).val();
			// 값을 입력안한경우는 아예 체크를 하지 않는다
			if (phone == '' || phone == 'undefined')
				return;
			// 이메일 유효성 검사
			if (!phone_ck(phone)) {
				alert('잘못된 형식의 전화번호에요..');
				$("#user_phone").val("");
				return false;
			}
		});
		
		// 아이디 영문,숫자 검사 정규식
		function id_ck(id) {
		    var regexId = /^[A-z]+[A-z0-9]{4,14}$/g;
		    return (id != '' && id != 'undefined' && regexId.test(id));
		}
		// 포커스 벗어 날 때 검사
		$("input[name='user_id']").blur(function() {
			var id = $(this).val();
			// 값을 입력안한경우는 아예 체크를 하지 않는다
			if (id == '' || id == 'undefined')
				return;
			// 이메일 유효성 검사
			if (!id_ck(id)) {
				alert('아이디는 영문자로 시작하는 5~15자 영문자 또는 숫자만 입력가능하답니다~~ ㅠㅠ');
				$("#user_id").val("");
				return false;
			}
		});
	});

	// 아이디 중복 체크
	function id_Check() {
		if ($("#user_id").val() == "") {
			alert("아이디를 입력해주세요!!");
			$("#user_id").focus();
			return false;
		}
		
		$.ajax({
			url : "idCheck",
			type : "post",
			dataType : "json",
			data : {
				"user_id" : $("#user_id").val()
			},
			success : function(data) {
				if (data == 1) {
					alert("중복된 아이디에요..ㅠㅠ");
					$("#user_id").val("");
					$("#user_id").focus();
				} else if (data == 0) {
					$("#idCheck").attr("value", "Y");
					alert("사용가능한 아이디입니다!!");
				}
			}
		})
		$("input[name=checked_id]").val('y');
	}

	// 이메일 중복 체크
	function email_Check() {
		if ($("#user_email").val() == "") {
			alert("이메일를 입력해주세요.");
			$("#user_email").focus();
			return false;
		}

		$.ajax({
			url : "emailCheck",
			type : "post",
			dataType : "json",
			data : {
				"user_email" : $("#user_email").val()
			},
			success : function(data) {
				if (data == 1) {
					alert("중복된 이메일입니다.");
					$("#user_email").val("");
					$("#user_email").focus();
				} else if (data == 0) {
					$("#emailCheck").attr("value", "Y");
					alert("사용 가능한 이메일입니다.");
				}
			}
		})
		$("input[name=checked_email]").val('y');
	}
</script>
<body>
	<div class="wrap">
		<h2>회원 가입을 환영합니다!❤</h2>
		<section id="container">
			<form action="register" method="POST" class="form" id="was-validated">

				<label class="control-label" for="user_id">아이디</label> <input
					class="form-control" type="text" id="user_id" name="user_id" 
					placeholder="영문자로 시작하는 5~15자 영문자 또는 숫자를 입력해주세요 ^^"/>
				<div style='width: 80px; float: right;'>
					<button class="heck btn btn-secondary" type="button" id="idCheck"
						onclick="id_Check();" value="N">중복확인</button>
				</div>
				<br /> <br /> 
				<label class="control-label" for="user_pw">패스워드</label> <input
					class="form-control" type="password" id="user_pw" name="password" /><br />
				<label class="control-label" for="user_pw">패스워드 확인</label> <input
					class="form-control" type="password" id="user_pw_check" name="user_pw_check" /><br />

				<!-- 전화번호 입력 -->
				<label class="control-label" for="user_phone">전화번호</label> <input
					class="form-control" type="text" id="user_phone" name="user_phone"
					placeholder=" ' - '을 포함하여 입력해주세요 ^^" /><br />

				<label class="control-label" for="user_email">이메일</label> <input
					class="form-control" type="text" id="user_email" name="user_email"
					placeholder=" 이메일 형식에 맞게 입력해주세요 ^^" />
				<div style='width: 80px; float: right;'>
					<button class="heck btn btn-secondary" type="button"
						id="emailCheck" onclick="email_Check();" value="N">중복확인</button>
				</div>
				<br /> <br />
				<!-- 중복 체크 안할 시 회원가입 불가 -->
				<input type="hidden" name="checked_id" value=""> <input
					type="hidden" name="checked_email" value="">
				<button class="btn btn-danger" type="button" id="cancle">취소</button>
				<button class="btn btn-success" type="submit" id="submit">회원가입</button>
			</form>

		</section>
	</div>
</body>

</html>