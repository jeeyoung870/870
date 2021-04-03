<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 실패</title>
</head>
<body>
	<script>
		alert("이메일 또는 이메일이 중복입니다. 다시 입력해 주세요."); // 로그아웃 경고 창 띄움
		document.location.href = "/mvc/user/user/register.jsp"
	</script>
</body>
</html>