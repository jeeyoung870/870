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
	alert("로그인에 실패했답니다..ㅠㅠ\n아이디 또는 비밀번호를 확인해주세요!\n로그인 페이지로 돌아갑니다. \n\n장기간 미접속이셨던 경우 관리자에게 휴면 해제 문의부탁드립니다.");
		document.location.href = "/mvc/user/loginform"
	</script>
</body>
</html>
