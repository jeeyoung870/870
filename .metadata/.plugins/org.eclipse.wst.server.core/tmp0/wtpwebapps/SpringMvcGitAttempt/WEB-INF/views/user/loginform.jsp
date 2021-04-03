<!-- loginform.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.js"></script>
<style>
#generallogin {
	border: 17px solid lightblue;
	padding: 5px 20px;
	position: absolute;
	top: 35%;
	left: 50%;
	width: 340px;
	height: 420px;
	margin-left: -220px;
	margin-top: -170px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

h1 {
	font-size: 30px;
	padding-bottom: 20px;
}

.form {
	width: 300px;
}

.form>div {
	display: flex;
	justify-content: center;
	padding-bottom: 7px;
	align-items: center;
}

label {
	flex: 1;
	text-align: left
}

input {
	padding: 5px;
}
</style>
<head>
<meta charset="UTF-8">

<title>로그인 페이지</title>
</head>
<script type="text/javascript">
$(document).ready(function() {
		// 취소
		$("#cancle").on("click", function() {
			location.href = "/mvc/index.jsp";
		})
		});
</script>
<body>
	<div id="generallogin">

		<h2>로그인</h2>
		<p>서비스 사용을 위해서 로그인해야 합니다.</p><br />

		<form role="form" method="post" action="j_spring_security_check">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<label class="control-label">아이디</label> <input type="text"
				class="form-control" id="id" name="user_id"
				placeholder="아이디를 입력해주세요 ^^" required="required"><br /> <label
				class="control-label" for="user_pw">패스워드</label> <input
				type="password" class="form-control" id="pw" name="password"
				placeholder="비밀번호를 입력해주세요 ^^" required="required"><br />
			<button class="btn btn-danger" type="button" id="cancle">취소</button>
			<button class="btn btn-success" type="submit" id="submit">로그인</button>
		</form>
	</div>
</body>
</html>