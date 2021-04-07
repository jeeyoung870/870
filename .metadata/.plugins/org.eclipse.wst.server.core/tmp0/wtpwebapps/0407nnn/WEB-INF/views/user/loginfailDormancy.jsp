<!-- loginfail.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>직원 관리</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
<script>
		alert("1년 이상 미접속으로 휴면상태인 계정입니다.\n관리자에게 휴면 해제를 문의 해주시기 바랍니다.\n아이디 또는 비밀번호를 확인해주세요!\n로그인 페이지로 돌아갑니다.");
		document.location.href = "/mvc/user/loginform"
	</script>
</body>
</html>
