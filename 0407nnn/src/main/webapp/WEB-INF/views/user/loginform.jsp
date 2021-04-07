<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
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
<script type="text/javascript">
	$(document).ready(function() {
		// 취소
		$("#cancle").on("click", function() {
			location.href = "/mvc/index.jsp";
		})
	});
</script>
</head>
<body>
	<div class="wrap">

		<h2>로그인</h2>
		<p>서비스 사용을 위해서 로그인해야 합니다.😀</p>
		<br />

		<form role="form" method="post" action="j_spring_security_check">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <label class="control-label"
				for="user_id">아이디</label> <input type="text" class="form-control"
				id="user_id" name="user_id" placeholder="아이디를 입력해주세요^^"
				required="required"><br /> <label class="control-label"
				for="password">패스워드</label> <input type="password"
				class="form-control" id="password" name="password"
				placeholder="비밀번호를 입력해주세요^^" required="required"><br />

			<button class="btn btn-danger" type="button" id="cancle">취소</button>
			<button class="btn btn-success" type="submit" id="submit">로그인</button>
		</form>
	</div>
</body>
</html>