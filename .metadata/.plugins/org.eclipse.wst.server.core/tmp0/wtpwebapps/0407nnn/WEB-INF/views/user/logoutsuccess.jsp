<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그아웃</title>
</head>
<body>
	<script>
		sessionStorage.clear();
		alert("로그아웃 되었습니다. 홈으로 돌아갑니다."); // 로그아웃 경고 창 띄움
		document.location.href = "/mvc/index.jsp"
	</script>
</body>
</html>